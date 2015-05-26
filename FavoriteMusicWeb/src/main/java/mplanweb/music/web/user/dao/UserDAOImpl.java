package mplanweb.music.web.user.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO{

	
	public int duplicateUser(String userid)
	{
		return (Integer) getSqlSession().selectOne("mplanweb.music.web.user.dao.UserDAO.duplicateUser", userid);
		
	}
	public ArrayList getUserInfo(String userid){
		return (ArrayList) getSqlSession().selectList("mplanweb.music.web.user.dao.UserDAO.getUserInfo", userid);
	}
	public Object insertUser(HashMap map){
		return getSqlSession().insert("mplanweb.music.web.user.dao.UserDAO.insertUser", map);
	}
	public int deleteUser(String userid){
		return (Integer) getSqlSession().delete("mplanweb.music.web.user.dao.UserDAO.deleteUser", userid);
		
	}
}
