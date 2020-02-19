package com.java.study.javastudy.encryption;

import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.stream.CryptoInputStream;
import org.apache.commons.crypto.stream.CryptoOutputStream;
import org.apache.commons.crypto.utils.Utils;
import org.springframework.util.StopWatch;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Base64;
import java.util.Properties;

/**
 * AES加解密工具
 *
 * @author Mr.Xu
 * @date 2019/12/12 9:57
 */
public class DesUtils {


    public static void main(String[] args) throws IOException {
        String key = "12345678901234561234567890123啊";
        String iv = "1234567890123456";
        String iv2 = "1234567890123458";

        String enOrdeStr = "Email : wfung_kwok@xxx.com";
        StopWatch stopWatch = new StopWatch("1");
        stopWatch.start();
        String ciphertext = AesUtils.encryptOrDecryptString(1, key, iv, enOrdeStr);
        stopWatch.stop();
        stopWatch.start();
        String plaintext = AesUtils.encryptOrDecryptString(2, key, iv, ciphertext);
        stopWatch.stop();
        System.out.println("解密后结果:" + plaintext);
        System.out.println(stopWatch.prettyPrint());
    }


    public static String encryptOrDecryptString(int mode, String keyStr, String ivStr, String encryptOrDecryptString) throws IOException {
        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes(keyStr), "DES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes(ivStr));
        if (Cipher.ENCRYPT_MODE == mode) {
            return encryptionWithCryptoOutputStream(key, iv, new Properties(), encryptOrDecryptString);
        } else if (Cipher.DECRYPT_MODE == mode) {
            return decryptionWithCryptoInputStream(key, iv, new Properties(), encryptOrDecryptString);
        } else {
            throw new RuntimeException("请指定正确的操作模式 : mode !");
        }
    }

    private static String encryptionWithCryptoOutputStream(SecretKeySpec key, IvParameterSpec iv, Properties properties, String enStr) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            /*  Encryption with CryptoOutputStream. */
            try (CryptoOutputStream cos = new CryptoOutputStream(TRANSFORM, properties, outputStream, key, iv)) {
                cos.write(getUTF8Bytes(enStr));
                cos.flush();
            }
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } finally {
            outputStream.close();
        }
    }

    private static String decryptionWithCryptoInputStream(SecretKeySpec key, IvParameterSpec iv, Properties properties, String decryptionStr) throws IOException {
        /*   Decryption with CryptoInputStream. */
        InputStream inputStream = new ByteArrayInputStream(Base64.getDecoder().decode(decryptionStr));
        try (CryptoInputStream cis = new CryptoInputStream(TRANSFORM, properties, inputStream, key, iv)) {
            byte[] decryptedData = new byte[1024];
            int decryptedLen = 0;
            int i;
            while ((i = cis.read(decryptedData, decryptedLen, decryptedData.length - decryptedLen)) > -1) {
                decryptedLen += i;
            }
            String resultStr = new String(decryptedData, 0, decryptedLen, StandardCharsets.UTF_8);
            return resultStr;
        } finally {
            inputStream.close();
        }
    }

    private static String encryptionWithByteBuffer(SecretKeySpec key, IvParameterSpec iv, Properties properties, String enStr) throws IOException {

        ByteBuffer outBuffer;
        int updateBytes;
        int finalBytes;
        try (CryptoCipher encipher = Utils.getCipherInstance(TRANSFORM, properties)) {
            ByteBuffer inBuffer = ByteBuffer.allocateDirect(102);
            outBuffer = ByteBuffer.allocateDirect(102);
            inBuffer.put(getUTF8Bytes(enStr));

            inBuffer.flip(); // ready for the cipher to read it

            // Initializes the cipher with ENCRYPT_MODE,key and iv.
            encipher.init(Cipher.ENCRYPT_MODE, key, iv);
            // Continues a multiple-part encryption/decryption operation for byte buffer.
            updateBytes = encipher.update(inBuffer, outBuffer);
            System.out.println(updateBytes);

            // We should call do final at the end of encryption/decryption.
            finalBytes = encipher.doFinal(inBuffer, outBuffer);

            outBuffer.flip(); // ready for use as decrypt
            byte[] encoded = new byte[updateBytes + finalBytes];
            outBuffer.duplicate().get(encoded);
            return Base64.getEncoder().encodeToString(encoded);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static final String TRANSFORM = "DES/CBC/PKCS5Padding";

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
