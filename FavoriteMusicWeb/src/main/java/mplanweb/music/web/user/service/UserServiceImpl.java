package mplanweb.music.web.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mplanweb.music.web.user.bean.UserBean;
import mplanweb.music.web.user.dao.UserDAO;


@Service("userservice")
public class UserServiceImpl {

	@Autowired
	private UserDAO userdao;
	
	public boolean duplicateUser(String userid){
		int flag = userdao.duplicateUser(userid);
		if(flag==0){
			return true;
		}else{
			return false;
		}
	}
	public List<UserBean> getAllUserInfo(String userid){
		return null;
	}

	public ArrayList getUserInfo(String userid){
		return userdao.getUserInfo(userid);
	}

	public boolean updateUser(String userid, String pwd){
		return false;
	}
	public boolean deleteUser(String userid, String pwd){
		return false;
	}
	public int insertUser(HashMap map){
		userdao.insertUser(map);
		return 0;
	}
}
