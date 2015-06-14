package mplanweb.music.web.uploadtest;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class UploadServiceImpl extends SqlSessionDaoSupport implements
		UploadService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public Upload uploadfile(HashMap<String, Object> result) {
		// TODO Auto-generated method stub
		logger.info("uploadServiceImpl.class : " + result);
		System.out.println("uploadServiceImpl.class : " + result);
		
		
		//sqlSession.insert("", result);
		
		return null;
	}
}
