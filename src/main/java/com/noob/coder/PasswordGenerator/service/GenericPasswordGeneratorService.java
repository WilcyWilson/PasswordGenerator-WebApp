package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GenericPasswordGeneratorService implements IPasswordGeneratorService {
	@Override
	public String algorithm(List<String> symbols, int length) throws NoSuchAlgorithmException {
		Random random = SecureRandom.getInstanceStrong();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int indexRandom = random.nextInt(symbols.size());
			sb.append(symbols.get(indexRandom));
		}
		String password = sb.toString();
		return password;
	}
}
