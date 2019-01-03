package com.ossez.codebank.lang.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Email Process Utility
 * 
 * @author YuCheng Hu
 *
 */
public class EmailUtility {

	private static Logger logger = LoggerFactory.getLogger(EmailUtility.class);

	/**
	 * EmailUtility instance
	 */
	private static EmailUtility instance = new EmailUtility();

	public static EmailUtility getInstance() {
		return instance;
	}

	/**
	 * Send email to develop team member
	 * 
	 * @param emailSubject
	 * @param emailMessage
	 */
	public static void sendEmail(String emailSubject, String emailMessage) {



	}

	/**
	 * Send email to develop team member
	 * 
	 * @param emailSubject
	 * @param emailMessage
	 */
	public static void sendEmailToVeraniTeam(String msgSubject, String msgCtx, List<File> msgAttachments) {

		List<String> toAddressList = new ArrayList<String>();
		toAddressList.add("yucheng.hu@verani.com");
		toAddressList.add("steve.mcguire@verani.com");
		toAddressList.add("anna.mantica@verani.com");

		for (String toAddress : toAddressList) {
			//				msg.setFrom("dev@verani.com"); // FROM
//				msg.addTo(toAddress); // TO
//				msg.setSubject(msgSubject);// SUBJECT
//
//				// CTX
//				BodyPart messageBodyPart = new MimeBodyPart();
//
//				msgCtx = "<DIV STYLE=\"font-family: Verdana,Geneva,sans-serif; font-size: 14px; \">" + msgCtx + "</DIV>";
//				messageBodyPart.setContent(msgCtx, "text/html; charset=UTF-8");
//				msg.setBody(msgCtx);
//
//				msg.setAttachments(msgAttachments);// ATTACHMENT
//
//				msg.send();// SEND
			logger.debug("TO: [{}] - SUBJECT: [{}] > [SENT]", toAddress, msgSubject);

		}

	}

	/**
	 * Email message to user.
	 * 
	 * @param toEmailAddress
	 * @param emailSubject
	 * @param emailMessage
	 */
	public static void sendEmailToUser(String msgTo, String msgSubject, String msgCtx) {
		logger.debug("TO: [{}] - SUBJECT: [{}] > [SENT]", msgTo, msgSubject);

		msgCtx = "<DIV STYLE=\"font-family: Verdana,Geneva,sans-serif; font-size: 14px; \">" + msgCtx + "</DIV>";

////		MailMessage message = new MailMessage();
//		message.setFrom("websupport@verani.com");
//		message.setSubject(msgSubject);
//		message.addTo(msgTo);
//		message.setBody(msgCtx);
//		message.send();
	}
}
