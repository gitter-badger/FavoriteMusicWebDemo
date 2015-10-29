package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import mplanweb.music.web.source.Ssearch;
import mplanweb.music.web.source.Ssview;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	public int boardcount(BoardCount boardcount) {
		return sqlSession.selectOne("mplanboard.boardcount", boardcount);
	}

	// search
	public List<BoardDTO> boardsearch(BoardCount boardcount) {
		return sqlSession.selectList("mplanboard.boardsearch", boardcount);
	}

	// view
	public BoardDTO boardview(Map<String, Object> map) {
		return sqlSession.selectOne("mplanboard.boardview", map);
	}

	// board insert
	public int boardinsert(BoardDTO boarddto) {
		return sqlSession.insert("mplanboard.boardinsert", boarddto);
	}

	// board update
	public int boardupdate(BoardDTO boarddto) {
		return sqlSession.update("mplanboard.boardupdate", boarddto);
	}

	// board delete
	public void boarddelete(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			sqlSession.delete("mplanboard.boarddelete", map);
		}
	}


}
