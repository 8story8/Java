package org.saiden.springmvc17.model.service;

import javax.annotation.Resource;

import org.saiden.springmvc17.model.dao.MemberDAO;
import org.saiden.springmvc17.model.dao.PointDAO;
import org.saiden.springmvc17.model.vo.MemberVO;
import org.saiden.springmvc17.model.vo.PointVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	
	@Resource
	private PointDAO pointDAO;
	
	@Override
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}
	
	@Override
	public PointVO findPointById(String id) {
		return pointDAO.findPointById(id);
	}

	/**
	 * 가입 업무는 회원 정보 등록과 동시에 포인트 적립 또한 반드시 정상 수행되어야 한다.
	 * 만약 어느 업무라도 문제 발생시에는 작업 취소 처리가 되어야 한다.
	 * 모든 작업이 정상 수행될 때에만 실제 DB에 반영되도록 Transaction 관리를 한다.
	 * @Transactional Annotation이 명시된 Business 계층의 Method는
	 * 선언적 방식의 Transaction 관리 대상이 되어
	 * 문제 발생시(예외 발생시) 자동 rollback되고,
	 * 모든 작업이 정상 수행시 commit 처리가 된다.
	 */
	@Transactional
	@Override
	public void register(MemberVO mvo, PointVO pvo) {
		memberDAO.register(mvo);
		pointDAO.register(pvo);
	}
}
