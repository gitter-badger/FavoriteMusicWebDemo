package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectTotalCountYboard(BoardSearch boardSearch) {
		return sqlSession.selectOne("Yboard.selectTotalCountYboard", boardSearch);
	}

	@Override
	public List<Board> selectYboard(BoardSearch boardSearch) {
		return sqlSession.selectList("Yboard.selectYboard", boardSearch);
	}

	@Override
	public Board viewYboard(Map<String, Object> map) {
		return sqlSession.selectOne("Yboard.viewYboard", map);
	}

	@Override
	public int insertYboard(Board board) {
		return sqlSession.insert("Yboard.insertYboard", board);
	}

	@Override
	public int updateYboard(Board board) {
		return sqlSession.update("Yboard.updateYboard", board);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {		
		for (Map<String, Object> map: mapList) {
			sqlSession.delete("Yboard.deleteYboard", map);
		}		
	}
}
