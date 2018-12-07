/*
 * 
 */
package Facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import com.restfb.BinaryAttachment;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.GraphResponse;
import com.restfb.types.Link;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class shareFacebook{
	
	String accessToken = "EAAHU8ugpfnwBAJ574o1LTw3t05c1RmtmVXlVIKXjfopZA0IwqbZCsmdZBK1MNSRdItni1ZCjYZBQkq4PpmQs3kfvDYEufjaYhRboGJ5Cyw6sgmWGzwdNNZBq3gnzMHQO2aPLsNGNkdhyJQC1fyt9It2hnqrgWJZBPFtC9gHM0LWLp6VEP7oUOOmBxCZARBygc1cZD";
	FacebookClient fbCliente;
	
	public void post(String menssagem) {
		
		
		fbCliente = new DefaultFacebookClient(accessToken);
		Connection<Post> result = fbCliente.fetchConnection("me/feed", Post.class);
		
		GraphResponse publishMessageResponse = fbCliente.publish("me/feed", GraphResponse.class, Parameter.with("message", menssagem));
		
	}
	
	
}
