package authorize.service;

import java.security.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.*;
import role.entity.Role;


public class UserAuthorizationService {
    private  KeyPair keyPair;

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public UserAuthorizationService(){
        keyPair = generateRSAKeyPair();
    }
    public KeyPair generateRSAKeyPair(){
        try {
            //creating instance of key pair generator using RSA algorithm
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            //setting key size
            keyPairGenerator.initialize(2048);

            //generating and returning key pair
           KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String subject, Role roles){
        Claims claims = Jwts.claims().setSubject(subject);
        try {
            String roleJson = new ObjectMapper().writeValueAsString(roles);
            claims.put("roles",roleJson );
            String token = Jwts.builder()
                    .setClaims(claims)
                    .signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256)
                    .compact();

            return token;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
    public Jws<Claims> getClaimsFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(keyPair.getPublic())
                .build()
                .parseClaimsJws(token);

        return claimsJws;
    }



}
