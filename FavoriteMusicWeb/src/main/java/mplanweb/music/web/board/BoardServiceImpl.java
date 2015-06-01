package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int selectTotalCountYboard(BoardSearch boardSearch) {
		return boardDAO.selectTotalCountYboard(boardSearch);
	}

	@Override
	public List<Board> selectYboard(BoardSearch boardSearch) {
		return boardDAO.selectYboard(boardSearch);
	}

	@Override
	public Board viewYboard(Map<String, Object> map) {
		return boardDAO.viewYboard(map);
	}

	@Override
	public int insertYboard(Board board) {
		return boardDAO.insertYboard(board);
	}

	@Override
	public int updateYboard(Board board) {
		return boardDAO.updateYboard(board);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {
		boardDAO.deleteYboard(mapList);
	}

}
