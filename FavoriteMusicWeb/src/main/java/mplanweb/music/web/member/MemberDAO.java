package mplanweb.music.web.member;

public interface MemberDAO {

	// 회원가입
	public void adduser(Member member);

	// 회원권한
	public void addgroup(String userid, String authority);

	// 로그인
	public Member login(String userid, String passwd);

	// 정보수정
	public int editAccount(Member member);

	// 비밀번호 변경
	public int changepwd(String currentPasswd, String newPasswd, String userid);

	// 탈퇴
	public void drop(Member member);

	// 회원 찾기
	public Member getUser(String userid);
}
