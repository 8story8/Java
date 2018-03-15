package org.saiden.springmvc17.model.service;

import org.saiden.springmvc17.model.vo.MemberVO;
import org.saiden.springmvc17.model.vo.PointVO;

public interface MemberService {
	MemberVO findMemberById(String id);
	PointVO findPointById(String id);
	void register(MemberVO mvo, PointVO pvo);
}
