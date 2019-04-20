package com.java.study.javastudy;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.Base64;

public class SimpleTest {

    @Test
    public void decode(){
        byte[] decode = Base64.getDecoder().decode("adas");
        byte[] encode = Base64.getEncoder().encode("abs".getBytes());
        System.out.println(new String(decode));
        System.out.println(new String(encode));
        byte[] decode2 = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode2));

    }


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
    @Test
    public void test() throws IOException {

        SimpleTestInterface proxyClass = (SimpleTestInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{SimpleTestInterface.class}, new MyMethodImpl(new SimpleTestInterfaceImpl()));
        proxyClass.my("参数1","参数2","参数3","参数2");
        System.out.println("====================================================");
        proxyClass.my2("参数1","参数2","参数3","参数2");
        System.out.println("====================================================");
        proxyClass.noAnno("参数1","参数2","参数3","参数2");


    }

    
}
