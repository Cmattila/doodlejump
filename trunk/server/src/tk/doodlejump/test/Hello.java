package tk.doodlejump.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;
import com.xiaonei.api.schema.Friend;
import com.xiaonei.api.schema.FriendsGetFriendsResponse;

import flex.messaging.io.amf.ASObject;

public class Hello {
	public String hello(String name){  
        System.out.println("flex调用我了，真好~~~~");
        return "hello "+name;  
    }
	
	public String test(String name, String sjif){
		System.out.println("flex调用我了，真好~~~~");
		return "hello "+name;
	}
	
	@SuppressWarnings("unchecked")
	public List<ASObject> test2(String sessionKey, String id) {
		List<ASObject> list = new LinkedList<ASObject>();
		
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
		
	    FriendsGetFriendsResponse resp = (FriendsGetFriendsResponse) client.getResponsePOJO();
	    List<Friend> friends = resp.getFriend();

	    for (Friend friend : friends) {

			ASObject as = new ASObject();

			as.put("id", friend.getId());

			as.put("name", friend.getName());
			
			as.put("headUrl", friend.getHeadurl());

			list.add(as);
	    }
	    return list;
	}
}