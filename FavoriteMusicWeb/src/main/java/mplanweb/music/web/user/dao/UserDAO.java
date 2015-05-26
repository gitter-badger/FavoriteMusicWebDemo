package mplanweb.music.web.user.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	public int duplicateUser(String userid);
	public ArrayList getUserInfo(String userid);
	public Object insertUser(HashMap map);
	public int deleteUser(String userid);

}
