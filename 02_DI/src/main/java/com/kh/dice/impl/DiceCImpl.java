package com.kh.dice.impl;

import java.util.Random;

import com.kh.dice.Dice;

public class DiceCImpl implements Dice {
	
	private int value;
	
	public DiceCImpl() {
		System.out.println(getClass().getName() + "������..");
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

	@Override
	public int getValue() {
		return value;
	}
	

}
