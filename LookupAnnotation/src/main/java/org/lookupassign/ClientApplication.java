package org.lookupassign;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigApp.class);
		Test t1=(Test)context.getBean("test");
		Demo d1=t1.display();
		Demo d2=t1.display();
		Demo d3=t1.display();
		Demo d4=t1.display();
	}
}
