package com.kh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// �Ϲ����� �ڹ� Ŭ������ �ƴ϶� �ֽ���Ʈ���� ��Ÿ����.
@Aspect
public class CharacterAspect {
	
	/*
	 * * ����Ʈ�� ǥ����
	 *  execution([���ľ�] ����Ÿ�� [Ŭ�����̸�].�̸�(�Ķ����))
	 *  - ���ľ� : public, private �� ���ľ ��� (���� ����)
	 *  - ����Ÿ�� : ���� Ÿ���� ���
	 *  - Ŭ���� �̸� �� �̸� : Ŭ���� �̸��� �޼��� �̸��� ��� (Ŭ���� �̸��� Ǯ��Ű�������� ���, ���� ����)
	 *  - �Ķ���� : �޼����� �Ķ���͸� ��� 
	 *  - " * " : ��� ���� ǥ���Ѵ�
	 *  - " .. " : 0�� �̻��� �ǹ��Ѵ�
	 */
	@Pointcut("execution(* com.kh.character.Character.quest(..))")
	public void questPointcut() {}
			
	
	@Before(value="questPointcut()")
	public void beforeQuest(JoinPoint jp) {
		// ����Ʈ�� �����ϱ� ���� �ʿ��� �ΰ� �۾��� ����
		String questName = (String) jp.getArgs()[0];
		System.out.println(questName + "����Ʈ �غ� ��..");
	}
	
	@After("execution(* com.kh.character.Character.quest(..))")
	public void afterQuest() {
		System.out.println("����Ʈ ���� �Ϸ�..");
	}
	
	@Around("execution(* com.kh.character.Weapon.attack())")
	public String attackAdvice(ProceedingJoinPoint jp) {
		String result = null;
		
		System.out.println("������ �غ��� �Դϴ�..");
		
		try {
			result = (String) jp.proceed();
			System.out.println(result);
			System.out.println("������ �����߽��ϴ�..");
		} catch (Throwable e) {
			System.out.println("������ �߻��Ͽ����ϴ�..");
			e.printStackTrace();
		}
		
		return result;
	}
	/*
	@Around("execution(* com.kh.character.Character.quest(..))")
	public String questAdvice(ProceedingJoinPoint jp) {
		String result = null;
		return result;
	}
	*/

}
