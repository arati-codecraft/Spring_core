/*
 * Q2. Write a Java program using recursion to display series: 
2 6 12 20 30 42 56 72 90 110 

 */
package org.test;
import java.util.*;

public class Q2 
{
	 static void Series(int n, int i)
	 {
	        if (i>n) 
	        {
	            return; 
	        }

	        int term = i*(i+1); 
	        System.out.print(term + " ");

	        Series(n, i+1); 
	    }

	    public static void main(String[] args)
	    {     Scanner sc=new Scanner (System.in);
	          System.out.println("enter the number ");
	          int n=sc.nextInt();
	          System.out.println("series:");
	        Series(n, 1);
	    }
}


