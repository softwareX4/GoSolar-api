package org.csu.api.service.StatisticService;

import org.csu.api.dto.FileDTO;
import org.csu.api.dto.StructDTO;
import org.csu.api.service.AnalyseService.Analysor.FileAnalysorThread;
import org.csu.api.util.AppConst;
import org.csu.api.util.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;


//解析模块的多线程 + 构建Code Tree为存储对象
@Service
public class FileTraverseTree {



    private static class FindGoVisitor extends SimpleFileVisitor<Path> {


        //创建线程池对象
        private ExecutorService executorService;

        private List<Future<FileDTO>> futures;

        // 1.定义CompletionService
        CompletionService<FileDTO> completionService;

        public FindGoVisitor() throws IOException {

            //创建线程池对象

            this.executorService = Executors.newFixedThreadPool(AppConst.nThread);

            this.futures = new ArrayList<>();
            this.completionService = new ExecutorCompletionService<FileDTO>(executorService);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            //找到go文件就创建线程任务
            if (file.toString().endsWith(".go")) {

                //创建有返回值的任务
                FileAnalysorThread ft = new FileAnalysorThread(file.toString());
                //提交任务
               /* Future<FileDTO> future = executorService.submit(ft);
                futures.add(future);*/

                Future<FileDTO> future = completionService.submit(ft);
                futures.add(future);
            }

            return FileVisitResult.CONTINUE;
        }


        //访问文件夹之前自动调用此方法
     /*   @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println(dir.getParent());
            return FileVisitResult.CONTINUE;
        }
*/

        public  void analyse(Node<NodeEntity> root){




            List<Node<NodeEntity>> nodeEntityList = new ArrayList<>();

            CodeTree codeTree = new CodeTree();
            codeTree.initial(root);

            for(Future<FileDTO> future : futures){
                try {
                    //FileDTO fileDTO = future.get();
                    //获取并移除已完成状态的task，如果目前不存在这样的task，则等待；
                    FileDTO fileDTO = completionService.take().get();

                    //新建File类型节点
                    NodeEntity entity = new NodeEntity(AppConst.Type.FILE,fileDTO.getName());
                    entity.setSrc(fileDTO.getFileFeature().getSrc());
                    entity.setFeature(fileDTO.getFileFeature());
                    Node<NodeEntity> fileNode = new Node<>(entity);

                    //将内部Struct节点挂为子结点
                    for(StructDTO structDTO : fileDTO.getStructs()){
                        NodeEntity sn = new NodeEntity(AppConst.Type.STRUCT,structDTO.getName());
                        sn.setFeature(structDTO.getFeature());
                        sn.setSrc(entity.getSrc());
                        Node<NodeEntity> structNode = new Node<>(sn);

                        fileNode.addChildNode(structNode);
                        structNode.setParentNode(fileNode);
                    }


                    nodeEntityList.add(fileNode);

                    codeTree.changeEntity(fileNode);

                    //System.out.println(fileNode);


                    filecnt++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }


            /*
            for(Node<NodeEntity> node : nodeEntityList){
                codeTree.changeEntity(node);
            }*//*
            List<Future> trees = new ArrayList<>();
            for(Node<NodeEntity> node : nodeEntityList){

                //创建有返回值的任务
                CodeTreeThread ft = new CodeTreeThread(codeTree.dic,node);
                //提交任务
                Future future = executorService.submit(ft);
                trees.add(future);

            }
            for(Future future : trees){
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }*/

            executorService.shutdown();
        }
    }



    private static int filecnt = 0;
    private  static Boolean hasGoFile = false;
    /*
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir, Node<NodeEntity> node)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }


        File[] files=dir.listFiles();

        if(files!=null&&files.length>0){

            for(File file:files){
                if(file.isDirectory()){
                    NodeEntity nodeEntity = new NodeEntity(AppConst.Type.PACKAGE,file.getName());
                    nodeEntity.setSrc(file.getPath());
                    Node<NodeEntity> n = new Node<NodeEntity>(nodeEntity);
                    //递归
                    listDirectory(file,n);

                    if(hasGoFile){
                        n.setParentNode(node);
                        node.addChildNode(n);

                    }

                }
                else if(file.getName().endsWith(".go")){
                    //这里只分析项目结构，具体的信息等多线程分析
                    hasGoFile = true;
                    filecnt++;
                    NodeEntity nodeEntity = new NodeEntity(AppConst.Type.FILE,file.getName());
                    nodeEntity.setSrc(file.getPath());
                    Node n = new Node(nodeEntity);
                    n.setParentNode(node);
                    node.addChildNode(n);

                }
                else {
                    hasGoFile = false;
                }

            }
        }
    }


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public  Node<NodeEntity> analyse(String rootPath) throws IOException {

        long startTime = System.currentTimeMillis();    //获取开始时间
        //System.out.println(Runtime.getRuntime().availableProcessors());

        File rootFile = new File(rootPath);
        Path startingDir = Paths.get(rootPath);

        NodeEntity nodeEntity = new NodeEntity(AppConst.Type.PACKAGE,rootFile.getName());
        nodeEntity.setSrc(rootFile.getPath());
        Node<NodeEntity> root = new Node<>(nodeEntity);

        //搭建树初始结构
        FileTraverseTree.listDirectory(rootFile, root);

        FindGoVisitor findJavaVisitor = new FindGoVisitor();
        Files.walkFileTree(startingDir, findJavaVisitor);
        findJavaVisitor.analyse(root);
        root.displaytree(root,0);

        System.out.println("go 文件个数 ："+ FileTraverseTree.filecnt);

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

        logger.info("程序运行时间：" + (endTime - startTime) + "ms");
        return root;
    }
    public static void main(String[] args)throws IOException {

        String rootPath = "G:\\AAApersonal\\毕设\\project\\kubernetes-master\\pkg\\controller";
        new FileTraverseTree().analyse(rootPath);

    }

}
