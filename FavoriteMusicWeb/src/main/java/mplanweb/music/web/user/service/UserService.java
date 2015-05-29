package mplanweb.music.web.user.service;

import mplanweb.music.web.user.bean.UserBean;

public interface UserService {
	
	//Login
	public UserBean login(String userid, String passwd);

	public void addUser(UserBean userbean);

	public void addAuthority(String userid, String authority);

	public int editAccount(UserBean userbean);

	public UserBean getUser(String userid);

	public int changePasswd(String currentPasswd, String newPasswd, String userid);

	public void bye(UserBean userbean);



}
