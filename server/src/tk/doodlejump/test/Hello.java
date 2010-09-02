package tk.doodlejump.test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import tk.doodlejump.dao.CustomerDAO;
import tk.doodlejump.exception.RepositoryException;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.xiaonei.api.ProfileField;
import com.xiaonei.api.XiaoneiException;
import com.xiaonei.api.XiaoneiRestClient;

import com.xiaonei.api.schema.FriendsGetAppFriendsResponse;
import com.xiaonei.api.schema.User;
import com.xiaonei.api.schema.UsersGetInfoResponse;


import flex.messaging.io.amf.ASObject;

public class Hello {
	
	private CustomerDAO userDAO;
	
	
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
		
		tk.doodlejump.bean.Customer user = new tk.doodlejump.bean.Customer(Integer.parseInt(id), "dfj", "f");

		try {
			userDAO.save(user);
			userDAO.flushSession();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ASObject> list = new LinkedList<ASObject>();
		
		XiaoneiRestClient client = new XiaoneiRestClient("95af0e363e71487e92802e6b55ab93bb", 
				"302992a72c8f42f68d6b6813457b48f3", sessionKey);
	    try {
	    	client.friends_getAppFriends();
		} catch (XiaoneiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    FriendsGetAppFriendsResponse resp = (FriendsGetAppFriendsResponse) client.getResponsePOJO();
	    List<Integer> userIds = resp.getUid();
	    
	    
	    EnumSet<ProfileField> enumSet = EnumSet.of(ProfileField.NAME,   
                ProfileField.HOMETOWN_LOCATION,ProfileField.BIRTHDAY,   
                ProfileField.HEADURL,ProfileField.MAINURL,   
                ProfileField.SEX,ProfileField.STAR,ProfileField.TINYURL,   
                ProfileField.ZIDOU,ProfileField.UNIVERSITY_HISTORY,   
                ProfileField.WORK_HISTORY);
	    
	    try {
			client.users_getInfo(userIds, enumSet);
		} catch (XiaoneiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    UsersGetInfoResponse loggedUserGetInfoRes = (UsersGetInfoResponse) client.getResponsePOJO();//处理返回结果    
        List<User> lu = loggedUserGetInfoRes.getUser();
        
        for(User u:lu) {
        	ASObject as = new ASObject();
        	
			as.put("id", u.getUid());

			as.put("name", u.getName());
			
			as.put("headUrl", u.getTinyurl());

			list.add(as);
        } 
        
	    return list;
	}

	public void setUserDAO(CustomerDAO userDAO) {
		this.userDAO = userDAO;
	}

	public CustomerDAO getUserDAO() {
		return userDAO;
	}
}