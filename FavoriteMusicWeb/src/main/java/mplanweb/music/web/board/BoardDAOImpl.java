package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Autowired(required = false)
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Autowired(required = false)
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int selectTotalCountYboard(BoardSearch boardSearch) {
		return getSqlSession().selectOne(
				"mplanweb.music.web.board.Board.selectTotalCountYboard",
				boardSearch);
	}

	@Override
	public List<Board> selectYboard(BoardSearch boardSearch) {
		return getSqlSession().selectList(
				"mplanweb.music.web.board.Board.selectYboard", boardSearch);
	}

	@Override
	public Board viewYboard(Map<String, Object> map) {
		return getSqlSession().selectOne(
				"mplanweb.music.web.board.Board.viewYboard", map);
	}

	@Override
	public int insertYboard(Board board) {
		return (int) getSqlSession().insert(
				"mplanweb.music.web.board.Board.insertYboard", board);
	}

	@Override
	public int updateYboard(Board board) {
		return (int) getSqlSession().update(
				"mplanweb.music.web.board.Board.updateYboard", board);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			getSqlSession().delete(
					"mplanweb.music.web.board.Board.deleteYboard", map);
		}
	}
}
