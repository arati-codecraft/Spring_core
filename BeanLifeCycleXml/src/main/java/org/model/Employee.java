package org.model;

public class Employee {
       private	int id;
	    private String name;
	    private int sal;
	    
	    public void myinit()
	    {
	    	System.out.println("this is init method");
	    }
	    public void display() {
			 System.out.println("I am utility method");
		}

	    public void mydestroy()
	    {
	    	System.out.println("i am destroy method");
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
	    
	    

}
