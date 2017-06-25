package io.github.fraj.numbers.fractions;

import io.github.fraj.numbers.util.GCD;

/**
 * An immutable number defined as the fraction of 2 integers.
 */
public class Fraction extends Number implements Comparable<Fraction> {

	/**
	 * A {@link Fraction} instance for zero
	 */
	public static final Fraction ZERO = new Fraction(0);

	private static final long serialVersionUID = 1L;

	private final int numerator;
	private final int denominator;

	/**
	 * Constructs a fraction from the two provided integers as its numerator and
	 * denominator.
	 * 
	 * @param argNumerator
	 *            the fraction's numerator
	 * @param argDenominator
	 *            the fraction's denominator
	 * @throws ArithmeticException
	 *             if denominator is zero
	 */
	public Fraction(int argNumerator, int argDenominator) {
		if (argDenominator == 0) {
			throw new ArithmeticException();
		}
		int locGcd = GCD.of(argNumerator, argDenominator);
		int locSignum = Integer.signum(argDenominator);
		numerator = locSignum * argNumerator / locGcd;
		denominator = locSignum * argDenominator / locGcd;
	}

	/**
	 * Constructs a fraction from the single provided integer as its numerator
	 * (denominator is 1).
	 * 
	 * @param argNumerator
	 *            the fraction's numerator
	 * @throws ArithmeticException
	 *             if denominator is zero
	 */
	public Fraction(int argNumerator) {
		this(argNumerator, 1);
	}

	/**
	 * Gets the fraction's (reduced) numerator.
	 * 
	 * @return the fraction's (reduced) numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Gets the fraction's (reduced) denominator.
	 * 
	 * @return the fraction's (reduced) denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	@Override
	public int intValue() {
		return numerator / denominator;
	}

	@Override
	public long longValue() {
		return intValue();
	}

	@Override
	public float floatValue() {
		return (float) doubleValue();
	}

	@Override
	public double doubleValue() {
		return (double) numerator / denominator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numerator;
		result = prime * result + denominator;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		return (numerator == other.numerator) && (denominator == other.denominator);
	}

	@Override
	public String toString() {
		return (denominator == 1) ? (Integer.toString(numerator)) : (Double.toString(doubleValue()));
	}

	@Override
	public int compareTo(Fraction argOther) {
		return Long.signum(
				(long) numerator * (long) argOther.denominator - (long) argOther.numerator * (long) denominator);
	}

	/**
	 * Returns a {@link Fraction} resulting from adding the specified
	 * {@link Fraction} to this.
	 * 
	 * @param argOther
	 *            the {@link Fraction} to be added
	 * @return this + argOther
	 */
	public Fraction add(Fraction argOther) {
		int locNewNumerator = (int) ((long) numerator * (long) argOther.denominator
				+ (long) argOther.numerator * (long) denominator);
		int locNewDenominator = (int) ((long) denominator * (long) argOther.denominator);
		return new Fraction(locNewNumerator, locNewDenominator);
	}

	/**
	 * Returns a {@link Fraction} resulting from substracting the specified
	 * {@link Fraction} from this.
	 * 
	 * @param argOther
	 *            the {@link Fraction} to be substracted
	 * @return this - argOther
	 */
	public Fraction substract(Fraction argOther) {
		return add(argOther.negate());
	}

	/**
	 * Returns a {@link Fraction} resulting from negating this.
	 * 
	 * @return -this
	 */
	public Fraction negate() {
		return new Fraction(-numerator, denominator);
	}

	/**
	 * Returns a {@link Fraction} resulting from multiplying this by the
	 * specified {@link Fraction}.
	 * 
	 * @param argOther
	 *            the {@link Fraction} to be multiplied by
	 * @return this * argOther
	 */
	public Fraction multiply(Fraction argOther) {
		int locNewNumerator = (int) ((long) numerator * (long) argOther.numerator);
		int locNewDenominator = (int) ((long) denominator * (long) argOther.denominator);
		return new Fraction(locNewNumerator, locNewDenominator);
	}

	/**
	 * Returns a {@link Fraction} resulting from inverting this.
	 * 
	 * @return this^-1
	 * @throws ArithmeticException
	 *             if this is zero
	 */
	public Fraction invert() {
		if (numerator == 0) {
			throw new ArithmeticException();
		}
		return new Fraction(denominator, numerator);
	}

	/**
	 * Returns a {@link Fraction} resulting from dividing this by the specified
	 * {@link Fraction}.
	 * 
	 * @param argOther
	 *            the {@link Fraction} to be divided by
	 * @return this / argOther
	 * @throws ArithmeticException
	 *             if argOther is zero
	 */
	public Fraction divide(Fraction argOther) {
		return multiply(argOther.invert());
	}

	/**
	 * Tells whether this {@link Fraction} holds an integer value.
	 * 
	 * @return <code>true</code> if this holds an integer value, otherwise false
	 */
	public boolean isInteger() {
		return denominator == 1;
	}

}
