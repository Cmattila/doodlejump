package tk.doodlejump;

import java.io.IOException;
import java.util.List;

import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;

public class Hello {
	public String hello(String name){  
        System.out.println("flex调用我了，真好~~~~");
        return "hello "+name;  
    }
	
	public String test(String name, String sjif){
		System.out.println("flex调用我了，真好~~~~");
		return "hello "+name;
	}
	
	public String test2(String sessionKey, String id) {
		XiaoneiRestClient client = new XiaoneiRestClient("95af0e363e71487e92802e6b55ab93bb", 
				"302992a72c8f42f68d6b6813457b48f3", sessionKey);
	    try {
			client.friends_getFriends();
		} catch (XiaoneiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "";
		
	    FriendsGetFriendsResponse resp = (FriendsGetFriendsResponse) client.getResponsePOJO();
	    List<Friend> friends = resp.getFriend();
	    for (Friend friend : friends) {
	    	result += "friends|getFriends|Id|"+friend.getId();
	    	result += "friends|getFriends|Id|"+friend.getId();
	    	result += "friends|getFriends|Name|"+friend.getName();
	    	result += "friends|getFriends|Headurl|"+friend.getHeadurl();
	    }
	    return result;
	}
}

