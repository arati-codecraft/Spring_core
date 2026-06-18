package org.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    public Student() {
        System.out.println("Student Object Created");
    }

    public void show() {
        System.out.println("Hello");
    }
}