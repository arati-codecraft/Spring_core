package org.model;
import java.util.*;

public class Employee {
	 private List<String> names;
		public void setNames(List<String> names)
		{
			 this.names=names;
		}
		public void showList() {
			for(String n:names) {
				System.out.println(n);
			}
		}

}
