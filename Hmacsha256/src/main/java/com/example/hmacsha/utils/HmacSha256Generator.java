package com.example.hmacsha.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.example.hmacsha.User;
import com.google.gson.Gson;

@Component
public class HmacSha256Generator {

    public static String generateHmacSHA256(String data) throws NoSuchAlgorithmException, InvalidKeyException {
    	 String secret = "My_Secrete";
    	Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256Hmac.init(secretKey);
        byte[] hashBytes = sha256Hmac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
    	
    	User user=new User();
    	
    	user.setUsername("mahi");
    	user.setPassword("password");
    	Gson gson=new Gson();
        String data = gson.toJson(user);
       
        String hmacSha256 = generateHmacSHA256(data);
        System.out.println("HMAC-SHA256: " + hmacSha256);
    }
}
