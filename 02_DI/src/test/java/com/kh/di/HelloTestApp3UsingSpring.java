package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTestApp3UsingSpring {

	public static void main(String[] args) {
		// 1. BeanFactory ����.. �ֹ����� ���忡�� �̸� �޾Ƽ� �б�
		// Bean Configuration File : ��(Bean) ��������
		System.out.println("1. BeanFactory ����...");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/hello.xml"));
		
		// 2. getBean()���� ���� �޾ƿͼ� printMessage() ȣ��
		System.out.println("2. getBean() Ŭ���̾�Ʈ ȣ��...");
		Hello hello = (Hello) factory.getBean("hello");
		hello.printMessage();
	}

}
