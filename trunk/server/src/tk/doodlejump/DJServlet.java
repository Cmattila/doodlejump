package tk.doodlejump;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;

@SuppressWarnings("serial")
public class DJServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		XiaoneiRestClient client = new XiaoneiRestClient("apiKey", "secret", "sessionKey"); 
	    try {
			client.friends_getFriends();
		} catch (XiaoneiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    FriendsGetFriendsResponse respa = (FriendsGetFriendsResponse) client.getResponsePOJO(); 
	    List<Friend> friends = respa.getFriend(); 
	    for (Friend friend : friends) { 
	    	resp.getWriter().println("friends|getFriends|Id|"+friend.getId()); 
	    	resp.getWriter().println("friends|getFriends|Name|"+friend.getName()); 
	    	resp.getWriter().println("friends|getFriends|Headurl|"+friend.getHeadurl()); 
	    } 
		resp.getWriter().println();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		XiaoneiRestClient client = new XiaoneiRestClient("apiKey", "secret", "sessionKey"); 
	    try {
			client.friends_getFriends();
		} catch (XiaoneiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    FriendsGetFriendsResponse respa = (FriendsGetFriendsResponse) client.getResponsePOJO(); 
	    List<Friend> friends = respa.getFriend(); 
	    for (Friend friend : friends) { 
	    	resp.getWriter().println("friends|getFriends|Id|"+friend.getId()); 
	    	resp.getWriter().println("friends|getFriends|Name|"+friend.getName()); 
	    	resp.getWriter().println("friends|getFriends|Headurl|"+friend.getHeadurl()); 
	    }  
		resp.getWriter().println();
	}
}
