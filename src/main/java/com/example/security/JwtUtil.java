package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.expiration}")
    private Long verificationExpiration;

    @Value("${jwt.reset-expiration}")
    private Long resetExpiration;



    // Generate token from email
    public String generateToken(String email, String role) {
            return Jwts.builder()
                    .setSubject(email)
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(getKey())
                    .compact();
    }

    // ── Private helpers ───────────────────────────────────────────

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }



    // ── Private helpers ───────────────────────────────────────────

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

// Extract email (subject) from token
    public String extractEmail(String token) {
        return  getClaims(token).getSubject();
    }

//Extract role claim from token
    public String extractRole(String token) {
        return  getClaims(token).get("role", String.class);
    }


//Validate token _ checks signature + expiry
    public boolean validate(String token) {
        try {
            getClaims(token);
            return true;
        }catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    // ── Password reset token (short-lived, single purpose) ─────────
    public String generateResetToken(String email) {
        return Jwts.builder()
                .subject(email)
                .claim("purpose", "PASSWORD_RESET")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + resetExpiration))
                .signWith(getKey())
                .compact();
    }

    // ── Email verification token (short-lived, single purpose) ────
    public String generateVerificationToken(String email) {
        return Jwts.builder()
                .subject(email)
                .claim("purpose", "EMAIL_VERIFICATION")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + verificationExpiration))
                .signWith(getKey())
                .compact();
    }





    // Validate token — checks signature + expiry
    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    public String extractPurpose(String token) {
        return (String) getClaims(token).get("purpose");
    }


    // Validates token AND checks it was issued for the expected purpose
    public boolean isValidForPurpose(String token, String expectedPurpose) {
        try {
            Claims claims = getClaims(token);
            return expectedPurpose.equals(claims.get("purpose"));
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractEmail(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }


//    private boolean isTokenExpired(String token) {
//        return getClaims(token).getExpiration().before(new Date());
//    }






}