package org.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component("d")
@Lazy
public class Demo {
	public Demo() {
		System.out.println("Demo bean object created by spring container");
	}
}
