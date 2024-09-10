package org.example.ssm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET_KEY = "ssm";

    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    //parseToken
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
