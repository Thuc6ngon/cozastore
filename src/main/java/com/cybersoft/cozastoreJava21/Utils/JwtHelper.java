package com.cybersoft.cozastoreJava21.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtHelper {
    //lay gia tri cua key khai bao ben application.yml/properties
    @Value("${jwt.secrect.key}")
    private String secretkey;
   public String  GenerateToken(String data){
       Key key= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretkey));
    String token= Jwts.builder().setSubject(data)
            .signWith(key)
            .compact();

    return token;

    }
    public Claims decodeToken(String token){
        Key key= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretkey));
        Claims claims= Jwts.parserBuilder().setSigningKey(key)
                .build().parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
