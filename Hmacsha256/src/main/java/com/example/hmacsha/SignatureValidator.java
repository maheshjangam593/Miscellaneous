package com.example.hmacsha;

import org.springframework.stereotype.Service;

@Service
public interface SignatureValidator {

	Boolean validateSign(String user, String signature);

}
