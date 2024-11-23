package com.example.hmacsha;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hmacsha.utils.HmacSha256Generator;

@Component
public class SingatureValidatorClass implements SignatureValidator {

	@Autowired
	private HmacSha256Generator hmacSha256Generator;

	@Override
	public Boolean validateSign(String user, String signature) {
		String expectedSign;
		
		try {
			expectedSign = hmacSha256Generator.generateHmacSHA256(user);
			if (expectedSign.equals(signature))
			{
				return true;
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
