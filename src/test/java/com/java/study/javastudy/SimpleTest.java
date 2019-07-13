package com.java.study.javastudy;


import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.*;

public class SimpleTest {


    @Test
    public void regPattern() {
        for (String p :
                System.getProperties().stringPropertyNames()) {
            String value = System.getProperty(p);
            if (value.contains("D:\\JavaProgramFiles\\Maven\\repository")) {
                System.out.println(p+"============="+value);
                for (String a: value.split(";")
                ) {
                    System.out.println(a);
                }
            }
        }


        System.out.println(23/4);
    }


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                Integer k = map.get(s.charAt(j));
                i = Math.max(k, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }



    public int lengthOfLongestSubstring(String s) {
        char[] array = Optional.ofNullable(s).orElse("").toCharArray();
        int length = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }else {
                length=list.size()>length?list.size():length;
                while (!list.remove().equals(array[i])) {
                }
                list.add(array[i]);
            }
        }
        return list.size()>length?list.size():length;
    }

    @Test
    public void apiGetTest() {
        /** api 生成工具测试方法 */
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\JavaWorkSpace\\JavaStudy");
        Docs.buildHtmlDocs(config);
    }

    @Test
    public void decode() {
        byte[] decode = Base64.getDecoder().decode("adas");
        byte[] encode = Base64.getEncoder().encode("abs".getBytes());
        System.out.println(new String(decode));
        System.out.println(new String(encode));
        byte[] decode2 = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode2));

    }


//    @Test
    public void contextLoads() throws IOException {
        File file = new File("e://debug_s24.log");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e://debug_s24.log"));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            str = bufferedReader.readLine();
//            System.out.println(str);
            String newStr = str.substring((str.indexOf("新文件名：") + 5), (str.indexOf(",压缩图片名"))) + "====" + str.substring((str.indexOf(",压缩图片名") + 7));
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
        proxyClass.my("参数1", "参数2", "参数3", "参数2");
        System.out.println("====================================================");
        proxyClass.my2("参数1", "参数2", "参数3", "参数2");
        System.out.println("====================================================");
        proxyClass.noAnno("参数1", "参数2", "参数3", "参数2");


    }


}
