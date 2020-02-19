package com.java.study.javastudy.encryption;


import org.apache.commons.crypto.stream.CryptoInputStream;
import org.apache.commons.crypto.stream.CryptoOutputStream;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;


/**
 * aes算法
 * 显示如何使用流加密和解密的示例。
 *
 * @author Mr.Xu
 * @date 2019/12/11 22:04
 */
public class StreamExample {

    public static void main(String[] args) throws IOException {
        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("12345678901234561234567890123456"), "AES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));
        final String transform = "AES/CBC/PKCS5Padding";

        String input = "我是嘿哈唉!";
        //Encryption with CryptoOutputStream.

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (CryptoOutputStream cos = new CryptoOutputStream(transform, new Properties(), outputStream, key, iv)) {
            cos.write(getUTF8Bytes(input));
            cos.flush();
        }

        // The encrypted data:
        System.out.println("Encrypted: " + Arrays.toString(outputStream.toByteArray()));
        String encodeToString = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        System.out.println("encodeToString: " + Arrays.toString(encodeToString.getBytes(StandardCharsets.UTF_8)));

        System.out.println("result: " + Arrays.toString(Base64.getDecoder().decode(encodeToString)));
        InputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(encodeToString));
        // Decryption with CryptoInputStream.
        try (CryptoInputStream cis = new CryptoInputStream(transform, new Properties(), inputStream, key, iv)) {
            byte[] decryptedData = new byte[1024];
            int decryptedLen = 0;
            int i;
            while ((i = cis.read(decryptedData, decryptedLen, decryptedData.length - decryptedLen)) > -1) {
                decryptedLen += i;
            }
            System.out.println("Decrypted: " + new String(decryptedData, 0, decryptedLen, StandardCharsets.UTF_8));
        }
    }

    /**
     * Converts String to UTF8 bytes
     *
     * @param input the input string
     * @return UTF8 bytes
     */
    private static byte[] getUTF8Bytes(String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

}
