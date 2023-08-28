package com.kh.dice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DiceTestApp2 {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/dice.xml")); //���忪��
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/dice.xml");
		
		Player player1 = (Player) factory.getBean("player1");
		player1.playDice(3);
		System.out.println("=====================");
		System.out.println("���õ� �ֻ��� ���� ������ : " + player1.getTotalValue());
		System.out.println("=====================");
		
		Player player2 = (Player) factory.getBean("player2");
		player2.playDice(3);
		System.out.println("=====================");
		System.out.println("���õ� �ֻ��� ���� ������ : " + player2.getTotalValue());
		System.out.println("=====================");
		
		Player player3 = (Player) factory.getBean("player3");
		player3.playDice(3);
		System.out.println("=====================");
		System.out.println("���õ� �ֻ��� ���� ������ : " + player3.getTotalValue());
		System.out.println("=====================");
	}

}
