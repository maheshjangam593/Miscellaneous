package com.example.hmacsha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class HmacController {

	@Autowired
	private SignatureValidator signatureValidator;

	@PostMapping("/validateHmac")
	public ResponseEntity<String> addUser(@RequestBody User user, @RequestHeader("signature") String signature) {

		Gson gson = new Gson();
		String jsonInput = gson.toJson(user);

		Boolean isValidSign = signatureValidator.validateSign(jsonInput, signature);

		if (isValidSign) {
			return new ResponseEntity<String>("logged in succefully", HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<String>("not authenticated", HttpStatus.UNAUTHORIZED);
	}
}
