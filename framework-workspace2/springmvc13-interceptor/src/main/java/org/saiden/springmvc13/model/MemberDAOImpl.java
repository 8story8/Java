package org.saiden.springmvc13.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}

	@Override
	public List<String> getAddressKind() {
		return template.selectList("member.getAddressKind");
	}

	@Override
	public List<MemberVO> findMemberByAddress(String address) {
		return template.selectList("member.findMemberByAddress", address);
	}

	@Override
	public MemberVO login(String id, String password) {
		MemberVO mvo = new MemberVO(id, password);
		return template.selectOne("member.login", mvo);
	}

	@Override
	public void updateMember(MemberVO mvo) {
		template.update("member.updateMember", mvo);
	}

	@Override
	public int getTotalMemberCount() {
		return template.selectOne("member.getTotalMemberCount");
	}

	@Override
	public int idCheck(String id) {
		return template.selectOne("member.idCheck", id);
	}

	@Override
	public void registerMember(MemberVO mvo) {
		template.insert("member.registerMember", mvo);
	}

}
