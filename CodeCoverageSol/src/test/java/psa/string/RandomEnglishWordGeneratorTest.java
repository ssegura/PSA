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

@DisplayName("Random word generation")
class RandomEnglishWordGeneratorTest {


	static RandomEnglishWordGenerator gen = new RandomEnglishWordGenerator();;
	
	@BeforeAll
	static void setUp() throws Exception {
		gen.setGenerateCompounds(true);
	}
	
	@DisplayName("1-3 words")
	@Tag("parameterized")
	@RepeatedTest(value=10, name="{displayName} {currentRepetition}/{totalRepetitions}")
	void testRandomOneToThreeWords(TestReporter reporter) {
		// Arrange
		int minWords = 1;
		int maxWords = 3;
		gen.setMinWords(minWords);
		gen.setMaxWords(maxWords);
		
		// Act
		String value = gen.nextValue();
		reporter.publishEntry("Word",value);		// OJO: No aparece en el report (no soportado por Gradle). Sí aparece stdout
		
		// Assert
		int nWords = numberOfWords(value);
		assertTrue(nWords>=minWords && nWords<=maxWords, "Incorrect number of words");
	}
	
	@DisplayName("Max words")
	@Tag("parameterized")
	@ParameterizedTest(name = "maxWords = {0}")
	@ValueSource(ints = {3,4,5})
	void testRandomMaxWords(int maxWords) {
		// Arrange
		gen.setMaxWords(maxWords);
		
		// Act
		String value = gen.nextValue();
		System.out.println("Generated words: " + value);
		
		// Assert
		int nWords = numberOfWords(value);
		assertTrue(nWords<=maxWords, "Too many words");
	}
	

	@DisplayName("Min-max words")
	@Tag("parameterized")
	@ParameterizedTest(name = "minWords = {0}, maxWords={1}")
	@CsvSource({ "1, 2", "2, 4", "1, 3" })
	void testRandomMinAndMaxWords(int minWords, int maxWords) {
		// Arrange
		gen.setMinWords(minWords);
		gen.setMaxWords(maxWords);
		
		// Act
		String value = gen.nextValue();
		System.out.println("Generated words: " + value);
		
		// Assert
		int nWords = numberOfWords(value);
		assertTrue(nWords<=maxWords, "Too many words");
	}
	
	@DisplayName("Min-max words (linking words on/off)")
	@Tag("parameterized")
	@ParameterizedTest(name = "minWords = {0}, maxWords={1}, linkingWords= {2}")
	@MethodSource("inputsProvider")
	void testRandomMinAndMaxWords(int minWords, int maxWords, boolean linkingWords) {
		// Arrange
		gen.setMinWords(minWords);
		gen.setMaxWords(maxWords);
		gen.setGenerateLinkindWords(linkingWords);
		
		// Act
		String value = gen.nextValue();
		System.out.println("Generated words: " + value);
		
		// Assert
		int nWords = numberOfWords(value);
		assertTrue(nWords<=maxWords, "Too many words");
	}
	
	private static Stream<Arguments> inputsProvider() {
        return Stream.of(
                Arguments.of(1, 3, true),
                Arguments.of(1, 5, true),
                Arguments.of(2, 4, false)
        );
    }
	
	@Test
	@DisplayName("1-3 words. Timeout 100ms")
	void testRandomOneToThreeWordsTimeout() {
		// Arrange
		// Arrange
		int minWords = 1;
		int maxWords = 3;
		gen.setMinWords(minWords);
		gen.setMaxWords(maxWords);
		
		// Act & Assert
		String value = assertTimeout(ofMillis(100), () -> { 
			return gen.nextValue();
		});
		
		System.out.println("Generated words: " + value);
		
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
