package org.lookupassign;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("demo")
@Scope("prototype")
public class Demo {
	public Demo() {
		System.out.println("I am demo bean");
	}
}
