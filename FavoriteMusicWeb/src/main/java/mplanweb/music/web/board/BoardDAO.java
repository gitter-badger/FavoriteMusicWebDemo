package mplanweb.music.web.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	/**
	 * 총 리스트 갯수
	 * 
	 * @param yboard
	 * @return
	 */
	public int selectTotalCountYboard(BoardSearch boardSearch);

	/**
	 * Yboard 리스트 출력
	 * 
	 * @param yboard
	 * @return
	 */
	public List<Board> selectYboard(BoardSearch boardSearch);

	/**
	 * 선택한 Yboard 보기
	 * 
	 * @param map
	 * @return
	 */
	public Board viewYboard(Map<String, Object> map);

	/**
	 * Yboard 입력
	 * 
	 * @param yboard
	 * @return
	 */
	public int insertYboard(Board board);

	/**
	 * Yboard 업데이트
	 * 
	 * @param yboard
	 * @return
	 */
	public int updateYboard(Board board);

	/**
	 * 선택한 Yboard 삭제
	 * 
	 * @param map
	 * @return
	 */
	public void deleteYboard(List<Map<String, Object>> mapList);

}
