package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IPasswordGeneratorService {
	String algorithm(String characterPool, int length) throws NoSuchAlgorithmException;
}
