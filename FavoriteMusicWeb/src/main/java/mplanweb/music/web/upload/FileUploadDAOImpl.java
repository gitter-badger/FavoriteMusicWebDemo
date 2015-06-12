package mplanweb.music.web.upload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mplanweb.music.web.admin.MainDAO;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class FileUploadDAOImpl extends SqlSessionDaoSupport implements
		UploadDAO {
	@Autowired
	private SqlSession sqlSession;



	@Override
	public void uploadfile(HashMap<String, Object> result) {
		// TODO Auto-generated method stub
		System.out.println(result);
		//sqlSession.insert("mplanweb.music.web.uploadtest.uploadfile", result);
	}

	

}
