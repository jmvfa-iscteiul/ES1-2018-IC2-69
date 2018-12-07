/*
 * 
 */
package Mail;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class searchMail {

	private static ArrayList<String> mails = new ArrayList<String>();

	//esta funcao vai recebe 3 argumentos importantes e 2 de protocolo (pop3Host e storeType) e de 
	public static void fetch(String pop3Host, String storeType, String user,String password, String procura) {
		try {
			// create properties field
			Properties properties = new Properties();
			properties.put("mail.store.protocol", "pop3");
			properties.put("mail.pop3.host", pop3Host);
			properties.put("mail.pop3.port", "993");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(pop3Host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			String date = new String();

			for (int i = 0; i < 100; i++) {
				Message message = messages[i];
				if(message.getContent().toString().contains(procura)) {
					date = message.getSentDate().toString();
					date = date.replace("WET ","");
					date = date.replace("WEST ", "");
					//System.out.println("Date: " + date + " From:  "+message.getFrom() + " Mensage:  "+message.getContent().toString());
					mails.add("Date: " + date + " From:  "+message.getFrom() + " Mensage:  "+message.getContent().toString());
				}
			}

			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void connectMail(String user, String password, String procura) {
		String host = "pop.outlook.com";
		String mailStoreType = "pop3";

		fetch(host, mailStoreType, user, password, procura);
	}
	
	public static ArrayList<String> getMailList() {
		return mails;
	}
}