package mplanweb.music.web.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mplanweb.music.web.user.bean.UserBean;

public interface UserService {

	public boolean duplicateUser(String userid);

	public List<UserBean> getAllUserInfo(String userid);

	public ArrayList getUserInfo(String userid);

	public int insertUser(HashMap map);

	public boolean updateUser(String userid, String pwd);

	public boolean deleteUser(String userid, String pwd);

}
