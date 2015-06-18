package mplanweb.music.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MusicDAOImpl implements MusicDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selecttotalcount(Ssearch ssearch) {
		return sqlSession.selectOne("Test.selecttotalcount", ssearch);

	}

	@Override
	public List<Ssview> selectSsview(Ssearch ssearch) {
		return sqlSession.selectList("Test.selectSsview", ssearch);

	}

	@Override
	public Ssview viewSSview(Map<String, Object> map) {
		return sqlSession.selectOne("Test.viewSSview", map);
	}

	@Override
	public int insertssearch(Ssview ssview) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Test.insertssearch", ssview);
	}
	@Override
	public void deletessearch(List<Map<String, Object>> mapList) {		
		for (Map<String, Object> map: mapList) {
			sqlSession.delete("Test.deletessearch", map);
		}		
	}
	
}
