package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.noob.coder.PasswordGenerator.entity.HomeEntity;

@Service
public class PasswordGeneratorService {
	public String firstAlgorithm(List<String> symbols) throws NoSuchAlgorithmException {
		int length = 10;
		Random random = SecureRandom.getInstanceStrong();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int indexRandom = random.nextInt(symbols.size());
			sb.append(symbols.get(indexRandom));
		}
		String password = sb.toString();
		return password;
	}

	public String checkAlgorithm(HomeEntity homeEntity) throws NoSuchAlgorithmException {
		List<String> symbols = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
				"f"));
		if (Boolean.TRUE.equals(homeEntity.getSymbols())) {
			List<String> newSymbols = new ArrayList<String>(Arrays.asList("@", "#", "$", "%"));
			symbols.addAll(newSymbols);
		}
		return this.firstAlgorithm(symbols);
	}
}
