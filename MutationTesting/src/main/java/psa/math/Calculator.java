package psa.math;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	int power(int base, int exponent) throws IllegalArgumentException {
		if (exponent < 0)
			throw new IllegalArgumentException("Negative exponent");
		if ((base == 0) && (exponent == 0))
			throw new IllegalArgumentException("Undefined");
		int result = 1;
		while (exponent > 0) {
			result = result * base;
			exponent = exponent - 1;
		}
		return result;
	}
}