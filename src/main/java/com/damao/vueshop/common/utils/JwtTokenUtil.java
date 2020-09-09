package com.damao.vueshop.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author 大毛
 * @date 3/31/20 11:41 AM
 */
@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${jwt.secret}")
    private String secret = "daimao";

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.currentTimeMillis}")
    private String jwtCurrentTimeMillis;


    /**
     * 生成token
     *
     * @param id          memberId
     * @param currentTimeMillis 生成token的时间戳
     * @return
     */
    public String generateToken(Long id, String currentTimeMillis) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withClaim("id", id)
                    .withClaim(jwtCurrentTimeMillis, currentTimeMillis)
                    .withExpiresAt(generateExpirationDate()).sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }

    /**
     * 生成token过期时间
     *
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


    /**
     * 校验token的正确性
     * 没有异常代表正确
     *
     * @param token
     * @param id
     * @return
     */
    public boolean validateToken(String token, Long id) {
        try {
            Algorithm algorithm = algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("id", id).build();
            verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new JwtTokenUtil().validateToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI" +
                "1NiJ9.eyJqd3RDdXJyZW50VGltZU1pbGxpcyI6IjE1ODY5Mzk0OTE" +
                "0NjQiLCJleHAiOjE1ODY5Mzk1NTEsIm1lbWJlcklkIjoyNDEzNzEyMTkxfQ.Yr" +
                "SvF2vCixvuIbPs5RzaE8LNm1EMZ0t1oiXzvKz6q30", 2413712191L));
    }

    /**
     * 通过token获取id
     *
     * @param token
     * @return
     */
    public Long getIdByToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("id").asLong();
    }

    /**
     * 通过token获取时间戳
     *
     * @param token
     * @return
     */
    public Long getJwtCurrentTimeMillisByToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(jwtCurrentTimeMillis).asLong();
    }


}
