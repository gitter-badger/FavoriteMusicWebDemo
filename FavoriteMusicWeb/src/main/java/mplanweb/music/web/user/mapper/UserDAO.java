package mplanweb.music.web.user.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import mplanweb.music.web.user.bean.UserBean;



public interface UserDAO {
	//3.1	
	public int duplicateUser(String userid);
	public ArrayList getUserInfo(String userid);
	public Object insertUser(HashMap map);
	public int deleteUser(String userid);
	//login
	public ArrayList login(String userid, String passwd);

	
	//3.2
	
}
