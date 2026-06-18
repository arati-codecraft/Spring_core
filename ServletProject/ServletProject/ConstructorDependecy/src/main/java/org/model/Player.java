package org.model;

public class Player {
	private int id;
	private String name;
	private int run;

	public Player() {
		System.out.println("I am default constructor");
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public String toString() {
		return id + " " + name + " " + run;
	}

}
