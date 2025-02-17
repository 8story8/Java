package org.saiden.springmvc13.model;

import java.util.List;

public interface MemberDAO {
	MemberVO findMemberById(String id);
	List<String> getAddressKind();
	List<MemberVO> findMemberByAddress(String address);
	MemberVO login(String id, String password);
	void updateMember(MemberVO mvo);
	int getTotalMemberCount();
	int idCheck(String id);
	void registerMember(MemberVO mvo);
}
