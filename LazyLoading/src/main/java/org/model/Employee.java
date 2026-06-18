package org.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("e")
@Lazy
public class Employee implements InitializingBean,DisposableBean{
	
	private int id;
	public Employee() {
		System.out.println("Employee bean object created by spring container ");
	}
	
	public int getId() {
		return id;
	}
	@Value("1")
	public void setId(int id) {
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
	 
	public void display() {
		System.out.println("I am utility method");
	}
	private String name;
	private int sal;
	public void afterPropertiesSet() throws Exception {
	}

	public void destroy() throws Exception {
	   System.out.println("I am destroy method");	
	} 
}
