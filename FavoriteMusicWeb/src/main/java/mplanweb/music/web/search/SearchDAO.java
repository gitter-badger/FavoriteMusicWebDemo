package mplanweb.music.web.search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDAO implements SearchService {

	@Autowired
	private SqlSession sqlSession;

	public List<SearchDTO> listall(String artist) {
		// TODO Auto-generated method stub

		// logger.info("uploadServiceImpl.class : " + uploadfile);
		System.out.println("uploadServiceImpl.class : " + artist);

		return sqlSession.selectList("Query.listall", artist);
	}
}
