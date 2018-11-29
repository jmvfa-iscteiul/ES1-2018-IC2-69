package Facebook;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public class searchFacebook {
	
private static ArrayList<String> searchFacebook = new ArrayList<String>();

	public static void main(String[] args) {
			
			String accessToken ;
			accessToken = "EAAHU8ugpfnwBANTBlZAiglCKrcbHtc8ZBhpuZBYZAkSUsmnOLrRhsyaV88vh3H4THBf8wFzk0aKakCEVvwHayBZAXQOH1ml94iRtHBS3xbFovZBSLh6Mml376MMF8EZAefwmBMFtwKLEIXcqvIAaZCNKGLHrf24DxCucpRbZC0pF7CFBSDrdObMdYvQ0nhM3jxeD1vbJYcGHntwZDZD";	
			FacebookClient fbClient = new DefaultFacebookClient(accessToken);
	
			Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
			System.out.println("\nPosts:");
			int counter = 0;
			int counterTotal = 0;
			for (List<Post> page : result) {
				for (Post aPost : page) {
					// Filters only posts that contain the word "Inform"
					if (aPost.getMessage() != null && aPost.getMessage().contains("Maria")) {
						System.out.println("---- Post "+ counter + " ----");
						System.out.println("Id: "+"fb.com/"+aPost.getId());
						System.out.println("Message: "+aPost.getMessage());
						System.out.println("Created: "+aPost.getCreatedTime());
						counter++;
					}
					counterTotal++;
				searchFacebook.add(aPost.getMessage());
				}
			}
			System.out.println("Number of Results: " + counter+"/"+counterTotal);	
	}
	
	public static ArrayList<String> getSearchFacebook() {
		return searchFacebook;
	}
}
