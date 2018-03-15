package org.saiden.springmvc17.model.dao;

import org.saiden.springmvc17.model.vo.MemberVO;

public interface MemberDAO {
	MemberVO findMemberById(String id);
	void register(MemberVO mvo);
}
