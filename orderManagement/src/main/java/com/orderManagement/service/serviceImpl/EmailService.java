package com.orderManagement.service.serviceImpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author M1055705
 *
 */
@Service
public class EmailService {

	@KafkaListener(topics = "email", groupId = "group-id")
	public void listen(String message) {
		System.out.println("Received Messasge in group - group-id: " + message);

		sendMail(message);
	}

	private void sendMail(String kafkaMessage) {
		try {
		if(kafkaMessage != null) {
		String[] spliteData = kafkaMessage.split("/");
		String name = spliteData[0];
		String to = spliteData[2];
		String from = "ordermyfood@gmail.com";

		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Order My Food");
			message.setText("Dear "+name+" Your order confirmed");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} else {
			System.out.println(" message unsuccessfull....");
		}
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
