package psa.string;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static java.time.Duration.ofMillis;

class RandomEnglishWordGeneratorTest {
	
	@Test
	void testRandomOneToThreeWords() {
		// Arrange
		RandomEnglishWordGenerator gen = new RandomEnglishWordGenerator();
		gen.setGenerateCompounds(true);
		int minWords = 1;
		int maxWords = 3;
		gen.setMinWords(minWords);
		gen.setMaxWords(maxWords);
		
		// Act
		String value = gen.nextValue();
		
		// Assert
		int nWords = numberOfWords(value);
		assertTrue(nWords>=minWords && nWords<=maxWords, "Incorrect number of words");
	}
	
	private int numberOfWords(String sentence) {
		String trimmed = sentence.trim();
		int words = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		return words;
	}
	
}
