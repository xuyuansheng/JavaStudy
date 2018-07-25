package com.java.study.javastudy.controller;

import com.java.study.javastudy.bean.FastJsonErrorBean;


import java.io.File;
import java.io.FileInputStream;

public class FastJsonError {


    public static void main(String[] args) throws Exception{
        FastJsonErrorBean bean = new FastJsonErrorBean();
        File file = new File("D://font.txt");

        FileInputStream fileIn = new FileInputStream(file);
        int length = (int) file.length();
        byte[] aaa = new byte[length];
        fileIn.read(aaa);
        System.out.println(new String(aaa));
    }


}
