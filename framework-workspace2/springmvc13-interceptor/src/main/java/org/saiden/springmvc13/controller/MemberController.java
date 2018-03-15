package org.saiden.springmvc13.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.saiden.springmvc13.model.MemberService;
import org.saiden.springmvc13.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController{
	@Resource
	private MemberService memberService;
	
	@RequestMapping("findMemberById.do")
	public ModelAndView findMemberById(String id){
		 MemberVO mvo = memberService.findMemberById(id);
		
		 if(mvo != null){
			 return new ModelAndView("findMemberById_ok", "info", mvo);
		 }
		 else{
			 return new ModelAndView("findMemberById_fail", "id", id);
		 }
	}
	
	@RequestMapping("getAddressKind.do")
	public String getAddressKind(Model model){
		List<String> list = memberService.getAddressKind();
		model.addAttribute("list", list);
		return "address";
	}
	
	@RequestMapping("findMemberByAddress.do")
	@ResponseBody
	public List<MemberVO> findMemberByAddress(String address){
		return memberService.findMemberByAddress(address);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "login.do")
	public String login(String id, String password, HttpSession session){
		MemberVO mvo = memberService.login(id, password);
		String url = null;
		if(mvo != null){
			session.setAttribute("mvo", mvo);
			url = "redirect:index.do";
		}
		else{
			url = "login_fail";
		}
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		if(session != null){
			session.invalidate();
		}
		return "redirect:index.do";
	}
	
	@RequestMapping("index.do")
	public String home(Model model){
		int totalMemberCount = memberService.getTotalMemberCount();
		model.addAttribute("totalMemberCount", totalMemberCount);
		return "index";
	}
	
	// Cafe에는 Login한 사용자만 Service받을 수 있다.
	// Handler Interceptor에서 공통으로 처리한다.
	@RequestMapping("member_cafe.do")
	public String cafe(HttpServletRequest request){
		// HttpSession session = request.getSession(false);
		// if(session != null && session.getAttribute("mvo") != null){
			return "cafe";	
		// }
		// else{
		// return "redirect:index.do";
		// }
	}
	
	
	// 회원정보 수정폼 페이지 Service는 Login한 사용자만 진입이 가능해야 한다.
	// Handler Interceptor에서 공통으로 처리한다.
	@RequestMapping("member_updateView.do")
	public String updateView(HttpServletRequest request){
		// HttpSession session = request.getSession(false);
		// if(session != null && session.getAttribute("mvo") != null){
			return "update";	
		// }
		// else{
			// return "redirect:index.do";
		// }
	}
	
	// 회원정보 수정은 Login한 사용자만 가능하다.
	// Handler Interceptor에서 공통으로 처리한다.
	@RequestMapping("member_updateMember.do")
	public String updateMember(MemberVO mvo, HttpSession session){
		// if(session != null && session.getAttribute("mvo") != null){
			memberService.updateMember(mvo);
			session.setAttribute("mvo", mvo);
			return "redirect:updateResult.do";
		// }
		// else{
			// return "redirect:index.do";
		// }
	}
	
	@RequestMapping("updateResult.do")
	public String updateResult(HttpServletRequest request){
		return "update_result";
	}
	
	@RequestMapping("registerView.do")
	public String registerView(){
		return "register";
	}
	
	@RequestMapping("idCheck.do")
	@ResponseBody
	public int idCheck(String id){
		return memberService.idCheck(id);
	}
	
	@RequestMapping("registerMember.do")
	public String registerMember(MemberVO mvo){
		memberService.registerMember(mvo);
		return "redirect:register_result.do?id="+mvo.getId();
	}
	
	@RequestMapping("register_result.do")
	public String registerResult(String id, Model model){
		model.addAttribute("registerMvo", memberService.findMemberById(id));
		return "register_result";
	}
}
