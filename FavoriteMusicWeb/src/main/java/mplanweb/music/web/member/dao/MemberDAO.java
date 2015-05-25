package mplanweb.music.web.member.dao;

import java.util.ArrayList;

import mplanweb.music.web.member.bean.Member;

public interface MemberDAO {
	ArrayList<Member> getMembers();
	void insertMember(Member member);
	void updateMember(String name);
	void deleteMember(String name);

}
