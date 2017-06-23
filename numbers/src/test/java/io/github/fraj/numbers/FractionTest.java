package io.github.fraj.numbers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.fraj.numbers.Fraction;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Unit tests for {@link Fraction}.
 */
@RunWith(JUnitParamsRunner.class)
public class FractionTest {

	private static final Fraction TEST_FRACTION_REDUCED = new Fraction(54, 7);
	private static final Fraction TEST_FRACTION = new Fraction(117936, 15288);

	/**
	 * Runs parameterized unit tests for {@link Fraction#Fraction(int, int)} in
	 * nominal case.
	 * 
	 * @param argNumerator
	 *            the fraction's numerator
	 * @param argDenominator
	 *            the fraction's denominator
	 * @param argExpectedNumerator
	 *            the expected reduced numerator of the constructed
	 *            {@link Fraction}
	 * @param argExpectedDenominator
	 *            the expected reduced denominator of the constructed
	 *            {@link Fraction}
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters({ "117936, 15288, 54, 7", "15288, 117936, 7, 54", "-117936, 15288, -54, 7", "15288, -117936, -7, 54",
			"-117936, -15288, 54, 7", "-15288, -117936, 7, 54", "3, 17, 3, 17", "17, 3, 17, 3", "0, 25, 0, 1",
			"125, 25, 5, 1" })
	public void testConstructor_Nominal(int argNumerator, int argDenominator, int argExpectedNumerator,
			int argExpectedDenominator) throws Exception {
		Fraction locFraction = new Fraction(argNumerator, argDenominator);
		assertEquals("Wrong numerator for reduced fraction", argExpectedNumerator, locFraction.getNumerator());
		assertEquals("Wrong denominator for reduced fraction", argExpectedDenominator, locFraction.getDenominator());
	}

	/**
	 * Runs parameterized unit tests for {@link Fraction#Fraction(int)} in
	 * nominal case.
	 * 
	 * @param argNumerator
	 *            the fraction's numerator
	 * @param argExpectedNumerator
	 *            the expected reduced numerator of the constructed
	 *            {@link Fraction}
	 * @param argExpectedDenominator
	 *            the expected reduced denominator of the constructed
	 *            {@link Fraction}
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters({ "117936, 117936, 1", "-117936, -117936, 1", "0, 0, 1" })
	public void testConstructor_NoDenominator(int argNumerator, int argExpectedNumerator, int argExpectedDenominator)
			throws Exception {
		Fraction locFraction = new Fraction(argNumerator);
		assertEquals("Wrong numerator for reduced fraction", argExpectedNumerator, locFraction.getNumerator());
		assertEquals("Wrong denominator for reduced fraction", argExpectedDenominator, locFraction.getDenominator());
	}

	/**
	 * Runs unit test for {@link Fraction#Fraction(int, int)} in case when
	 * denominator is 0.
	 * 
	 * @throws Exception
	 *             expecting {@link ArithmeticException}, otherwise test fails
	 */
	@Test(expected = ArithmeticException.class)
	public void testConstructor_ZeroAsDenominator() throws Exception {
		new Fraction(51, 0);
	}

