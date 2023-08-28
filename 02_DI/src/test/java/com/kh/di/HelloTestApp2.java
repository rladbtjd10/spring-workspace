package com.kh.di;

public class HelloTestApp2 {

	public static void main(String[] args) {
		
		// 1. ����� Bean ������ ���� hello.properties�� parsing,
		//     Bean ��ü�� ������ HelloFactory ��ü ����
		HelloFactory helloFactory = HelloFactory.getInstance();
		
		// 2. helloFactory ��ü�� parsing �� resource ����
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");
		
		// 3. helloFactory ��ü�κ��� instance.one �̸��� ���� Hello ��ü�� return -���ϳ��� ������ �´ٶ�� ����
		Hello hello = helloFactory.getBean("instance.one");
		
		// 4. printMessage() ȣ��
		hello.printMessage();
		
		

	}

}
