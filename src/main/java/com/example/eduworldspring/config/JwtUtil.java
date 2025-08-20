package com.example.eduworldspring.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class JwtUtil {
    private final String jwtSecret = "mySuperSecretKeyForJwtAuthThatIsAtLeast64BytesLongAndSecure1234567890";
    private final long jwtExpirationMs = 86400000;

    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Date extractIssuedAt(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getIssuedAt(); // возвращает java.util.Date
    }

    public boolean validateToken(String token, UserDetails userDetails, Timestamp tokenExpiredAt) {
        final String username = extractUsername(token);
        Date issuedAt = extractIssuedAt(token);

        boolean notExpiredByJwt = !isTokenExpired(token);
        boolean issuedAfterLogout = tokenExpiredAt == null || issuedAt.getTime() >= tokenExpiredAt.getTime();

        return username.equals(userDetails.getUsername()) && notExpiredByJwt && issuedAfterLogout;
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}