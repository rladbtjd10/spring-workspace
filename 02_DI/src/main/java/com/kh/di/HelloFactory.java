package com.kh.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// hello.properties(�ΰ�����, meta-data)�� ������ �о� 
// Hello ��ü�� ���� return
public class HelloFactory {
	
	private Hello hello;
	private Properties properties;
	
	private static HelloFactory helloFactory;
	private HelloFactory() {}
	public synchronized static HelloFactory getInstance() { // Synchronized(����ȭ)-�ϳ����ϳ��� ó���ϰ��� �Ҷ� / �������� �����尡 �Ѱ��� �ڿ��� ����ϰ��� �� ��, ���� �����͸� ����ϰ� �ִ� �ش� �����带 �����ϰ� ������ ��������� �����Ϳ� ���� �� �� ������ ���� �����Դϴ�.
		
		if(helloFactory == null) {
			helloFactory = new HelloFactory();
		}
		return helloFactory;
	}
	
	//properties file�� �߻�ȭ, ĸ��ȭ�� java.util.Properties ��ü ����
	public void setConfigResource(String configResource) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configResource);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
			
		
	// name�� �ش��ϴ� ��ü ����
	private void newInstanceHello(String name) {
		String className = properties.getProperty(name).trim();
		System.out.println("hello.properties���� ������ className : " + className);
		
		try {
			Class cls = Class.forName(className);
			Object obj = cls.newInstance();
			if(obj instanceof Hello) {
				this.hello = (Hello) obj; //����ȯ
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// Hello ��ü �����ϴ� newInstanceHello() ȣ�� �� Hello ��ü�� return
	public Hello getBean(String name) {
		this.newInstanceHello(name);
		return hello;
	}
}
















