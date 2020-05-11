package org.csu.api.service.StatisticService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 代码行数统计
 * @author ThinkGem
 * @version 2014-7-22
 */
public class CodeCounter {

    /**
     * 代码行数统计
     */
    /**
     * 统计方法
     * @param f
     */
    public static long count(File f) {

         long codeLines = 0;
         long commentLines = 0;//注释行数
         long blankLines = 0;//空白行数
        BufferedReader br = null;
        boolean isComment = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim(); // 除去注释前的空格
                if (line.matches("^[ ]*$")) { // 匹配空行
                    blankLines++;
                } else if (line.startsWith("//")) {
                    commentLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    commentLines++;
                    isComment = true;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentLines++;
                } else if (isComment == true) {
                    commentLines++;
                    if (line.endsWith("*/")) {
                        isComment = false;
                    }
                } else {
                    codeLines++;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return codeLines;
        }

    }



    public static long countStuct(File f,String structName) {

        long codeLines = 0;
        BufferedReader br = null;
        boolean isStruct = false;
        String lineStart = "type " + structName + " struct";
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim(); // 除去注释前的空格
                if (line.startsWith(lineStart) && !line.endsWith("}")) {
                    codeLines++;
                    isStruct = true;
                } else if (line.startsWith(lineStart) && line.endsWith("}")) {
                    codeLines++;
                } else if (isStruct == true) {
                    codeLines++;
                    if (line.endsWith("}")) {
                        isStruct = false;
                    }
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return codeLines;
        }
    }
}