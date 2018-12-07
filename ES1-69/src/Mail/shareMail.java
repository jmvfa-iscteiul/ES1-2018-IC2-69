/*
 * 
 */
package Mail;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class shareMail{
	
	public static void sendMail(String user, String pass, String toWho, String subject, String messageText) {

			
			Properties proper = System.getProperties();
			
			proper.put("mail.smtp.starttls.enable", "true");
			proper.put("mail.smtp.host", "smtp.outlook.com");
			proper.put("mail.smtp.port", "587");
			proper.put("mail.smtp.auth", "true");
			proper.put("mail.smtp.starttls.required", "true");
			
			final String username = user;
			
			final String password = pass;
					
			Session session = Session.getDefaultInstance(proper, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
				});
			
			try {
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));//quem manda o mail
				message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(toWho));//para quem quer enviar
				message.setSubject(subject);//o assunto
				message.setText(messageText);// mensagem
				Transport.send(message);// enviar a mensagem craiada com os argumentos
				
				System.out.println("\n Your Message was delivered successfully");
			}catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}