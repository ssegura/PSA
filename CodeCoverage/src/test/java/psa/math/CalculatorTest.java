package psa.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;


import psa.math.Calculator;

@DisplayName("Calculator test cases")
class CalculatorTest {

	Calculator calc = new Calculator();

	@Test
	@DisplayName("a + b")
	void testAdd() {
		assertEquals(calc.add(2, 2), 4, "Wrong addition");
	}

	@Test
	@DisplayName("a - b")
	void testSubtract() {
		assertEquals(calc.subtract(5, 2), 3, "Wrong subtraction");
	}

	@Test
	@DisplayName("a x b")
	void testMultiply() {
		assertEquals(calc.multiply(2, 3), 6, "Wrong multiplication");
	}

	@Test
	@DisplayName("a / b (no reminder)")
	//@DisabledOnOs(OS.WINDOWS)
	void testDivide() {
		assertEquals(calc.divide(10, 2), 5, "Wrong division");
	}

	@Test
	@DisplayName("b^e")
	void testPower() {
		try {
			assertEquals(calc.power(2, 3), 8, "Wrong power operation");
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}
	
	@Test
	@DisplayName("b^0 (expected exception)")
	void testPowerNegativeExponent() {
		assertThrows(IllegalArgumentException.class, () -> {
			calc.power(3, -2);
		});
	}
	
	@Test
	@DisplayName("0^0 (expected exception)")
	void testPowerBaseAndExponentAreZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			calc.power(0, 0);
		});
	}
}
