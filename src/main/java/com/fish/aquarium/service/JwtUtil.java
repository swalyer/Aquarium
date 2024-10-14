package com.fish.aquarium.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "foools-for-shitti-lizards-or-very-fucking-wizards-my-mom-is-beautiful-wooman-are-you";
    

public String extractUsername(String token){
    return extractClaim(token, Claims::getSubject);
}
public <T> T extractClaim(String token, java.util.function<Claims,T>claimsResolver){
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);

}
private Claims extractAllClaims{
    Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());



    return Jwts.parserBuilder()
    .setSigningKey(key)
    .build()
    .parseClaimsJws(token)
    .getBody();
}

public Boolean validateToken(String token, UserDetails UserDetails){
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername() && !isTokenExpired(token)));
}

private String createToken(Map<String,Object> claims,String subject){
    Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());


return Jwts.builder()
    .setClaims(claims)
    .setSubject(subject)
    .setIssuedAt(new Date(System.currentTimeMillis()))
    .setExpiration(new Date(System.currentTimeMillis() + 60000 *600 ))
    .signWith(key, SignatureAlgorithm.HS256)
    .compact();
}

}