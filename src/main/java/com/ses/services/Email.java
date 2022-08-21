package com.ses.services;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

public class Email {
	public static void send() {
		
		String TO = "ofxijdcjmmcvmiffyp@kvhrs.com";
		String FROM = "ofxijdcjmmcvmiffyp@kvhrs.com";
		try {
		Regions region = Regions.AP_SOUTHEAST_2;
		AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard().withRegion(region).build();
		SendEmailRequest sendEmailRequest = new SendEmailRequest();
		sendEmailRequest.setSource(FROM);
		
		List<String> toAddresses = new ArrayList<String>();
		toAddresses.add(TO);
		Destination destination = new Destination(toAddresses);
		
		sendEmailRequest.setDestination(destination);
		Content subject = new Content("MSG FROM AWS SES 2");
		Content text = new Content("HI programmers 123");
		Body body = new Body(text);
		Message message = new Message(subject, body);
		sendEmailRequest.setMessage(message);
	
		SendEmailResult response = client.sendEmail(sendEmailRequest);
		if (response.getMessageId() != null) {
			System.out.println("Email SENT!");
		}else {
			System.out.println("Error");
		}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
;