package org.lookupassign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
@Component("test")
public class Test {
    @Autowired
	Demo demo;
	public Test() {
		System.out.println("I am Test bean");
	}
	@Lookup
	public Demo display() {
		return null;
	}
}

 