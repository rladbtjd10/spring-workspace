package com.kh.di;

import lombok.Data;

@Data
public class Hello {
	
	private String message = "Hello~";
	
	public Hello() {
		System.out.println(getClass().getName() + "...Instance Create.."); //getClass().getName()출력하면 class를 포함한 패키지명 보여줌
	}
	
	public void printMessage() {
		System.out.println(getClass().getName() + "=> " + message);
	}

}
