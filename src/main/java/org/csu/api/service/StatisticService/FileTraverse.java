package org.csu.api.service.StatisticService;

import org.csu.api.dto.FeatureDTO;
import org.csu.api.dto.FileDTO;
import org.csu.api.dto.PackageDTO;
import org.csu.api.service.AnalyseService.Analysor.FileAnalysor;
import org.csu.api.util.AppConst;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Service
//列出File的一些常用操作
public class FileTraverse {
    private static int filecnt = 0;
    private static Boolean hasGoFile = false;


    /*
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir, PackageDTO root)throws IOException {
            if(!dir.exists())
            throw new IllegalArgumentException("目录："+dir+"不存在.");
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录。");
        }
       /* String[] filenames=dir.list();//返回的是字符串数组 直接子的名称 不包含子目录
        for(String string:filenames){
            System.out.println(dir+"\\"+string);
        }
        System.out.println("计数:"+filenames.length);*/
        //如果要遍历子目录下的内容就需要构造File对象做递归操作，File提供了直接返回File对象的API
        File[] files=dir.listFiles();
        //for(File file:files){
        //System.out.println(file);
        if(files!=null&&files.length>0){
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

                    FileDTO fileDTO =  FileAnalysor.FunctionListener.analyse(file.getPath());

                    /*
                    FileDTO fileDTO = new FileDTO();
                    fileDTO.setName(file.getName());
                    fileDTO.setFileFeature(new FeatureDTO(AppConst.Type.STRUCT,file.getPath()));
                    */

                    root.getFiles().add(fileDTO);
                    filecnt++;

                    //System.out.println(file.getName() + " 代码行数：" +CodeCounter.count(file));

                   // System.out.println(file);
                }
                else {
                    hasGoFile = false;
                }

            }
        }
    }



    public  PackageDTO analyse(String path) throws IOException {
        long startTime = System.currentTimeMillis();    //获取开始时间

        PackageDTO root = new PackageDTO();
        root.setName("root");
        FileTraverse.listDirectory(new File(path),root);
        //"D:\\go_visualize\\demo1"
        System.out.println("go 文件个数 ："+ FileTraverse.filecnt);
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
            FileTraverse.listDirectory(new File("G:\\AAApersonal\\毕设\\project\\kubernetes-master\\pkg\\controller"),root);
            //"D:\\go_visualize\\demo1"
        System.out.println("go 文件个数 ："+ FileTraverse.filecnt);
        System.out.println(root.toString());
        System.out.println("package个数："+root.getPackages().size() + ",go文件个数：" + root.getFiles().size() + "\n");

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }



}