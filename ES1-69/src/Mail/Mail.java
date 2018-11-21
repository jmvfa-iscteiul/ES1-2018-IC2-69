package Mail;

import javax.mail.PasswordAuthentication;

import java.awt.EventQueue;
import java.util.*;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;


public class Mail{
	
	public static void procurar() throws NoSuchProviderException  {
		
		String host = "pop.outlook.com";
		Scanner s = new Scanner(System.in);
		System.out.print("User: ");
		final String username = s.nextLine();
		System.out.println("aqui4");
		System.out.print("Password");
		final String password = s.nextLine();

		System.out.print("O que procura? ");
		String procura = s.nextLine();
		System.out.println(username);
		
			System.out.println("aqui1");
			Properties prop = new Properties();
			
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.port", "993");
			prop.put("mail.pop3.starttls.enable", "true");
			
			//Session session = Session.getDefaultInstance(prop);
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
					
				}
			});
			Store store = session.getStore("pop3s");
			
			try {
			store.connect(host, username, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
			
			int n = messages.length;
			for(int i = 0; i < 100; i++) {
				Message message = messages[i];
				//boolean existeProcura = message.getContent().toString().contains(procura);
				if(message.getContent().toString().contains(procura)) {
					System.out.println("______");
					System.out.println("Email nº" + (i+1));
					System.out.println("Subject: " + message.getSubject());
					System.out.println("From: " + message.getFrom());
					System.out.println("Text: " + message.getContent().toString());
				}
			}
			
			emailFolder.close(false);
			store.close();
			
			
			}catch(MessagingException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			s.close();
	
	}
	
	public static void main(String args[])  {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
			procurar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		});	
	}
	
	
}
