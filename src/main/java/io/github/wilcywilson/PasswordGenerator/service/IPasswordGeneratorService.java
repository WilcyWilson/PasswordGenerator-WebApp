package io.github.wilcywilson.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;

public interface IPasswordGeneratorService {
	String generatePassword(String characterPool, int length) throws NoSuchAlgorithmException;
}
