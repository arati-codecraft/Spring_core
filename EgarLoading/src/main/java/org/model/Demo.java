package org.model;

import org.springframework.stereotype.Component;
@Component
public class Demo {

	public Demo() {
		System.out.println("Demo bean object created by spring container");
	}
}
