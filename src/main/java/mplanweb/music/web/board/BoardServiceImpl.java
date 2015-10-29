package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mplanweb.music.web.source.SsAlbum;
import mplanweb.music.web.source.Ssearch;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boarddao;

	// count
	public int boardcount(BoardCount boardcount) {
		return boarddao.boardcount(boardcount);

	}

	// search
	public List<BoardDTO> boardsearch(BoardCount boardcount) {
		return boarddao.boardsearch(boardcount);

	}

	// view
	public BoardDTO boardview(Map<String, Object> map) {
		return boarddao.boardview(map);

	}

	// board insert
	public int boardinsert(BoardDTO boarddto) {
		return boarddao.boardinsert(boarddto);
	}

	// board update
	public int boardupdate(BoardDTO boarddto) {
		return boarddao.boardupdate(boarddto);
	}

	// board delete
	public void boarddelete(List<Map<String, Object>> mapList) {
		boarddao.boarddelete(mapList);
	}


}
