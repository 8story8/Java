package org.saiden.springmvc20.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.saiden.springmvc20.model.MemberService;
import org.saiden.springmvc20.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping("findMemberById.do")
	public String findMemberById(String id, Model model){
		model.addAttribute("result", memberService.findMemberById(id));
		return "member/findMemberById_result.tiles";
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, MemberVO paramVO){
		MemberVO mvo = memberService.login(paramVO);
		
		if(mvo != null){
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);
			return "redirect:home.do";
		}
		else{
			return "member/login_fail";
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		
		if(session != null){
			session.invalidate();
		}
		
		return "redirect:home.do";
	}
	
	@RequestMapping("registerForm.do")
	public String registerForm(){
		return "member/register_form.tiles";
	}
	
	@RequestMapping("idCheck.do")
	@ResponseBody
	public int idCheck(String id){
		return memberService.idCheck(id);
	}
	
	@RequestMapping(value="registerMember.do", method = RequestMethod.POST)
	public String registerMember(MemberVO paramVO){
		memberService.registerMember(paramVO);
		return "redirect:registerResult.do?id=" + paramVO.getId();
	}
	
	@RequestMapping("registerResult.do")
	public String registerResult(String id, Model model) throws UnsupportedEncodingException{
		model.addAttribute("registerMvo", memberService.findMemberById(id));
		return "member/register_result.tiles";
	}
}
