package be.cbsaintlaurent.appdubleu.backend.user.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // En vrai, stocke-le en sécurité (env, vault...)

    public String generateToken(String subject, String name, boolean isAdmin) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 1000 * 60 * 60; // 1h
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(subject)
                .claim("name", name)
                .claim("admin", isAdmin)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }
}
