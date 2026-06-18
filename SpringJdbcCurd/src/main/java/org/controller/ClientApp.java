package org.controller;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {
	
	    public static void main(String[] args) {
	        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	        EmployeeService service = context.getBean(EmployeeService.class);

	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Employee ID:");
	        int id = sc.nextInt();
	        sc.nextLine(); // consume newline

	        System.out.println("Enter Employee Name:");
	        String name = sc.nextLine();

	        System.out.println("Enter Employee Salary:");
	        double salary = sc.nextDouble();

	        Employee emp = new Employee(id, name, salary);
	        service.addEmployee(emp);

	        System.out.println("Employee Added Successfully!");

	        // Show all employees
	        service.getEmployees().forEach(e -> 
	            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary())
	        );

	        context.close();
	        sc.close();
	    }
	}

