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
		return sqlSession.selectOne("mplanweb.music.web.board.Board.selectTotalCountYboard", boardSearch);
	}

	@Override
	public List<Board> selectYboard(BoardSearch boardSearch) {
		return sqlSession.selectList("mplanweb.music.web.board.Board.selectYboard", boardSearch);
	}

	@Override
	public Board viewYboard(Map<String, Object> map) {
		return sqlSession.selectOne("mplanweb.music.web.board.Board.viewYboard", map);
	}

	@Override
	public int insertYboard(Board board) {
		return sqlSession.insert("mplanweb.music.web.board.Board.insertYboard", board);
	}
	@Override
	public int updateYboard(Board board) {
		return sqlSession.update("mplanweb.music.web.board.Board.updateYboard", board);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {		
		for (Map<String, Object> map: mapList) {
			sqlSession.delete("mplanweb.music.web.board.Board.deleteYboard", map);
		}		
	}
}
