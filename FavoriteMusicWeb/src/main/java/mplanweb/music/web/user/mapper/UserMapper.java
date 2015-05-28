package mplanweb.music.web.user.mapper;

import org.apache.ibatis.annotations.Param;

import mplanweb.music.web.user.bean.UserBean;

public interface UserMapper {
	
	public UserBean login(
			@Param("userid") String userid,
			@Param("passwd") String passwd);

}
