package org.model;

public class Employee {

    private int id;
    private String name;
    private int sal;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSal(int sal)
    {
    	this.sal=sal;
    }
    public void show() {

        System.out.println(id + " " + name+" " +sal);
    }
}