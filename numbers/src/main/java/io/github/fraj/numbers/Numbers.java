package io.github.fraj.numbers;

/**
 * A utility class to compute greatest common divisor of 2 numbers.
 */
public final class Numbers {
	
	private Numbers() {
		
	}

	/**
	 * Computes the (positive) greatest common divisor of 2 numbers.
	 * 
	 * @param argLeft
	 *            the left side number
	 * @param argRight
	 *            the right side number
	 * @return the greatest common divisor
	 */
	public static int gcd(int argLeft, int argRight) {
		return gcdPositive(Math.abs(argLeft), Math.abs(argRight));
	}

	private static int gcdPositive(int argLeft, int argRight) {
		return argRight == 0 ? argLeft : gcdPositive(argRight, argLeft % argRight);
	}

}
