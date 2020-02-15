package com.java.study.javastudy;


import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {


    @Test
    public void test() throws IOException {

        String s = JSON.parseObject(null, String.class);
        System.out.println(s);


    }


    @Test
    public void testBinary() {

        String hahei = "哈黑";
        byte[] ha = hahei.getBytes(StandardCharsets.UTF_8);
        char[] chars = hahei.toCharArray();

        byte[] resultC = new byte[3];


        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Long aLong = Long.valueOf(aChar);
            int j = 0;
            resultC[j++] = (byte) (224 | aChar >> 12);
            resultC[j++] = (byte) (128 | aChar >> 6 & 63);
            resultC[j++] = (byte) (128 | aChar & 63);
            System.out.println(aChar + "  " + aLong);
        }

        /*  utf8的中文字符编码范围 */
        int index = 0x4e00;
        int size = 0x9fa5;
        for (int i = index; i < size; i++) {
            char c = (char) i;
            System.out.println(c + "  " + i);
        }

        /*  十进制转换为二进制 */
        for (int i = 99; i < 166; i++) {
            String s = Integer.toBinaryString(i);
            int ys = i % 2;
            int ss = i / 2;
            StringBuffer resultBinary = new StringBuffer().append(ys);
            while (ss > 0) {
                ys = ss % 2;
                ss = ss / 2;
                resultBinary.insert(0, ys);
            }
            System.out.println(String.format("%s==%s", s, resultBinary));
        }

    }


    @Test
    public void testBase64() throws Exception {

        byte[] ha_encode = Base64.getEncoder().encode("abcdefghij".getBytes());
        byte[] ha_decode = Base64.getDecoder().decode(ha_encode);
        String ha_string = new String(ha_decode);
        String encode = Base64.getEncoder().encodeToString("abcdefghi".getBytes());
        short s0 = (short) 15;
        short s1 = 5;
//        throw new StreamCorruptedException(
//                String.format("invalid stream header: %04X%04X", s0, s1));
        String a = String.format("invalid stream header: %04X%04X", s0, s1);
        System.out.println(a);
    }


    @Test
    public void testReadTxt() throws IOException {

        FileInputStream file = new FileInputStream(new File("C:\\Users\\xuyuansheng\\Desktop\\maven-tag.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            String str = StringUtils.replacePattern(line, "<.*/>", line.trim() + "content" + line.trim());
            stringBuffer.append(str).append("\n");
        }
        String a = stringBuffer.toString();
    }

    @Test
    public void testAnno() throws NoSuchMethodException {


    }


    public static void main(String[] args) {
        Set set = new HashSet();
        System.out.println("BootstrapClassLoader 的加载路径: ");

        //String[] bootUrls = System.getProperty("sun.boot.class.path").split(";");

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        set.addAll(Stream.of(urls).collect(Collectors.toList()));
        for (URL url : urls)
            System.out.println(url);

        System.out.println("----------------------------");

        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();

        System.out.println(extClassLoader);
        System.out.println("扩展类加载器 的加载路径: ");

        urls = extClassLoader.getURLs();
        set.addAll(Stream.of(urls).collect(Collectors.toList()));
        for (URL url : urls)
            System.out.println(url);

        System.out.println("----------------------------");


        //取得应用(系统)类加载器
        URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

        System.out.println(appClassLoader);
        System.out.println("应用(系统)类加载器 的加载路径: ");

        urls = appClassLoader.getURLs();
        set.addAll(Stream.of(urls).collect(Collectors.toList()));
        for (URL url : urls)
            System.out.println(url);

        System.out.println("----------------------------");
        System.out.println(JSON.toJSONString(set));
    }


    @Test
    public void regPattern() {
        JsonArray jsonArray = new JsonArray();
        for (String p :
                System.getProperties().stringPropertyNames()) {
            String value = System.getProperty(p);
            if (value.contains("D:\\JavaProgramFiles\\Maven\\repository")) {
                for (String a : value.split(";")
                ) {
                    System.out.println(a);
                    jsonArray.add(a);

                }
            }
        }
        jsonArray.toString();

        System.out.println(23 / 4);
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
            } else {
                length = list.size() > length ? list.size() : length;
                while (!list.remove().equals(array[i])) {
                }
                list.add(array[i]);
            }
        }
        return list.size() > length ? list.size() : length;
    }

    @Test
    public void apiGetTest() {

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


}
