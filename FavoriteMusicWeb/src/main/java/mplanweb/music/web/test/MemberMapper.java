package mplanweb.music.web.test;

import java.util.ArrayList;
import mplanweb.music.web.test.Member;

public interface MemberMapper {
	ArrayList<Member> getMembers();

	void insertMember(Member member);

	void updateMember(String name);

	void deleteMember(String name);

}
