package com.kh.dice;

import lombok.Data;

@Data
public class Player {
	
	private Dice dice;
	private int totalValue;
	
	public Player(Dice dice) {
		this.dice = dice;
	}
	
	//count ��ŭ �ֻ����� ������ ���� �ű�� �޼���
	public void playDice(int count) {
		System.out.println("==>" + getClass().getName() + ".playDice() start~");
		
		for(int i=0; i<count; i++) {
			dice.selectedNumber();
			
			System.out.println("[" + dice.getClass().getName() + "] �� ���õ� �� : " + dice.getValue());
			totalValue += dice.getValue();
		}
		
		System.out.println("==>" + getClass().getName() + ".palyDice() end...");
	}
	
}
