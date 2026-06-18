package org.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		Courier c = (Courier) context.getBean("c");
		Parcel p = c.getParcel();
		System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice());
	}

}
