package com.noob.coder.PasswordGenerator.entity;

public class HomeEntity {
	private long userId;
	private Boolean symbols;
	private Boolean uppercase;
	private Boolean ambiguousCharacters;
	private Boolean similarCharacters;
	private int length;
	private Boolean rememberPreferences;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Boolean getSymbols() {
		return symbols;
	}

	public void setSymbols(Boolean symbols) {
		this.symbols = symbols;
	}

	public Boolean getUppercase() {
		return uppercase;
	}

	public void setUppercase(Boolean uppercase) {
		this.uppercase = uppercase;
	}

	public Boolean getAmbiguousCharacters() {
		return ambiguousCharacters;
	}

	public void setAmbiguousCharacters(Boolean ambiguousCharacters) {
		this.ambiguousCharacters = ambiguousCharacters;
	}

	public Boolean getSimilarCharacters() {
		return similarCharacters;
	}

	public void setSimilarCharacters(Boolean similarCharacters) {
		this.similarCharacters = similarCharacters;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Boolean getRememberPreferences() {
		return rememberPreferences;
	}

	public void setRememberPreferences(Boolean rememberPreferences) {
		this.rememberPreferences = rememberPreferences;
	}
}
