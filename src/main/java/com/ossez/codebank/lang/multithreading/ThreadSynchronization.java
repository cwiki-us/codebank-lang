package com.ossez.codebank.lang.multithreading;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause.Occur;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.search.engine.DocumentBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSynchronization {
	private static Logger logger = LoggerFactory.getLogger(ThreadSynchronization.class);

	static volatile int num = 0;
	static volatile boolean flag = false;

	public static void main(String[] args) {

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
