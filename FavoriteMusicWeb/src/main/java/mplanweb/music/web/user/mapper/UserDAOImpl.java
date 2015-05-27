package mplanweb.music.web.user.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import mplanweb.music.web.user.bean.UserBean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	// @Autowired(required = false)
	public int duplicateUser(String userid) {
		return (Integer) getSqlSession().selectOne(
				"mplanweb.music.web.user.dao.UserDAO.duplicateUser", userid);

	}

	// @Autowired(required = false)
	public ArrayList getUserInfo(String userid) {
		return (ArrayList) getSqlSession().selectList(
				"mplanweb.music.web.user.dao.UserDAO.getUserInfo", userid);
	}

	// @Autowired(required = false)
	public Object insertUser(HashMap map) {
		return getSqlSession().insert(
				"mplanweb.music.web.user.dao.UserDAO.insertUser", map);
	}

	// @Autowired(required = false)
	public int deleteUser(String userid) {
		return (Integer) getSqlSession().delete(
				"mplanweb.music.web.user.dao.UserDAO.deleteUser", userid);

	}

	@Override
	public ArrayList login(String userid, String passwd) {
		// TODO Auto-generated method stub
		return (ArrayList) getSqlSession().selectList(
				"mplanweb.music.web.user.dao.UserDAO.loginUser", userid);
	}
}
