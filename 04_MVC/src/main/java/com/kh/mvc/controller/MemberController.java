package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	// <�˻�>
	// �ܼ� �̵�
	@RequestMapping("search")
	public String search() {
		return "search"; // -> sevlecontext�� "/WEB-INF/views/"�޺κп� search�� �پ �� ��η� ����
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		// getParameter �κ��� �ʿ䰡 ����
		// ���� - ����Ͻ� ���� ó��!
		//  --> list ��! ������ ���ε� -> Model!
		// model.addAllAttributes("list", list);
		List<Member> list = service.findMember(keyword);
		
		if(list.size() > 0) {
			model.addAttribute("list", list);
			return "find_ok";
		}
		return "find_fail"; // "find_fail"
	}
	
	// <ȸ������>
	// ������ �̵�
	@RequestMapping("register") 
	public String register() {
		return "register";
	}
	
	// ����Ͻ� ���� ó��
	@RequestMapping("signUp") 
	public String signUp(Member member) {
		//����Ͻ� ����
		// register.jsp���� name���̶� �ʵ�� ���߶� �ߴ� ������ getParameter
		// ���� �׳� Member�� ���� �� �־
		service.registerMember(member);
		return "redirect:/"; //index.jsp�� �ѱ涧. view�ۿ� ��ġ������
	}
	
	// login - ������ �̵�
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	// signIn - ����Ͻ� ���� ����
	//   : �Ķ���� �� -> HttpServletRequest request
	// -> return "login_result"
	@RequestMapping("signIn")
	public String signIn(Member vo, HttpSession session) {
		Member member = service.login(vo);
		
		if(member != null) {
			session.setAttribute("vo", member);
		}
		return "login_result";
	}
	
	
	// allMember - �����Ͻ� ���� ����, �����͹��ε� - Model
	// --> return "find_ok";
	@RequestMapping("allMember") 
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		model.addAttribute("list", list);
		return "find_ok";
	}
	
	// logout - �α׾ƿ� ���!
	@RequestMapping("logout") 
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	// update - ������ �̵�
	@RequestMapping("update") 
	public String update() {
		return "update";
	}
	
	// updateMember - �����Ͻ� ���� ���� -> �Ķ���� request �ʿ�
	@RequestMapping("updateMember") 
	public String updateMember(Member vo, HttpSession session) {
		service.updateMember(vo);
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		}
		return "redirect:/";
	}
	
}



















