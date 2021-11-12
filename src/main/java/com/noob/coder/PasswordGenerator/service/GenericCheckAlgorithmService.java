package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noob.coder.PasswordGenerator.entity.HomeEntity;

@Service
public class GenericCheckAlgorithmService implements ICheckAlgorithmService {
	private IPasswordGeneratorService passwordService;

	@Autowired
	public GenericCheckAlgorithmService(IPasswordGeneratorService passwordService) {
		this.passwordService = passwordService;
	}

	@Override
	public String checkAlgorithm(HomeEntity homeEntity) throws NoSuchAlgorithmException {
		int length = homeEntity.getLength();
		List<String> symbols = new ArrayList<String>(
				Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
						"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

		if (Boolean.TRUE.equals(homeEntity.getSymbols())) {
			List<String> newSymbols = new ArrayList<String>(Arrays.asList("@", "#", "$", "%"));
			symbols.addAll(newSymbols);
		}
		if (Boolean.TRUE.equals(homeEntity.getUppercase())) {
			List<String> newSymbols = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I",
					"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
			symbols.addAll(newSymbols);
		}
		if (Boolean.TRUE.equals(homeEntity.getAmbiguousCharacters())) {
			List<String> newSymbols = new ArrayList<String>(Arrays.asList("{", "}", "[", "]", "(", ")", "/", "\\", "\'",
					"\"", "'", "~", ",", ";", ":", ".", "<", ">"));
			symbols.addAll(newSymbols);
		}
		if (Boolean.TRUE.equals(homeEntity.getSimilarCharacters())) {
			List<String> newSymbols = new ArrayList<String>(Arrays.asList("i", "l", "1", "L", "o", "0", "O"));
			symbols.removeAll(newSymbols);
		}
		return passwordService.algorithm(symbols, length);
	}
}
