package org.saiden.springmvc21.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}

	@Override
	public MemberVO login(MemberVO paramVO) {
		return memberDAO.login(paramVO);
	}

	@Override
	public int idCheck(String id) {
		return memberDAO.idCheck(id);
	}

	@Override
	public void registerMember(MemberVO paramVO) {
		memberDAO.registerMember(paramVO);
	}
}
