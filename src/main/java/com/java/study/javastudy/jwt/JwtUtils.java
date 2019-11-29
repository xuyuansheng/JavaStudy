package com.java.study.javastudy.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.UUID;

/**
 * @program: java-study
 * @description: jwt工具类
 * @author: Mr.Xu
 * @create: 2019/11/27 15:22
 */
public class JwtUtils {

    public static void main(String[] args) {
        long expDate = LocalDateTime.now().plusMinutes(15).toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(getWorldPayJwt("5bd9b55e4444761ac0af1c80", String.valueOf(expDate), "fa2daee2-1fbb-45ff-4444-52805d5cd9e0"));
    }

    public static String getWorldPayJwt(String orgUnitId, String expireDate, String secret) {

        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        HashMap<String, String> claim = new HashMap<>(5);
        claim.put("jti", UUID.randomUUID().toString());
        /*  生成JWT的时间（以秒为单位-10位数）。有效期为两个小时  worldPay技术建议减2分钟 */
        long iat = LocalDateTime.now().minusMinutes(2).toEpochSecond(ZoneOffset.of("+8"));
        claim.put("iat", String.valueOf(iat));
        /*  发行JWT的人的标识符。在测试中使用“ 5bd9e0e4444dce153428c940” */
        claim.put("iss", "5bd9e0e4444dce153428c940");
        /*   应将JWT视为过期的数字纪元时间（以秒为单位-10位数字）。未来两小时以上的任何时间都将被忽略 */
        claim.put("exp", expireDate);
        /*  与您的帐户关联的身份。在测试中使用“ 5bd9b55e4444761ac0af1c80” */
        claim.put("OrgUnitId", orgUnitId);

        return getJwtString(header, claim, secret);
    }


    /**
     * 获取jwt  秘钥默认使用 123456
     *
     * @param header 头数据
     * @param claim  body数据
     * @return
     */
    public static String getJwtString(HashMap<String, Object> header, HashMap<String, String> claim) {
        return getJwtString(header, claim, "123456");
    }

    /**
     * 获取jwt token
     *
     * @param header 头数据
     * @param claim  body数据
     * @param secret 秘钥
     * @return
     */
    public static String getJwtString(HashMap<String, Object> header, HashMap<String, String> claim, String secret) {
        JWTCreator.Builder builder = JWT.create().withHeader(header);
        claim.entrySet().forEach(c -> builder.withClaim(c.getKey(), c.getValue()));
        String token = builder.sign(getAlgorithm(header, secret));
        return token;
    }


    private static Algorithm getAlgorithm(HashMap<String, Object> header, String secret) {
        String alg = (String) header.get("alg");
        return getAlgorithm(alg, secret);
    }

    /**
     * 获取使用的算法  alg默认使用 HS512
     *
     * @param alg    使用的算法
     * @param secret 秘钥
     * @return
     */
    private static Algorithm getAlgorithm(String alg, String secret) {
        if (StringUtils.isBlank(alg)) {
            return Algorithm.HMAC512(secret);
        }
        switch (alg) {
            case "HS512":
                return Algorithm.HMAC512(secret);
            case "HS256":
                return Algorithm.HMAC256(secret);
            case "HS384":
                return Algorithm.HMAC384(secret);
            default:
                return getAlgorithm("HS512", secret);
        }
    }

}
