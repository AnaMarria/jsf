package mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSimpleMail {
	public static void main(String[] args) {
		
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      props.put("mail.debug", "true");
	      Session session = Session.getInstance(props,
	  		  new Authenticator() {
	  			protected PasswordAuthentication getPasswordAuthentication() {
	  				return new PasswordAuthentication("", "");
	  			}
	  		  });
	      try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(""));
	        msg.setRecipients(Message.RecipientType.TO, "");
	        msg.setSubject("Simple Test Mail");
	        msg.setSentDate(new Date());
	        msg.setText("Hello World!");
	        Transport.send(msg);
		System.out.println("---Done---");
	      } catch (MessagingException mex) {
	    	mex.printStackTrace();
	      }
	}
} 