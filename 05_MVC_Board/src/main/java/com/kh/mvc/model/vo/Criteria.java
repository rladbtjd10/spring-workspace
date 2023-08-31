package com.kh.mvc.model.vo;

import lombok.Getter;
import lombok.Setter;

// page�� amount ���� ���� �����ϴ� �뵵
@Setter
@Getter
public class Criteria {
	
	private int page; // ������ ��ȣ
	private int amount; // �� ������ �� �� ���� �����͸� ��������
	
	public Criteria() {
		this(1, 15); // �⺻�� �����ؼ� ó��
	}
	
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}

}
