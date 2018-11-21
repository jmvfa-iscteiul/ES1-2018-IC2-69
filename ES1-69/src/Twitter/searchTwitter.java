package Twitter;

import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class searchTwitter  {
	public static void main(String[] args) {
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
        	  .setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
        	  .setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
        	  .setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();        		
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("------------------------\n Showing Timeline \n------------------------");
    		int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
				//if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE")) {
            		System.out.println("----------------");
            		System.out.println("nº" + (counterTotal+1));
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
			//						
					counterTotal++;
            }
    		System.out.println("Number of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
     }
	
	
}