package com.noob.coder.PasswordGenerator.entity;

public class HomeEntity {
	private long userId;
	private Boolean symbols;
	private Boolean uppercase;
	private int Length;
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

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public Boolean getRememberPreferences() {
		return rememberPreferences;
	}

	public void setRememberPreferences(Boolean rememberPreferences) {
		this.rememberPreferences = rememberPreferences;
	}
}
