package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClentApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("emp1.xml");
		Object obj=context.getBean("e");
		Employee e=(Employee)obj;
		e.show();
	}

}
