package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		MSME m1 = (MSME) context.getBean("m");
		MSME m2 = (MSME) context.getBean("m");

		 System.out.println("I am m1 "+System.identityHashCode(m1));
		 System.out.println("I am m2 "+System.identityHashCode(m2));


	}

}
