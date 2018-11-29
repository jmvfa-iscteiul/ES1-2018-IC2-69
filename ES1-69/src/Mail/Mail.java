package Mail;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class Mail {
	
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

         BufferedReader reader = new BufferedReader(new InputStreamReader(
	      System.in));

         // retrieve the messages from the folder in an array and print it
         Message[] messages = emailFolder.getMessages();
         System.out.println("messages.length---" + messages.length);

         for (int i = 0; i < 100; i++) {
            Message message = messages[i];
            if(message.getContent().toString().contains(procura)) {
               	System.out.println("________________");
				System.out.println("Email nº" + (i+1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom());
				System.out.println("Text: " + message.getContent().toString());
            	
            	//String line = reader.readLine();
            	//if ("YES".equals(line)) {
            	//	message.writeTo(System.out);
            	//} else if ("QUIT".equals(line)) {
            	//	break;
            	//}
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
   public static void main(String[] args) {

      String host = "pop.outlook.com";// change accordingly
      String mailStoreType = "pop3";
      
      Scanner scanner = new Scanner(System.in);
		
      System.out.print("User: ");
      final String username = scanner.nextLine();
		
      System.out.print("Password");
      final String password = scanner.nextLine();

      System.out.print("O que procura? ");
		String procura = scanner.nextLine();
		
		scanner.close();

      //Call method fetch
      fetch(host, mailStoreType, username, password, procura);

   }


}