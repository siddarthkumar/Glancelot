package com.glancelot.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glancelot.models.MeetingSchedular;
import com.glancelot.repositories.MeetingSchedulRepo;


@Service
public class MeetingSchedulService {
	
	@Autowired
	MeetingSchedulRepo meetingSchedulRepo;

	public void sendMails(String senderMailId, MeetingSchedular meetingSchedular) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		final String username = senderMailId;
		final String password = "HelloSuper@1998";//meetingSchedular.getMailPassword();

		try {
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderMailId));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(meetingSchedular.getAddMails(), false));
			msg.setSubject("Glancelot Meeting please use Meeting ID : "+meetingSchedular.getId());
			msg.setText("Regarding Meeting schedule");
			msg.setSentDate(new Date());
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
			messageBodyPart.setHeader("Content-ID", "calendar_message");
			try {
				messageBodyPart
						.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer(meetingSchedular).toString(), "text/calendar")));
			} catch (IOException e) {
				e.getStackTrace();
			}
			
			
			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);

			Transport.send(msg);
			System.out.println("Message sent.");
		} catch (MessagingException e) {
			System.out.println("Erreur d'envoi, cause: " + e);
		}
	}

	public String buffer(MeetingSchedular meetingSchedular) {
		String meetingLink = "http://localhost:8080/linkId?meetingId="+meetingSchedular.getId();
		String formattedDateTime = meetingSchedular.getSetDate().replace("-", "")+"T"+meetingSchedular.getSetTime().replace(":", "")+"00Z";
		StringBuffer sb = new StringBuffer();
		StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n"
				+ "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" + "VERSION:2.0\n" + "METHOD:REQUEST\n"
				+ "BEGIN:VEVENT\n" + "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:sangham@gmail.com\n"
				+ "ORGANIZER:MAILTO:sangham@gmail.com\n" + "DTSTART:"+formattedDateTime+"\n" + "DTEND:"+formattedDateTime+"\n"
				+ "LOCATION:Conference room\n" + "TRANSP:OPAQUE\n" + "SEQUENCE:0\n"
				+ "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n"
				+ " 000004377FE5C37984842BF9440448399EB02\n" + "DTSTAMP:20051206T120102Z\n" + "CATEGORIES:Meeting\n"
				+ "DESCRIPTION:"+ meetingLink + "\n"+"SUMMARY:Test meeting request\n"
				+ "PRIORITY:5\n" + "CLASS:PUBLIC\n" + "BEGIN:VALARM\n" + "TRIGGER:PT1440M\n" + "ACTION:DISPLAY\n"
				+ "DESCRIPTION:Reminder\n" + "END:VALARM\n" + "END:VEVENT\n" + "END:VCALENDAR");

		return buffer.toString();
	}
	
	public void save(MeetingSchedular meetingSchedular) {
		meetingSchedulRepo.save(meetingSchedular);
	}
	
	public boolean existsMeetingSchedularByMeetingSchedularemail(String meetingSchedularemail) {
		return meetingSchedulRepo.existsMeetingSchedularByMeetingSchedularemail(meetingSchedularemail);
	}
	
	public MeetingSchedular getMeetingSchedularByMeetingSchedularemail(String meetingSchedularemail) {
		return meetingSchedulRepo.getMeetingSchedularByMeetingSchedularemail(meetingSchedularemail);
	}
	
	public MeetingSchedular getMeetingSchedularByMeetingId(int meetingId) {
		return meetingSchedulRepo.findById(meetingId);
	}
}
