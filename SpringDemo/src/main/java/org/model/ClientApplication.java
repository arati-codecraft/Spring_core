package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("text.xml");
        Employee e=(Employee) context.getBean("e");
        
        e.show();
	}

}
