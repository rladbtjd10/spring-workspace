package com.kh.mvc.controller;

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
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		// ���� - ����Ͻ� ���� ó��!
		//  --> list ��! ������ ���ε� -> Model!
		// model.addAllAttributes("list", list);
		return "find_ok"; // "find_fail"
	}
	
	@RequestMapping("register") 
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp") 
	public String signUp(Member member) {
		System.out.println(member);
		// ����Ͻ� ����
		return "redirect:/"; //index.jsp�� �ѱ涧. view�ۿ� ��ġ������
	}
	
	// login - ������ �̵�
	
	// signIn - �����Ͻ� ���� ���� : �Ķ���� �� -> HttpServletRequest request
	// -> return "login_result"
	
	// allMember - �����Ͻ� ���� ����, �����͹��ε� - Model --> return "find_ok";
	// --> return "find_ok";
	
	// logout - �α׾ƿ� ���!
	
	// update - ������ �̵�
	
	// updateMember - �����Ͻ� ���� ���� -> �Ķ���� request �ʿ�
}



















