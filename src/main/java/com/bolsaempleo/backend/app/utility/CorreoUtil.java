package com.bolsaempleo.backend.app.utility;

import java.util.List;
import java.util.Properties;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;


public class CorreoUtil {

    public static final void sendEmail(List<String> d, String asunto, String body, String filename) {
		
		Properties props = new Properties();
		
	    props.put("mail.smtp.host", ComunEnum.SERVER_SMTP.getDescripcion());
	    props.put("mail.smtp.socketFactory.port", ComunEnum.SERVER_PUERTO.getDescripcion());
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port",ComunEnum.SERVER_PUERTO.getDescripcion());

	    Session session = Session.getDefaultInstance(props,
	      new jakarta.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(ComunEnum.SERVER_USUARIO.getDescripcion(),ComunEnum.SERVER_CLAVE.getDescripcion());
	        }
	      });
	    
	    try {
	    	
	    	Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(ComunEnum.SERVER_USUARIO.getDescripcion()));
	        for (String  correo : d) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			}
	        message.setSubject(asunto);
	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String fileName = filename.substring(filename.lastIndexOf("\\") + 1);
	        messageBodyPart.setContent(body, "text/html; charset=utf-8");
	        messageBodyPart.setText(body, "text/html; charset=utf-8");
	        DataSource source = new FileDataSource(filename);
            DataHandler handler = new DataHandler(source);
	        //messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setDataHandler(handler);
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);
	        message.setContent(multipart);
	        Transport.send(message);
	      } catch (MessagingException e) {
	        throw new RuntimeException(e);
	      }
	}
	
	public static final void sendNotificacion(List<String> d, List<String> copia, String asunto, String body) {
		
		Properties props = new Properties();
		
	    props.put("mail.smtp.host", ComunEnum.SERVER_SMTP.getDescripcion());
		props.put("mail.smtp.ssl.trust", ComunEnum.SERVER_SMTP.getDescripcion());
		props.setProperty("mail.smtp.starttls.enable",ComunEnum.SERVER_starttls.getDescripcion());
		props.setProperty("mail.smtp.port",ComunEnum.SERVER_PUERTO.getDescripcion());
		props.setProperty("mail.smtp.user",ComunEnum.SERVER_USUARIO.getDescripcion());
		props.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
		props.setProperty("mail.smtp.auth",ComunEnum.SERVER_auth.getDescripcion());

	    Session session = Session.getInstance(props,
	      new jakarta.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(ComunEnum.SERVER_USUARIO.getDescripcion(),ComunEnum.SERVER_CLAVE.getDescripcion());
	        }
	      });
	    
	    try {
	    	
	    	Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(ComunEnum.SERVER_USUARIO.getDescripcion()));
	        for (String  correo : d) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			}
	        for (String  correo : copia) {
				message.addRecipient(Message.RecipientType.BCC, new InternetAddress(correo));
			}
	        message.setSubject(asunto);
	        message.setContent(body, "text/html; charset=utf-8");
	        Transport.send(message);
	      } catch (MessagingException e) {
	        throw new RuntimeException(e);
	      }
	}
}
