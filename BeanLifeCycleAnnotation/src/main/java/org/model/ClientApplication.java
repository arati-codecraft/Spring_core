package org.model;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ClientApplication {
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigTest.class);
		Employee employee=(Employee)context.getBean("e");//object +depenceny+ init method
		 employee.display();//utility 
		 context.close();//destroy method call 
	}
}
