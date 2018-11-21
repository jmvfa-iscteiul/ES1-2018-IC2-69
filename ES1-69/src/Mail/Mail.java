package Mail;

import java.util.*;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class Mail{
	
	public static void procurar(String user, String password, String procura, String mailStoreType, String host) {
		
		try {
			
			Properties prop = new Properties();
			
			prop.put("mail.pop3.host", host);
			prop.put("mail.pop3.port", "993");
			prop.put("mail.pop3.starttls.enable", "true");
			
			Session session = Session.getDefaultInstance(prop);
			
			Store store = session.getStore("pop3s");
			store.connect(host, user, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
			
			int n = messages.length;
			for(int i = 0; i < 75; i++) {
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
			
			}catch(NoSuchProviderException e) {
				e.printStackTrace();
			}catch(MessagingException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
	
	}
	
	public static void main(String args[]) {
		
		String mailStoreType = "pop3";
		String host = "pop.outlook.com";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("User: ");
		final String username = scanner.nextLine();
		
		System.out.print("Password");
		final String password = scanner.nextLine();

		System.out.print("O que procura? ");
		String procura = scanner.nextLine();
		
		procurar(username, password, procura, mailStoreType, host);
		
	}
	
	
}
