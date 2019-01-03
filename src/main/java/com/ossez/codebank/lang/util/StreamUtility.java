package com.ossez.codebank.lang.util;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

/**
 * Email Process Utility
 * 
 * @author YuCheng Hu
 *
 */
public class StreamUtility {

	private static Logger logger = LoggerFactory.getLogger(StreamUtility.class);

	/**
	 * EmailUtility instance
	 */
	private static StreamUtility instance = new StreamUtility();

	public static StreamUtility getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param stringList
	 */
	public static void getEmptyCount(List<String> stringList) {
		Long notEmptyCount = stringList.stream().filter(str -> StringUtils.isNotBlank(str)).count();
		Long emptyCount = stringList.stream().filter(str -> StringUtils.isBlank(str)).count();

		logger.debug("NOT EMPTY IN List [{}]", notEmptyCount);
		logger.debug("EMPTY IN List [{}]", emptyCount);

	}

}
