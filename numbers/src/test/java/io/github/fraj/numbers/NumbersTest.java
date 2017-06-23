package io.github.fraj.numbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.fraj.numbers.Numbers;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Unit tests for {@link Numbers}.
 */
@RunWith(JUnitParamsRunner.class)
public class NumbersTest {

	/**
	 * Tests {@link Numbers#gcd(int, int)}.
	 * 
	 * @param argLeft
	 *            the left number for GCD computation
	 * @param argRight
	 *            the right number for GCD computation
	 * @param argExpected
	 *            the expected result for GCD computation
	 * @throws Exception
	 *             only in case of test failure
	 */
	@Test
	@Parameters({ "117936, 15288, 2184", "15288, 117936, 2184", "-117936, 15288, 2184", "15288, -117936, 2184", "-117936, -15288, 2184", "-15288, -117936, 2184",
			"3, 17, 1", "17, 3, 1", "0, 25, 25", "25, 0, 25", "0, 0, 0" })
	public void testOf(int argLeft, int argRight, int argExpected) throws Exception {
		assertEquals("Wrong GCD value", argExpected, Numbers.gcd(argLeft, argRight));
	}

}
