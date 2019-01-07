package com.java.study.javastudy;


import org.junit.Test;

import java.io.*;

public class SimpleTest {
    @Test
    public void contextLoads() throws IOException {
        File file=new File("e://debug_s24.log");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        BufferedWriter  bufferedWriter = new BufferedWriter(new FileWriter("e://debug_s24.log"));
        String str=null;
        while ((str=bufferedReader.readLine())!=null){
            str=bufferedReader.readLine();
//            System.out.println(str);
           String newStr=str.substring((str.indexOf("新文件名：")+5),(str.indexOf(",压缩图片名")))+"===="+str.substring((str.indexOf(",压缩图片名")+7));
//            System.out.print(str.substring((str.indexOf("新文件名：")+5),(str.indexOf(",压缩图片名"))));
//            System.out.println("===="+str.substring((str.indexOf(",压缩图片名")+7)));
            System.out.println(newStr);
            bufferedWriter.write(newStr);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

}
