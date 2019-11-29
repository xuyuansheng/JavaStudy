package com.java.study.javastudy.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo-spring-boot-starter
 * @description:
 * @author: Mr.Xu
 * @create: 2019/11/26 16:21
 */
public class WorldPayController {

    /*  https://beta.developer.worldpay.com/docs/wpg/directintegration/3ds2 */
    public static void main(String[] args) {


        System.out.println(ZoneId.getAvailableZoneIds());
        long iat = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        System.out.println("iat : "+ iat);

    }
}
