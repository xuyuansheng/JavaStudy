package com.java.study.javastudy.utils.encryption;

import org.apache.commons.crypto.random.CryptoRandom;
import org.apache.commons.crypto.random.CryptoRandomFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Properties;

/**
 * 官方例子
 *
 * @author Mr.Xu
 * @date 2019/12/11 22:14
 */
public class RandomExample {


    public static void main(String[] args) throws GeneralSecurityException, IOException {

        // Constructs a byte array to store random data.

        byte[] key = new byte[16];

        byte[] iv = new byte[32];


        Properties properties = new Properties();

        properties.put(CryptoRandomFactory.CLASSES_KEY,

                CryptoRandomFactory.RandomProvider.OPENSSL.getClassName());


        // Gets the 'CryptoRandom' instance.

        try (CryptoRandom random = CryptoRandomFactory.getCryptoRandom(properties)) {


            // Show the actual class (may be different from the one requested)

            System.out.println(random.getClass().getCanonicalName());


            // Generate random bytes and places them into the byte arrays.

            random.nextBytes(key);

            random.nextBytes(iv);


        }


        // Show the generated output

        System.out.println(Arrays.toString(key));

        System.out.println(Arrays.toString(iv));

    }
}