	/**
	 * Runs parameterized unit tests for {@link Fraction#toString()} in nominal
	 * case.
	 * 
	 * @param argNumerator
	 *            the fraction's numerator
	 * @param argDenominator
	 *            the fraction's denominator
	 * @param argExpectedAsString
	 *            the expected string representation of the constructed
	 *            {@link Fraction}
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters({ "117936, 15288, 7.714285714285714", "15288, 117936, 0.12962962962962962",
			"-117936, 15288, -7.714285714285714", "15288, -117936, -0.12962962962962962",
			"-117936, -15288, 7.714285714285714", "-15288, -117936, 0.12962962962962962", "3, 17, 0.17647058823529413",
			"17, 3, 5.666666666666667", "0, 25, 0", "125, 25, 5" })
	public void testToString_Nominal(int argNumerator, int argDenominator, String argExpectedAsString)
			throws Exception {
		assertEquals("Wrong string for reduced fraction", argExpectedAsString,
				new Fraction(argNumerator, argDenominator).toString());
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#equals(Object)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} that tests equality
	 * @param argRight
	 *            the {@link Object} to test equality with
	 * @param argExpectedEquality
	 *            the expected result of the equality test
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testEquals(Fraction argLeft, Object argRight, boolean argExpectedEquality) throws Exception {
		assertEquals("Wrong result to equals", argExpectedEquality, argLeft.equals(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestEquals() {
		return new Object[][] { { TEST_FRACTION, TEST_FRACTION_REDUCED, true }, { TEST_FRACTION_REDUCED,
				new Fraction(TEST_FRACTION_REDUCED.getNumerator(), TEST_FRACTION_REDUCED.getDenominator()), true },
				{ TEST_FRACTION, TEST_FRACTION, true }, { TEST_FRACTION, null, false },
				{ TEST_FRACTION, new Object(), false },
				{ TEST_FRACTION_REDUCED,
						new Fraction(TEST_FRACTION_REDUCED.getNumerator() + 1, TEST_FRACTION_REDUCED.getDenominator()),
						false },
				{ TEST_FRACTION_REDUCED,
						new Fraction(TEST_FRACTION_REDUCED.getNumerator(), TEST_FRACTION_REDUCED.getDenominator() + 1),
						false } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#hashCode()} in nominal
	 * case.
	 * 
	 * @param argFraction
	 *            the {@link Fraction} to compute the hash of
	 * @param argExpectedHash
	 *            the expected hash value
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testHashCode(Fraction argFraction, long argExpectedHash) throws Exception {
		assertEquals("Wrong result to hashCode", argExpectedHash, argFraction.hashCode());
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestHashCode() {
		return new Object[][] { { TEST_FRACTION, 2642 }, { TEST_FRACTION_REDUCED, 2642 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#intValue()} in nominal
	 * case.
	 * 
	 * @param argFraction
	 *            the {@link Fraction} to get the int value of
	 * @param argExpectedValue
	 *            the expected int value
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testIntValue(Fraction argFraction, int argExpectedValue) throws Exception {
		assertEquals("Wrong result to intValue", argExpectedValue, argFraction.intValue());
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestIntValue() {
		return new Object[][] { { TEST_FRACTION, 7 }, { TEST_FRACTION_REDUCED, 7 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#intValue()} in nominal
	 * case.
	 * 
	 * @param argFraction
	 *            the {@link Fraction} to get the long value of
	 * @param argExpectedValue
	 *            the expected long value
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testLongValue(Fraction argFraction, long argExpectedValue) throws Exception {
		assertEquals("Wrong result to longValue", argExpectedValue, argFraction.longValue());
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestLongValue() {
		return new Object[][] { { TEST_FRACTION, 7 }, { TEST_FRACTION_REDUCED, 7 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#doubleValue()} in
	 * nominal case.
	 * 
	 * @param argFraction
	 *            the {@link Fraction} to get the double value of
	 * @param argExpectedValue
	 *            the expected double value
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testDoubleValue(Fraction argFraction, double argExpectedValue) throws Exception {
		assertEquals("Wrong result to doubleValue", argExpectedValue, argFraction.doubleValue(), 0.0);
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestDoubleValue() {
		return new Object[][] { { TEST_FRACTION, 7.714285714285714 }, { TEST_FRACTION_REDUCED, 7.714285714285714 },
				{ new Fraction(0, 31), 0 }, { new Fraction(31), 31 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#floatValue()} in nominal
	 * case.
	 * 
	 * @param argFraction
	 *            the {@link Fraction} to get the float value of
	 * @param argExpectedValue
	 *            the expected float value
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testFloatValue(Fraction argFraction, double argExpectedValue) throws Exception {
		assertEquals("Wrong result to floatValue", argExpectedValue, argFraction.floatValue(), 0.0);
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestFloatValue() {
		return new Object[][] { { TEST_FRACTION, 7.714285850524902 }, { TEST_FRACTION_REDUCED, 7.714285850524902 },
				{ new Fraction(0, 31), 0 }, { new Fraction(31), 31 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#compareTo(Fraction)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} that compares
	 * @param argRight
	 *            the {@link Fraction} to compare to
	 * @param argExpectedResult
	 *            the expected result of the comparison
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testCompareTo(Fraction argLeft, Fraction argRight, int argExpectedResult) throws Exception {
		assertEquals("Wrong result to compare", argExpectedResult, argLeft.compareTo(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestCompareTo() {
		return new Object[][] { { TEST_FRACTION, TEST_FRACTION_REDUCED, 0 }, { TEST_FRACTION, Fraction.ZERO, 1 },
				{ Fraction.ZERO, TEST_FRACTION, -1 },
				{ Fraction.ZERO,
						new Fraction(-TEST_FRACTION_REDUCED.getNumerator(), TEST_FRACTION_REDUCED.getDenominator()),
						1 },
				{ TEST_FRACTION_REDUCED,
						new Fraction(TEST_FRACTION_REDUCED.getNumerator() + 1, TEST_FRACTION_REDUCED.getDenominator()),
						-1 },
				{ TEST_FRACTION_REDUCED,
						new Fraction(TEST_FRACTION_REDUCED.getNumerator(), TEST_FRACTION_REDUCED.getDenominator() + 1),
						1 } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#negate()} in nominal
	 * case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to negate
	 * @param argExpectedResult
	 *            the expected result of the negation
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testNegate(Fraction argLeft, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to negate", argExpectedResult, argLeft.negate());
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestNegate() {
		return new Object[][] {
				{ TEST_FRACTION, new Fraction(-TEST_FRACTION.getNumerator(), TEST_FRACTION.getDenominator()) },
				{ Fraction.ZERO, Fraction.ZERO }, { TEST_FRACTION.negate(), TEST_FRACTION } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#add(Fraction)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to add to
	 * @param argRight
	 *            the {@link Fraction} to be added
	 * @param argExpectedResult
	 *            the expected result of the addition
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testAdd(Fraction argLeft, Fraction argRight, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to add", argExpectedResult, argLeft.add(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestAdd() {
		return new Object[][] {
				{ TEST_FRACTION, new Fraction(1, 1),
						new Fraction(TEST_FRACTION.getNumerator() + TEST_FRACTION.getDenominator(),
								TEST_FRACTION.getDenominator()) },
				{ TEST_FRACTION, Fraction.ZERO, TEST_FRACTION },
				{ TEST_FRACTION, TEST_FRACTION.negate(), Fraction.ZERO } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#substract(Fraction)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to substract from
	 * @param argRight
	 *            the {@link Fraction} to be substracted
	 * @param argExpectedResult
	 *            the expected result of the substraction
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testSubstract(Fraction argLeft, Fraction argRight, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to substract", argExpectedResult, argLeft.substract(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestSubstract() {
		return new Object[][] { { TEST_FRACTION, new Fraction(1, 1), new Fraction(
				TEST_FRACTION.getNumerator() - TEST_FRACTION.getDenominator(), TEST_FRACTION.getDenominator()) },
				{ TEST_FRACTION, TEST_FRACTION, Fraction.ZERO } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#invert()} in nominal
	 * case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to invert
	 * @param argExpectedResult
	 *            the expected result of the inversion
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testInvert(Fraction argLeft, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to invert", argExpectedResult, argLeft.invert());
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestInvert() {
		return new Object[][] {
				{ TEST_FRACTION, new Fraction(TEST_FRACTION.getDenominator(), TEST_FRACTION.getNumerator()) } };
	}

	/**
	 * Runs unit test for {@link Fraction#invert()} in case with zero.
	 * 
	 * @throws Exception
	 *             expecting {@link ArithmeticException}, otherwise test fails
	 */
	@Test(expected = ArithmeticException.class)
	public void testInvert_Zero() throws Exception {
		Fraction.ZERO.invert();
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#multiply(Fraction)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to be multiplied
	 * @param argRight
	 *            the {@link Fraction} to multiply by
	 * @param argExpectedResult
	 *            the expected result of the multiplication
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testMultiply(Fraction argLeft, Fraction argRight, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to multiply", argExpectedResult, argLeft.multiply(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestMultiply() {
		return new Object[][] {
				{ TEST_FRACTION, new Fraction(3, 2),
						new Fraction(TEST_FRACTION.getNumerator() * 3, TEST_FRACTION.getDenominator() * 2) },
				{ TEST_FRACTION, Fraction.ZERO, Fraction.ZERO }, { TEST_FRACTION, new Fraction(1), TEST_FRACTION },
				{ TEST_FRACTION, new Fraction(-1), TEST_FRACTION.negate() },
				{ TEST_FRACTION, TEST_FRACTION.invert(), new Fraction(1) } };
	}

	/**
	 * Runs parameterized unit test for {@link Fraction#divide(Fraction)} in
	 * nominal case.
	 * 
	 * @param argLeft
	 *            the {@link Fraction} to be divided
	 * @param argRight
	 *            the {@link Fraction} to divide by
	 * @param argExpectedResult
	 *            the expected result of the division
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters
	public void testDivide(Fraction argLeft, Fraction argRight, Fraction argExpectedResult) throws Exception {
		assertEquals("Wrong result to divide", argExpectedResult, argLeft.divide(argRight));
	}

	@SuppressWarnings("unused")
	private static Object[][] parametersForTestDivide() {
		return new Object[][] {
				{ TEST_FRACTION, new Fraction(3, 2),
						new Fraction(TEST_FRACTION.getNumerator() * 2, TEST_FRACTION.getDenominator() * 3) },
				{ TEST_FRACTION, new Fraction(1), TEST_FRACTION },
				{ TEST_FRACTION, new Fraction(-1), TEST_FRACTION.negate() },
				{ TEST_FRACTION, TEST_FRACTION, new Fraction(1) } };
	}

	/**
	 * Runs unit test for {@link Fraction#divide(Fraction)} in case with zero.
	 * 
	 * @throws Exception
	 *             expecting {@link ArithmeticException}, otherwise test fails
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivide_Zero() throws Exception {
		TEST_FRACTION.divide(Fraction.ZERO);
	}
}
