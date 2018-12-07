/*
 * 
 */
package Twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class tudoTwitter  {
	
	private static ArrayList<String> search = new ArrayList<String>();
	private static ArrayList<String> searchTwitter = new ArrayList<String>();

	public static void searchT(String procura) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("xh014xFcmAVygWTV6naXgQlr4")
			.setOAuthConsumerSecret("7TrpBbzlT2uwSpHE5bkKuarzz2GI5ti26fFDnox7i9wrTKHQ3u")
			.setOAuthAccessToken("3217231319-qdBxneUT0I3T6O1xHHtlKgTzMoyLNqEN2hkfm9w")
			.setOAuthAccessTokenSecret("kqoxikvF25yCl29zdc8k5S2srjNQk2d1oAujN6oG6UTx6");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance(); 
			 List<Status> statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
            	String date;
				  if(status.getUser().getName() != null && status.getUser().getName().contains(procura)) {
					  date = status.getUser().getCreatedAt().toString();
					  
					  searchTwitter.add("Date: " + date + " User:  " + (status.getUser().getName()) + "  Mensage: " +status.getText().toString());
					  date = date.replace("WET ","");
					  date = date.replace("WEST ", "");
					  System.out.println(date);
					  searchTwitter.add("Date: " + date + " User:  " + (status.getUser().getName()) + "  Mensage: " +status.getText().toString());
					  //searchTwitter.sort(date);  //ordenar FREEDD!
					  System.out.println(searchTwitter);
				  }
			}
		} catch (Exception e) { 
			System.out.println(e.getMessage()); 
		}
	}
	public static void makeTweet(String menssagem) {
		try {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("xh014xFcmAVygWTV6naXgQlr4")
		.setOAuthConsumerSecret("7TrpBbzlT2uwSpHE5bkKuarzz2GI5ti26fFDnox7i9wrTKHQ3u")
		.setOAuthAccessToken("3217231319-qdBxneUT0I3T6O1xHHtlKgTzMoyLNqEN2hkfm9w")
		.setOAuthAccessTokenSecret("kqoxikvF25yCl29zdc8k5S2srjNQk2d1oAujN6oG6UTx6");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();   			
		
		//twitter.updateStatus(menssagem);
		twitter.updateStatus(menssagem);
		} catch (Exception e) { 
			System.out.println(e.getMessage()); 
		}
	}
	public static void reTweet(long ID) {
		
	}
	public static ArrayList<String> getListT() {
		return searchTwitter;
	}
	
	
}