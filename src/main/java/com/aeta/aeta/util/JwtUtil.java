package com.aeta.aeta.util;

import com.aeta.aeta.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.springframework.security.config.Elements.JWT;

@Component
    public class JwtUtil {

        private final String SECRET_KEY = "superSecretKey123";
        private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 saat

        public String generateToken(User user) {
            return JWT.create()
                    .withSubject(user.getUsername())
                    .withClaim("role", user.getRole())
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC256(SECRET_KEY));
        }

        public String extractUsername(String token) {
            return decodeToken(token).getSubject();
        }

        public boolean validateToken(String token, String username) {
            return username.equals(extractUsername(token)) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            return decodeToken(token).getExpiresAt().before(new Date());
        }

        private DecodedJWT decodeToken(String token) {
            return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
        }
    }
}
