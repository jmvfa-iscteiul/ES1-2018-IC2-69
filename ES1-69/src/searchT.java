import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class searchT{
	
	
	private static List<Status> statuses;
	private static ArrayList<String> searchTwitter = new ArrayList<String>();
	
	
	public static void connectT(String s) {
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
        	  .setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
        	  .setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
        	  .setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();        		
            statuses = twitter.getHomeTimeline();
           
    		
            for (Status status : statuses) {
            	String date;
				if (status.getUser().getName() != null && status.getUser().getName().contains(s)){
					date = status.getUser().getTimeZone();
					System.out.println(status.getUser().getTimeZone());
					searchTwitter.add("User:  " + (status.getUser().getName()) + "  Mensage: " +status.getText().toString());
				}
            }
    		
    		
        } catch (Exception e) { System.out.println(e.getMessage()); }
        
        
     }
	
	public static List<String> getSearchTwitter() {
		
		return searchTwitter;
	}
	

}
