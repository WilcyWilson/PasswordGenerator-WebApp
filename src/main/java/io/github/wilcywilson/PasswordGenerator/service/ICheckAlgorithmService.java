package io.github.wilcywilson.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;

import io.github.wilcywilson.PasswordGenerator.entity.HomeEntity;

public interface ICheckAlgorithmService {
	String checkAlgorithm(HomeEntity homeEntity) throws NoSuchAlgorithmException;
}
