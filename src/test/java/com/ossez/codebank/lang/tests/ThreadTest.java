package com.ossez.codebank.lang.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.lang.util.StreamUtility;

import junit.framework.TestCase;

/**
 * Thread Test
 * 
 * @author YuCheng Hu
 *
 */
public class ThreadTest {
	private final static Logger logger = LoggerFactory.getLogger(ThreadTest.class);

	static volatile int num = 0;
	static volatile boolean flag = false;

	@Before
	public void setUp() {

	}

	@Test
	public void testThreadSynchronization() {

		// Thread Odd
		Thread tOdd = new Thread(() -> {
			for (; 100 > num;) {
				if (!flag && (++num % 2 != 0)) {

					logger.debug("{} The number is {}", Thread.currentThread().getName(), num);
					flag = true;
				}
			}
		});

		// Thread Even
		Thread tEven = new Thread(() -> {
			for (; 100 > num;) {
				if (flag && (++num % 2 == 0)) {

					logger.debug("{} The number is {}", Thread.currentThread().getName(), num);
					flag = false;
				}
			}
		});

		// Set Name
		tOdd.setName("Thread 1: ");
		tEven.setName("Thread 2: ");

		// START Thread
		tEven.start();
		tOdd.start();

	}
}
