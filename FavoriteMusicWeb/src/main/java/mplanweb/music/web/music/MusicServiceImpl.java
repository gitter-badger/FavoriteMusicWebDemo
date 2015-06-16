package mplanweb.music.web.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;



@Repository
public class MusicServiceImpl  implements
		MusicService {

	@Autowired
	private SqlSession sqlSession;
	public void artistinsert(Artist Label) {
		// TODO Auto-generated method stub
			System.out.println("MusicServiceImpl.class : " + Label);		
			sqlSession.insert("Music.artistinsert", Label);
	}



}
