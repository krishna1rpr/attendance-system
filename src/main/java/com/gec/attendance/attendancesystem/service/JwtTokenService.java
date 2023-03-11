package com.gec.attendance.attendancesystem.service;

//package com.in28minutes.rest.webservices.restfulwebservices.jwt;
// package com.in28minutes.rest.webservices.restfulwebservices.jwt;
//package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;



@Service
public class JwtTokenService {

    private final JwtEncoder jwtEncoder;

    public JwtTokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(Authentication authentication) {

        var scope = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(90, ChronoUnit.MINUTES))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        return this.jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
//                .setSigningKey(getSignKey())
                .setSigningKey(keyPair())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}


