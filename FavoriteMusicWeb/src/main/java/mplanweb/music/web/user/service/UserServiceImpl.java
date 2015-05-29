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

	@Override
	public void addUser(UserBean userbean) {
		// TODO Auto-generated method stub
		userMapper.insert(userbean);

	}

	@Override
	public void addAuthority(String userid, String authority) {
		// TODO Auto-generated method stub
		userMapper.insertAuthority(userid, authority);
	}

	@Override
	public int editAccount(UserBean userbean) {
		// TODO Auto-generated method stub
		return userMapper.update(userbean);
	}

	@Override
	public UserBean getUser(String userid) {
		// TODO Auto-generated method stub
		return userMapper.selectOne(userid);
	}

	@Override
	public int changePasswd(String currentPasswd, String newPasswd,
			String userid) {
		// TODO Auto-generated method stub
		return userMapper.updatePasswd(currentPasswd, newPasswd, userid);
	}

	public void bye(UserBean userbean) {
		userMapper.deleteAuthority(userbean.getEmail());
		userMapper.delete(userbean);
	}

}
