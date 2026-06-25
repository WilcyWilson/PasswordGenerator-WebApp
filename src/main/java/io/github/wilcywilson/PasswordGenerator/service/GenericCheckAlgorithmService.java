package io.github.wilcywilson.PasswordGenerator.service;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.github.wilcywilson.PasswordGenerator.entity.HomeEntity;

@Service
public class GenericCheckAlgorithmService implements ICheckAlgorithmService {
	private final IPasswordGeneratorService passwordService;

	// constants
	private static final int MAX_PASSWORD_LENGTH = 32;
	private static final int MIN_PASSWORD_LENGTH = 6;

	// Using String constants is more memory-efficient than List<String> for single characters
	private static final String DIGITS = "0123456789";
	private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String SYMBOLS = "@#$%";
	private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String AMBIGUOUS_CHARACTERS = "{}[]/\\'\"~,;:.<>";

	// Set for O(1) lookup performance during filtering
	private static final Set<Character> SIMILAR_CHARACTERS = Set.of('i', 'l', '1', 'L', 'o', '0', 'O');

	public GenericCheckAlgorithmService(@Qualifier("genericPasswordGeneratorService") IPasswordGeneratorService passwordService) {
		this.passwordService = passwordService;
	}

	@Override
	public String checkAlgorithm(HomeEntity homeEntity) throws NoSuchAlgorithmException {

		// Clamp length to a safe range. Minimum length validation should ideally be enforced at the controller/entity layer.
		int targetLength = Math.max(MIN_PASSWORD_LENGTH, Math.min(homeEntity.getLength(), MAX_PASSWORD_LENGTH));

		int maxCapacity = DIGITS.length() + LOWERCASE_LETTERS.length()
				+ SYMBOLS.length() + UPPERCASE_LETTERS.length()
				+ AMBIGUOUS_CHARACTERS.length();

		// Clarified intent: true means similar characters should be EXCLUDED from the pool
		boolean excludeSimilarChars = Boolean.TRUE.equals(homeEntity.getSimilarCharacters());

		// Use StringBuilder to construct the character pool efficiently
		StringBuilder characterPool = new StringBuilder(maxCapacity);

		// Always include digits and lowercase
		appendToPool(characterPool, DIGITS, excludeSimilarChars);
		appendToPool(characterPool, LOWERCASE_LETTERS, excludeSimilarChars);

		if (Boolean.TRUE.equals(homeEntity.getSymbols())) {
			appendToPool(characterPool, SYMBOLS, excludeSimilarChars);
		}
		if (Boolean.TRUE.equals(homeEntity.getUppercase())) {
			appendToPool(characterPool, UPPERCASE_LETTERS, excludeSimilarChars);
		}
		if (Boolean.TRUE.equals(homeEntity.getAmbiguousCharacters())) {
			appendToPool(characterPool, AMBIGUOUS_CHARACTERS, excludeSimilarChars);
		}

		return passwordService.generatePassword(characterPool.toString(), targetLength);
	}

	private void appendToPool(StringBuilder pool, String chars, boolean excludeSimilar) {
		if (!excludeSimilar) {
			pool.append(chars);
			return;
		}

		for (int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
			if (!SIMILAR_CHARACTERS.contains(c)) {
				pool.append(c);
			}
		}
	}
}
