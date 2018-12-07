package Facebook;

import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;
import com.restfb.types.FacebookType;
import com.restfb.Parameter;

public class searchFacebook {
	private static ArrayList<String> searchFacebook = new ArrayList<String>();

	public static void connect(String procura) {
		searchFacebook.clear();
		String accessToken2 = "EAAHU8ugpfnwBAEA3VJVRJnZCRJXmqmDgsDrYZApSaT6b1sJdDXA9ovT9Oic0aRPrLZCTpj95ckHSqjpRzaAeMMrD1e4PDjSgl8BjOwucl6GZBEi5JxVhWhq5Aj1NVx0fUZBZBEkmHiA8LjNNY2pAkxrPnix3AASzfobuSiJywfq4OYcPA0s0H4QbXctUfTIYD8CGm9J3T3qQZDZD";
		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2);
		User me2 = fbClient2.fetchObject("me", User.class);

		
		String accessToken4 = "EAAHU8ugpfnwBAEA3VJVRJnZCRJXmqmDgsDrYZApSaT6b1sJdDXA9ovT9Oic0aRPrLZCTpj95ckHSqjpRzaAeMMrD1e4PDjSgl8BjOwucl6GZBEi5JxVhWhq5Aj1NVx0fUZBZBEkmHiA8LjNNY2pAkxrPnix3AASzfobuSiJywfq4OYcPA0s0H4QbXctUfTIYD8CGm9J3T3qQZDZD";
		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		//AccessToken extendedAccessToken4 = fbClient4.obtainExtendedAccessToken("515614718918268","515614718918268|zqQ-SMNH1fWGGDCz_9mWmYNW9ao");		/* 
		// * Facebook API Tutorials in Java # 5 | Get User Timeline Posts
		// * https://www.youtube.com/watch?v=wiFif4gOdFE&index=6&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb
		//*/ 
		
		String accessToken5 ;//= "EAAGZBEccjciEBAJ37ZAIbHKiL1Mo1HHex2pQTcs41dq8azfBvFGgt4eGgKBq12kSssOof51FKO0niKu7AaVKs3dy8W1ilqp4xcjFD1F9mmjJpVyeDnZAffUXRfh7zXL06BuSwQtfHMJbmJ079qCnkT844brHx966cz73JZBZBFy2Bv1rWu7T1rQddZCVpxywZCO6lDxoWDk2gZDZD";
		accessToken5 = "EAAHU8ugpfnwBAEA3VJVRJnZCRJXmqmDgsDrYZApSaT6b1sJdDXA9ovT9Oic0aRPrLZCTpj95ckHSqjpRzaAeMMrD1e4PDjSgl8BjOwucl6GZBEi5JxVhWhq5Aj1NVx0fUZBZBEkmHiA8LjNNY2pAkxrPnix3AASzfobuSiJywfq4OYcPA0s0H4QbXctUfTIYD8CGm9J3T3qQZDZD";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);

		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		for (List<Post> page : result) {
			
			String date;
			
			for (Post aPost : page) {
				if (aPost.getMessage() != null && aPost.getMessage().contains(procura)) {					
					date = aPost.getCreatedTime().toString();
					date = date.replace("WET ","");
					date = date.replace("WEST ", "");
					
					searchFacebook.add("Date: " + date + "  Menssagem: " + aPost.getMessage().toString());
					//System.out.println(aPost.getCreatedTime());
				}
			}
		}		
	}
	public static ArrayList<String> getSearchFacebook() {
		return searchFacebook;
	}
}