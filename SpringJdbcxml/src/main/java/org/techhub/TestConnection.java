package org.techhub;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestConnection {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("conn");

        if (dataSource != null) {
            System.out.println("Database is connected");
        } else {
            System.out.println("Database is not connected");
        }
    }
}
