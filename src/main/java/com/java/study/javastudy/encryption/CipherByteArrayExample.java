package com.java.study.javastudy.encryption;


import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.cipher.CryptoCipherFactory;
import org.apache.commons.crypto.cipher.CryptoCipherFactory.CipherProvider;
import org.apache.commons.crypto.utils.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

/**
 * 字节数组aes加解密
 *
 * @author Mr.Xu
 * @date 2019/12/11 22:19
 */
public class CipherByteArrayExample {

    public static void main(String[] args) throws Exception {

        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));

        Properties properties = new Properties();
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CipherProvider.OPENSSL.getClassName());
        //Creates a CryptoCipher instance with the transformation and properties.
        // 使用转换和属性创建一个CryptoCipher实例。
        final String transform = "AES/CBC/PKCS5Padding";
        CryptoCipher encipher = Utils.getCipherInstance(transform, properties);
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        final String sampleInput = "hello world!";
        System.out.println("input:  " + sampleInput);

        byte[] input = getUTF8Bytes(sampleInput);
        byte[] output = new byte[32];

        //Initializes the cipher with ENCRYPT_MODE, key and iv.
        // 用ENCRYPT_MODE，密钥和iv初始化密码
        encipher.init(Cipher.ENCRYPT_MODE, key, iv);
        //Continues a multiple-part encryption/decryption operation for byte array.
        //继续字节数组的多部分加密/解密操作。
        int updateBytes = encipher.update(input, 0, input.length, output, 0);
        System.out.println(updateBytes);
        //We must call doFinal at the end of encryption/decryption.
        // 我们必须在加密/解密结束时调用doFinal。
        int finalBytes = encipher.doFinal(input, 0, 0, output, updateBytes);
        System.out.println(finalBytes);
        //Closes the cipher.
        encipher.close();

        System.out.println(Arrays.toString(Arrays.copyOf(output, updateBytes + finalBytes)));

        // Now reverse the process using a different implementation with the same settings
        // 我们必须在加密/解密结束时调用doFinal。
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CipherProvider.JCE.getClassName());
        CryptoCipher decipher = Utils.getCipherInstance(transform, properties);
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        decipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decoded = new byte[32];
        decipher.doFinal(output, 0, updateBytes + finalBytes, decoded, 0);

        System.out.println("output: " + new String(decoded, StandardCharsets.UTF_8));
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

