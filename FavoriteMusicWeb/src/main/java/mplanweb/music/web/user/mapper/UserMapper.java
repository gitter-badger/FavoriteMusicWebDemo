package mplanweb.music.web.user.mapper;

import org.apache.ibatis.annotations.Param;

import mplanweb.music.web.user.bean.UserBean;

public interface UserMapper {
	
	public UserBean login(
			@Param("userid") String userid,
			@Param("passwd") String passwd);

	public void insert(UserBean userbean);

	public void insertAuthority(String userid, String authority);

	public int update(UserBean userbean);

	public UserBean selectOne(String userid);

	public int updatePasswd(String currentPasswd, String newPasswd,
			String userid);

	public void deleteAuthority(String email);

	public void delete(UserBean userbean);

}
