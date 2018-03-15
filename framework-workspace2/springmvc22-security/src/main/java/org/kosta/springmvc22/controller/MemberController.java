package org.kosta.springmvc22.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.springmvc22.model.MemberService;
import org.kosta.springmvc22.model.MemberVO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	//회원정보수정시 비밀번호 암호화처리를 위한 객체를 주입받는다
	@Resource
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("findMemberById.do")
	public ModelAndView findMemberById(String id) {
		MemberVO vo = memberService.findMemberById(id);
		if (vo == null)
			return new ModelAndView("member/findMemberById_fail.tiles");
		else
			return new ModelAndView("member/findMemberById_ok.tiles", "memberVO", vo);
	}

	@RequestMapping("addressList.do")
	public ModelAndView addressList() {
		System.out.println("addressList");
		return new ModelAndView("member/addressList.tiles", "list", memberService.getAddressList());
	}

	@RequestMapping("findMemberListByAddress.do")
	@ResponseBody
	public List<MemberVO> findMemberListByAddress(String address) {
		System.out.println("findMemberListByAddress");
		return memberService.findMemberListByAddress(address);
	}
	@RequestMapping("login_fail.do")
    public String loginFail(){
    	return "member/login_fail.tiles";
    }
	/*
	 * @RequestMapping(value="login.do",method=RequestMethod.POST) 
	 * public String  login(MemberVO memberVO,HttpServletRequest request){ MemberVO
	 * vo=memberService.login(memberVO); if(vo==null){ return
	 * "member/login_fail"; }else{ request.getSession().setAttribute("mvo", vo);
	 * return "home"; } }
	 */
	/*
	 * @RequestMapping("logout.do") public String logout(HttpServletRequest
	 * request) { HttpSession session = request.getSession(false); if (session
	 * != null) session.invalidate(); return "home"; }
	 */
	@Secured("ROLE_MEMBER")
	// 관리자만 들어가야 할 경우
	// @Secured({"ROLE_MEMBER","ROLE_ADMIN"})
	@RequestMapping("enterCafe.do")
	public ModelAndView enterCafe() {
		return new ModelAndView("member/cafe.tiles", "count", memberService.getMemberCount());
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping("updateForm.do")
	public String updateForm() {
		return "member/updateForm.tiles";
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping("updateMemberAction.do")
	public String updateMemberAction(HttpServletRequest request, MemberVO memberVO) {
		// Spring Security 세션 회원정보를 반환받는다
		MemberVO pvo = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Spring Security 세션 수정 전 회원정보:" + pvo);
		//변경할 비밀번호를 암호화한다 
		String encodePassword=passwordEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(encodePassword);
		memberService.updateMember(memberVO);
		// 수정한 회원정보로 Spring Security 세션 회원정보를 업데이트한다
		pvo.setPassword(encodePassword);
		pvo.setName(memberVO.getName());
		pvo.setAddress(memberVO.getAddress());
		System.out.println("Spring Security 세션 수정 후 회원정보:" + pvo);
		return "member/update_result.tiles";
	}

	@RequestMapping(value = "registerMember.do", method = RequestMethod.POST)
	public String register(MemberVO vo) {
		memberService.registerMember(vo);
		return "redirect:registerResultView.do?id=" + vo.getId();
	}

	@RequestMapping("registerResultView.do")
	public ModelAndView registerResultView(String id) {
		MemberVO vo = memberService.findMemberById(id);
		return new ModelAndView("member/register_result.tiles", "memberVO", vo);
	}

	@RequestMapping("idcheckAjax.do")
	@ResponseBody
	public String idcheckAjax(String id) {
		return memberService.idcheck(id);
	}
}
