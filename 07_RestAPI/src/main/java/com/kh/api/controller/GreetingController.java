package com.kh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController {
	
	// http://localhost:8080/api/greet --> selectList -get������� �� ����������
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	// http://localhost:8080/board/view?no=23 (x)
	// --> http://localhost:8080/board/23 --> selectOne -url��ο� ������ ��Ű�� ��������
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id) { // PathVariable : URL ����� �Ϻθ� �Ķ���ͷ� ����� ��
		return "Hello REST API case number.." + id;
	}
	
	// http://localhost:8080/search?keyword=Ű����
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content) {
		return new Greeting(500L, content);
	}
}
