package org.saiden.springmvc18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("findMemberById.do")
	public String findMemberById(String id, Model model){
		if(id.equals("bourbon")){
			model.addAttribute("result", "아무로 토오루 Tokyo");
		}
		else{
			model.addAttribute("result", "검색 정보가 없습니다!");
		}
		return "member/findMemberById_result.tiles";
	}
}
