package org.csu.api.service.AnalyseService.Analysor;
import org.csu.api.dto.FileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Callable;


//FileAnalysor的多线程类
public class FileAnalysorThread implements Callable<FileDTO> {
    private String path;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    public FileAnalysorThread(String path){
        this.path = path;
    }

@Override
    public FileDTO call(){
    try {

        long startTime = System.currentTimeMillis();    //获取开始时间

        FileDTO fileDTO =  FileAnalysor.FunctionListener.analyse(path);

        long endTime = System.currentTimeMillis();    //获取结束时间
        //System.out.println("分析：" + path + "，\t 用时：" + (endTime - startTime) + "ms");    //输出程序运行时间
        logger.info(" 用时：" + (endTime - startTime) + "ms,  分析：" + path );
        return fileDTO;

    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
    }
}
