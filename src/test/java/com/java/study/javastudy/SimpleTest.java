package com.java.study.javastudy;


import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.java.study.javastudy.annotations.MyMethodLog;
import com.java.study.javastudy.controller.JavaJarRelyOnBean;
import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    @Test
    public void testStringUtils() throws NoSuchMethodException {


        Type type = JavaJarRelyOnBean.class.getMethod("test3").getGenericReturnType();


    }

    @Test
    public void testReadTxt() throws IOException {

        FileInputStream file = new FileInputStream(new File("C:\\Users\\xuyuansheng\\Desktop\\maven-tag.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String  line =null;
        StringBuffer stringBuffer=new StringBuffer();
        while ((line=reader.readLine())!=null){
            String str = StringUtils.replacePattern(line, "<.*/>", line.trim()+"content"+line.trim());
            stringBuffer.append(str).append("\n");
        }
        String a = stringBuffer.toString();
    }

    @Test
    public void testAnno() throws NoSuchMethodException {

        RequestMapping map = JavaJarRelyOnBean.class.getAnnotation(RequestMapping.class);
        String[] value = map.value();
        String[] path = map.path();
        String name = map.name();

        Method test1M = JavaJarRelyOnBean.class.getDeclaredMethod("test1", String.class, Integer.class);
        boolean f1 = test1M.isAnnotationPresent(MyMethodLog.class);
        RequestParam ano1 = test1M.getDeclaredAnnotation(RequestParam.class);
        Parameter[] par = test1M.getParameters();
        for (Parameter p :
                par) {
            Annotation[] annos = p.getAnnotations();
            AnnotatedType anoot = p.getAnnotatedType();
            Type paT = p.getParameterizedType();
            System.out.println(annos);
        }
        System.out.println("");

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
