package mplanweb.music.web.upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;



@Repository
public class UploadServiceImpl  implements
		UploadService {

	@Autowired
	private SqlSession sqlSession;


	public void upfile(Uploadfile uploadfile) {
		// TODO Auto-generated method stub
	
			//logger.info("uploadServiceImpl.class : " + uploadfile);
			System.out.println("uploadServiceImpl.class : " + uploadfile);
			
			sqlSession.insert("mplanweb.music.web.upload.upfile", uploadfile);
	}



}
