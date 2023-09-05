package com.kh.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Person;

@RestController //�ּҸ� ��� ���� �ϴ��İ� �߿�
@RequestMapping("/simple")
public class SimpleController {
	
	/*
	 * REST (Representational State Transfer)
	 * - �ϳ��� URI�� �ϳ��� ������ ���ҽ�(Resource)�� ��ǥ�ϵ��� �����ϴ� ���۹��
	 * - ���� ����ؾ� �� ���� �������� ������ ��ü�� �����ϴ� ������� ó���Ѵٴ� ��!
	 * 
	 * API (Application Programming Interface)
	 * - ��ǻ�Ϳ� ��ǻ�� ������ ��ȣ�ۿ��� ���� ���� ���
	 * 
	 * @RestController 
	 * - Controller�� REST ����� ó���ϱ� ���� ������ ���
	 * - �޼����� ���� Ÿ������ ����ڰ� ������ Ŭ���� Ÿ�Ե� ����� �� �հ�,
	 * 	 �� �ܿ��� ���� Ÿ������ �����µ� �̸� JSON�̳� XML�� �ڵ� ó��
	 * 
	 * JSON (JavaScript Object Notation)
	 * - �����͸� { }�� ��� Ű�� ������ �����ϴ� ������ ����
	 */

	// http://localhost:8080/api/simple/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful API";
	}
	
	@GetMapping("/greet")
	public Person sayGreet() {
		Person p = new Person("����", "����������..");
		return p;
	}
	
	@GetMapping("/allGreet")
	public List<Person> allGreet() {
		List<Person> list = new ArrayList();
		for(int i=0; i<5; i++) {
			Person p = new Person();
			p.setName("�ݿ���" + i);
			p.setMassage("���� �ƴ�" + i);
			list.add(p);
		}
		return list;
	}
	
	@GetMapping("/sendGreet")
	public Map<Integer, Person> sendGreet() {
		Map<Integer, Person> map = new HashMap();
		map.put(1, new Person("����", "��� ��������..!"));
		return map;
	}
	
	
}
