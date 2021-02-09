package com.maksystem.Project.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService implements EmailSender{

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	@Override
	public void send(String to, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage mimeMessage =  mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
		try {
			helper.setText(text,true);
			helper.setTo(to);
			helper.setSubject("Mak System");
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mailSender.send(message);
	
	}
}
