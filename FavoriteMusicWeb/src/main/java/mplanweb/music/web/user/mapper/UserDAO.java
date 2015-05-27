package mplanweb.music.web.user.mapper;

import java.util.ArrayList;
import java.util.HashMap;



public interface UserDAO {
	//3.1	
	public int duplicateUser(String userid);
	public ArrayList getUserInfo(String userid);
	public Object insertUser(HashMap map);
	public int deleteUser(String userid);

	
	//3.2
	
}
