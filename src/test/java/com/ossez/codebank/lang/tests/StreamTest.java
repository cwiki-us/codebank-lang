package com.ossez.codebank.lang.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ossez.codebank.lang.util.StreamUtility;

import junit.framework.TestCase;

public class StreamTest {
	List<String> stringList = new ArrayList<String>();

	@Before
	public void setUp() {
		stringList = Arrays.asList("a", "b", null, "c", "", "d", " ", "e", "f");
	}

	@Test
	public void testCount() {

		StreamUtility.getEmptyCount(stringList);

	}
}
