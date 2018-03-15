package org.saiden.springmvc21.model;

public interface MemberDAO {
	MemberVO findMemberById(String id);
	MemberVO login(MemberVO paramVO);
	int idCheck(String id);
	void registerMember(MemberVO paramVO);
}
