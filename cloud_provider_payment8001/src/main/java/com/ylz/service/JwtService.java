package com.ylz.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class JwtService {
    private String secret = "966200";


    public String createToken() {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 头部信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        long currentTime = System.currentTimeMillis() ;
        Date nowDate=new Date(currentTime);
        currentTime +=120*60*1000;
        Date expireDate=new Date(currentTime);
        String token = JWT.create()
                .withHeader(map)// 设置头部信息 Header
                .withClaim("username","ylz966200")
                .withClaim("password","966200")
                .withIssuer("SERVICE")//设置 载荷 签名是有谁生成 例如 服务器
                .withSubject("this is test token")//设置 载荷 签名的主题
                .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(nowDate) //设置 载荷 生成签名的时间
                .withExpiresAt(expireDate)//设置 载荷 签名过期的时间
                .sign(algorithm);//签名 Signature
        return token;
    }

    public void verifyToken(String token)  {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("SERVICE").build(); // Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);

        Map<String, Claim> claims = jwt.getClaims();
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            String key = entry.getKey();
            Claim claim = entry.getValue();
            log.info("key:" + key + " value:" + claim.asString());
        }
        Claim claim = claims.get("username");
        log.info("获取到的密码是"+ claim.asString());
    }

}
