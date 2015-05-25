package mplanweb.music.web.member.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mplanweb.music.web.member.bean.Member;
import mplanweb.music.web.member.dao.MemberDAO;


@Repository
public class MemberDAOService implements MemberDAO{


	@Autowired
	private SqlSession sqlSession;
	@Override
	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		ArrayList<Member> result = new ArrayList<Member>();

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		result = memberMapper.getMembers();
		
		return result;
	}

	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
		
	}

	@Override
	public void updateMember(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String name) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(name);
	}

	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		
	}
	
	

}
