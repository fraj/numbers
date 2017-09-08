/*
 * Copyright (C) 2017 François Rajchenbach (f.rajchenbach@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.fraj.numbers.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.fraj.numbers.util.GCD;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Unit tests for {@link GCD}.
 */
@RunWith(JUnitParamsRunner.class)
public class GCDTest {

	/**
	 * Tests {@link GCD#of(int, int)}.
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
		assertEquals("Wrong GCD value", argExpected, GCD.of(argLeft, argRight));
	}

}
