package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IPasswordGeneratorService {
	public String algorithm(List<String> symbols, int length) throws NoSuchAlgorithmException;
}
