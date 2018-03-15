package org.saiden.springmvc17.controller;

import javax.annotation.Resource;

import org.saiden.springmvc17.model.service.MemberService;
import org.saiden.springmvc17.model.vo.MemberVO;
import org.saiden.springmvc17.model.vo.PointVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	
	@RequestMapping("home.do")
	public String home(){
		return "home";
	}
	
	@RequestMapping("findMemberById.do")
	public String findMemberById(String id, Model model){
		model.addAttribute("memberVO", memberService.findMemberById(id));
		return "find_member_result";
	}
	
	@RequestMapping("findPointById.do")
	public String findPointById(String id, Model model){
		model.addAttribute("pointVO", memberService.findPointById(id));
		return "find_point_result";
	}
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String register(MemberVO mvo, PointVO pvo){
		memberService.register(mvo, pvo);
		return "redirect:registerResult.do";
	}
	
	@RequestMapping("registerResult.do")
	public String registerResult(){
		return "register_result";
	}
}
