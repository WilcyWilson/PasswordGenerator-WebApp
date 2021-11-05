package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {
	public String firstAlgorithm() throws NoSuchAlgorithmException {
		String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		int length = 10;
		Random random = SecureRandom.getInstanceStrong();   
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
		    int indexRandom = random.nextInt(symbols.length);
		    sb.append(symbols[indexRandom]);
		}
		String password = sb.toString();
		return password;
	}
}
