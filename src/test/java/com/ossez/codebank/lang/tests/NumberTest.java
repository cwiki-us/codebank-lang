package com.ossez.codebank.lang.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
