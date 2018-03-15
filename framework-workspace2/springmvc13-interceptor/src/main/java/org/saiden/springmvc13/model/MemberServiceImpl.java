package org.saiden.springmvc13.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource	
	private MemberDAO memberDAO;
	
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}
	
	public List<String> getAddressKind(){
		return memberDAO.getAddressKind();
	}

	@Override
	public List<MemberVO> findMemberByAddress(String address) {
		return memberDAO.findMemberByAddress(address);
	}

	@Override
	public MemberVO login(String id, String password) {
		return memberDAO.login(id, password);
	}

	@Override
	public void updateMember(MemberVO mvo) {
		memberDAO.updateMember(mvo);
	}

	@Override
	public int getTotalMemberCount() {
		return memberDAO.getTotalMemberCount();
	}

	@Override
	public int idCheck(String id) {
		return memberDAO.idCheck(id);
	}

	@Override
	public void registerMember(MemberVO mvo) {
		memberDAO.registerMember(mvo);
	}
}
