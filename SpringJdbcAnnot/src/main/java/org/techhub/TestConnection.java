package org.techhub;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestConnection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        if (dataSource != null) {
            System.out.println("Database bean is created successfully!");
        } else {
            System.out.println("Database bean is not created.");
        }
    }
}
