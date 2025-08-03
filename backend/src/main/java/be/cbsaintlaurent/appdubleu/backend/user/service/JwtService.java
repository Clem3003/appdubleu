package be.cbsaintlaurent.appdubleu.backend.user.service;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.SQLOutput;
import java.util.Date;

@Service
public class JwtService {

    private final Key key;

    public JwtService() {
        Dotenv dotenv = Dotenv.load();
        String secret = dotenv.get("JWT_SECRET");
        if (secret == null || secret.isEmpty()) {
            throw new IllegalStateException("JWT_SECRET is not set in .env");
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

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
