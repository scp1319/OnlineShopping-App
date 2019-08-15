package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage message;
	
	public void send() {
		message.setTo("bitadrumaitrabm@gmail.com"); //set a proper recipient of the mail
		message.setSubject("Test Mail");
		message.setText("Hi!");
		mailSender.send(message);
	//
	}
}
