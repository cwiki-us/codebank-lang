package com.ossez.codebank.lang.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberTest {
	private final static Logger logger = LoggerFactory.getLogger(NumberTest.class);

	List<String> stringList = new ArrayList<String>();

	@Before
	public void setUp() {
		stringList = Arrays.asList("a", "b", null, "c", "", "d", " ", "e", "f");
	}

	/**
	 * Random from JDK
	 */
	@Test
	public void testRandom() {
		logger.debug("{}", Math.random());
		logger.debug("{}", Math.random());
	}

	/**
	 * Random Interval from JDK
	 */
	@Test
	public void testRandomInterval() {
		logger.debug("0 <= R <= 10 - [{}]", (int) (Math.random() * 11));
		logger.debug("5 <= R <= 10 - [{}] ", 5 + (int) (Math.random() * 6));

		int min = 1;
		int max = 100;
		logger.debug("min <= R <= max - [{}] ", min + (int) (Math.random() * (max - min + 1)));
	}

	/**
	 * Random Interval from JDK
	 */
	@Test
	public void testRandomCommonsLang() {
		int startInclusive = 1;
		int endExclusive = 100;

		logger.debug("min <= R <= max - [{}] ", RandomUtils.nextInt(startInclusive, endExclusive));
		logger.debug("min <= R <= max - [{}] ", RandomUtils.nextFloat(startInclusive, endExclusive));
		logger.debug("min <= R <= max - [{}] ", RandomUtils.nextDouble(startInclusive, endExclusive));

		logger.debug("RandomStringUtils - [{}]", RandomStringUtils.randomAlphanumeric(10));

	}
}
