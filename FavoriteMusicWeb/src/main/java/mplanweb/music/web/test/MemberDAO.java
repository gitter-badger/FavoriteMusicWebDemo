package mplanweb.music.web.test;

import java.util.ArrayList;

public interface MemberDAO {
	ArrayList<Member> getMembers();
	void insertMember(Member member);
	void updateMember(String name);
	void deleteMember(String name);

}
