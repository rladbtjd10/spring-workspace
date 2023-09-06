package com.kh.mvc.model.vo;

import lombok.Getter;

@Getter
public class Paging {
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int num = 10; // 한 페이지의 보여질 개수
	
	private int total;
	private Criteria cri;
	
	public Paging(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) Math.ceil((double)cri.getPage() / this.num) * this.num;
		//             (형변환) 올림 (소수점까지나오게)현재페이지 / 10 ) * 10;
		this.startPage = this.endPage - this.num + 1;
		
		int lastPage = (int) Math.ceil((double) total / cri.getAmount());
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
	
	
	
}