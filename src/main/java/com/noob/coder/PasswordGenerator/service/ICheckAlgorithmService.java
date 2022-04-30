package com.noob.coder.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;

import com.noob.coder.PasswordGenerator.entity.HomeEntity;

public interface ICheckAlgorithmService {
	String checkAlgorithm(HomeEntity homeEntity) throws NoSuchAlgorithmException;
}
