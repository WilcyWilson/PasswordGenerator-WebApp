package com.noob.coder.PasswordGenerator.entity;

import lombok.Data;

@Data
public class HomeEntity {
	private long userId;
	private Boolean symbols;
	private Boolean uppercase;
	private Boolean ambiguousCharacters;
	private Boolean similarCharacters;
	private int length;
	private Boolean rememberPreferences;
}
