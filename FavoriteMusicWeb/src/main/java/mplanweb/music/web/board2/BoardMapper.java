package mplanweb.music.web.board2;


import java.util.HashMap;
import java.util.List;



public interface BoardMapper {
	//목록
	public List<Article> selectListOfArticles(HashMap<String, String> hashmap);	
	
	//총 레코드
	public int selectCountOfArticles(HashMap<String, String> hashmap);
	
	//글쓰기
	public int insert(Article article);	

	//첨부파일 추가
	public void insertAttachFile(AttachFile attachFile);

	//글수정
	public void update(Article article);
	
	//글삭제
	public void delete(int articleNo);
	
	//조회수 증가
	public void updateHitPlusOne(int articleNo);	
	
	//상세보기
	public Article selectOne(int articleNo);
	
	//다음글
	public Article selectNextOne(HashMap<String, String> hashmap); 
	
	//이전글
	public Article selectPrevOne(HashMap<String, String> hashmap);

	//첨부파일 리스트
	public List<AttachFile> selectListOfAttachFiles(int articleNo);	

	//첨부파일 삭제
	public void deleteFile(int attachFileNo);	
	
	//게시판 이름
	public String selectOneBoardName(String boardCd);

	//댓글 쓰기
	public void insertComment(Comment comment);	
	
	//댓글 수정
	public void updateComment(Comment comment);
	
	//댓글 삭제
	public void deleteComment(int commentNo);

	//댓글 리스트
	public List<Comment> selectListOfComments(int articleNo);
	
	//첨부파일 찾기
	public AttachFile selectOneAttachFile(int attachFileNo);

	//댓글 찾기
	public Comment selectOneComment(int commentNo);

}