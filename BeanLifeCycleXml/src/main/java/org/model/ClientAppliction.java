package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientAppliction {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("test.xml");
       Employee employee=(Employee)context.getBean("e");
        employee.display();
		 context.close();
	}

}
