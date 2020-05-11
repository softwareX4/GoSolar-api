package org.csu.api.service.StatisticService;

import org.csu.api.dto.FileDTO;
import org.csu.api.dto.PackageDTO;
import org.csu.api.service.AnalyseService.Analysor.FileAnalysor;
import org.csu.api.service.AnalyseService.Analysor.FileAnalysorThread;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

//FileTraverse的多线程实现 DTO结构存储
public class FileTraverseThread {
    private static int filecnt = 0;
    private  static Boolean hasGoFile = false;


    /*
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir, PackageDTO root)throws IOException {
        if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }

        File[] files=dir.listFiles();
        //for(File file:files){
        //System.out.println(file);
        if(files!=null&&files.length>0){

            List<String> filePaths = new ArrayList<>();
            for(File file:files){
                if(file.isDirectory()){
                    PackageDTO packageDTO = new PackageDTO();
                    packageDTO.setName(file.getName());

                    //递归
                    listDirectory(file,packageDTO);

                    if(hasGoFile){
                        root.getPackages().add(packageDTO);
                        System.out.println(packageDTO.toString());
                        System.out.println("package个数："+packageDTO.getPackages().size() + ",go文件个数：" + packageDTO.getFiles().size() + "\n");



                    }

                }
                else if(file.getName().endsWith(".go")){
                    //这里只分析项目结构，具体的信息等前端ajax分析

                    hasGoFile = true;
                    filePaths.add(file.getPath());

                }
                else {
                    hasGoFile = false;
                }

            }

            //目录下遍历完之后再解析文件

            //创建线程池对象
            ExecutorService executorService = Executors.newCachedThreadPool();

            List<Future<FileDTO>> futures = new ArrayList<>();
            for(String path : filePaths){

                //创建有返回值的任务
                FileAnalysorThread ft = new FileAnalysorThread(path);
                //提交任务
                Future<FileDTO> future = executorService.submit(ft);
                futures.add(future);

            }
            for(Future<FileDTO> future : futures){
                try {
                    FileDTO fileDTO = future.get();
                    root.getFiles().add(fileDTO);
                    filecnt++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executorService.shutdown();
        }
    }



    public  PackageDTO analyse(String path) throws IOException {
        long startTime = System.currentTimeMillis();    //获取开始时间

        PackageDTO root = new PackageDTO();
        root.setName("root");
        FileTraverseThread.listDirectory(new File(path),root);
        //"D:\\go_visualize\\demo1"
        System.out.println("go 文件个数 ："+ FileTraverseThread.filecnt);
        System.out.println(root.toString());
        System.out.println("package个数："+root.getPackages().size() + ",go文件个数：" + root.getFiles().size() + "\n");

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        return root;

    }

    public static void main(String[] args)throws IOException {
        long startTime = System.currentTimeMillis();    //获取开始时间

        PackageDTO root = new PackageDTO();
        root.setName("root");
        FileTraverseThread.listDirectory(new File("G:\\AAApersonal\\毕设\\project\\kubernetes-master\\pkg\\controller"),root);
        //"D:\\go_visualize\\demo1"
        System.out.println("go 文件个数 ："+ FileTraverseThread.filecnt);
        System.out.println(root.toString());
        System.out.println("package个数："+root.getPackages().size() + ",go文件个数：" + root.getFiles().size() + "\n");

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }


}
