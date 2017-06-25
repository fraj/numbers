package io.github.fraj.numbers.util;

/**
 * A utility class to compute the greatest common divisor of two numbers.
 */
public final class GCD {
	
	private GCD() {
		
	}

	/**
	 * Computes the (positive) greatest common divisor of two integers.
	 * 
	 * @param argLeft
	 *            the left side integer
	 * @param argRight
	 *            the right side integer
	 * @return the greatest common divisor
	 */
	public static int of(int argLeft, int argRight) {
		return ofPositive(Math.abs(argLeft), Math.abs(argRight));
	}

	private static int ofPositive(int argLeft, int argRight) {
		return argRight == 0 ? argLeft : ofPositive(argRight, argLeft % argRight);
	}

}
