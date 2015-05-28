package mplanweb.music.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mplanweb.music.web.user.bean.UserBean;
import mplanweb.music.web.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserBean login(String userid, String passwd) {
		// TODO Auto-generated method stub
		return userMapper.login(userid, passwd);
	}

}
