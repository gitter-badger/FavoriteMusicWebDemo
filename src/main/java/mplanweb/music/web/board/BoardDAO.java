package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

import mplanweb.music.web.source.Ssearch;
import mplanweb.music.web.source.Ssview;

public interface BoardDAO {

	//count
	public int boardcount(BoardCount boardcount);
	
	// search
	 public List<BoardDTO> boardsearch(BoardCount boardcount);
	 
	// view
	public BoardDTO boardview(Map<String, Object> map);
	
	//board insert
	public int boardinsert(BoardDTO boarddto);
	
	//board update
	public int boardupdate(BoardDTO boarddto);
	
	//board delete
	public void boarddelete(List<Map<String, Object>> mapList);
	//board file
	
	//reply insert
	
	//reply update
	
	//reply delete
	
	
}
