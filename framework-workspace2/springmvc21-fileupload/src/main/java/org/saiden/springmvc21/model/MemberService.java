package org.saiden.springmvc21.model;

public interface MemberService {
	MemberVO findMemberById(String id);
	MemberVO login(MemberVO paramVO);
	int idCheck(String id);
	void registerMember(MemberVO paramVO);
}
