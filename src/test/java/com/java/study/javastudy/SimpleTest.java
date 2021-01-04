package com.java.study.javastudy;


import com.google.gson.JsonArray;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    @Test
    public void test() throws Exception {

        System.out.println(decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        /*  s = "3[a]2[bc]"  "ab3[a2[c]a2[c]]"  [ 91 , ] 93 */
        return getString(s, 0);
    }


    String getString(String s, int start) {

        /*  s = "3[a]2[bc]"  "ab3[a2[c]a2[c]]"  [ 91 , ] 93 */
        StringBuilder tempStr = new StringBuilder();
        StringBuilder tempDigit = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                tempDigit.append(c);
            } else if (Character.isAlphabetic(c)) {
                tempStr.append(c);
            } else if ('[' == c) {
                String string = getString(s, i + 1);
                String buildStr = Stream.generate(() -> string).limit(Integer.parseInt(tempDigit.toString())).collect(Collectors.joining());
                tempStr.append(buildStr);
            } else if (']' == c) {
                if (tempDigit.length() == 0) {
                    return tempStr.toString();
                }
                tempDigit.setLength(0);
            }
        }

        return tempStr.toString();
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

}
