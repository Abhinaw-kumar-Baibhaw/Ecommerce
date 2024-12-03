package com.FullFledgedEcommerce.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class JwtService {

    public static final  long TOKEN_VALIDITY = 60 *60 * 1000;

    private static final byte[] secretKey =("qXbFtb5dN8HG9j6+PhD7LDBb02fW3sP6M5LkW8nA0K8j34fB/3g7Wx2site").getBytes();

    public String generateToken(String email, Collection<? extends GrantedAuthority> authorities) {

        List<String> roles = authorities.stream()
                .map(grantedAuthority -> "ROLE_" + grantedAuthority.getAuthority())
                .collect(Collectors.toList());

        return Jwts.builder()
                .subject(email)
                .claim("roles", roles)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(getSignKey())
                .compact();
    }

    public Set<String> extractRoles(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return new HashSet<>((List<String>) claims.get("roles"));
    }


    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secretKey);
    }

    public String extractUserName(String token) {
         Claims claims = getAllClaimsFromToken(token);
         return claims.getSubject();
     }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        Claims claimsDetails = getAllClaimsFromToken(token);
        String userName = claimsDetails.getSubject();
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        Claims claims=getAllClaimsFromToken(token);
        return claims.getExpiration();
    }
}
