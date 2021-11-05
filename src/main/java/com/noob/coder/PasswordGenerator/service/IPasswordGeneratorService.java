package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;

public interface IPasswordGeneratorService {
	String firstAlgorithm() throws NoSuchAlgorithmException;
}
