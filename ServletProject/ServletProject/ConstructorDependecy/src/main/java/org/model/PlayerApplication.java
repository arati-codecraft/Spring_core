package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Test.xml");
		 Player p=(Player)context.getBean("p");
		 System.out.println(p);
		}

}
