package org.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component("e")
public class Employee {
	
	private int id;
	public Employee() {
		System.out.println("bean instantiation");
	}
	
	public int getId() {
		return id;
	}
	@Value("1")
	public void setId(int id) {
		System.out.println("I am dependency injection");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Value("ABC")
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	@Value("10000")
	public void setSal(int sal) {
		this.sal = sal;
	}
	@PostConstruct
	public void myInit() {
		System.out.println("this is the init method");
	}
	public void display() {
		 System.out.println("I am utility method");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("Iam destroy method");
	}
	private String name;
	private int sal;
	
}
