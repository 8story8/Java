package org.saiden.springmvc21.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}

	@Override
	public MemberVO login(MemberVO paramVO) {
		return template.selectOne("member.login", paramVO);
	}

	@Override
	public int idCheck(String id) {
		return template.selectOne("member.idCheck", id);
	}

	@Override
	public void registerMember(MemberVO paramVO) {
		template.insert("member.registerMember", paramVO);
	}

}
