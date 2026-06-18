package org.model;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Test.xml");
		MSME m = (MSME) context.getBean("m");
		m.showCompanyDetails();

	}

}
