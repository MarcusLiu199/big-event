package com.mingkun.big_event;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTest {
    
    private static final Logger logger = LoggerFactory.getLogger(JwtTest.class);

    @Test
    public void testGen() {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        
        // 生成jwt代码
        String token = JWT.create()
            .withClaim("user", claims)  // 添加载荷
            .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加过期时间
            .sign(Algorithm.HMAC256("password")); // 制定算法，配置密钥
        
        // Use logger to log the token
        logger.info("Generated JWT: {}", token);

        // Print token to console
        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定义字符串，模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
            + ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MjA1Nzc5MzR9"
            + ".5n70-ulnGw5SRGa7Bj7rFYwwGG-67upHsmLn3DxZKLI";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("password")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        // 如果篡改了头部和载荷部分的数据，验证失败
        // 修改密钥也会验证失败
        // token过期 
    }
}
