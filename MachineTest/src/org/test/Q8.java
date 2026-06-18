/*
 * Q8. Write a Java program to Find longest continuous increasing subsequence. 
Input :- 10 20 15 16 17 5 6 7 8 
Output :- Longest increasing sequence length: 4 
                  Sequence: 5 6 7 8 
  

 */
package org.test;
import java.util.*;
public class Q8 
{ 
	public static void main(String[] args) 
	{
	   Scanner sc = new Scanner(System.in);
	   System.out.println("enter the size");
	   int n = sc.nextInt();
	   System.out.println("Enter the elements:");
	   int a[] = new int[n];
	    for (int i=0;i<n;i++)
	    {
	        a[i] = sc.nextInt();
        }
        int max=1;
        int len=1;
        int end=0;
	    for(int i=1;i<n;i++)
	    {
	        if(a[i]>a[i-1])
	        {
	        	len++;
	        }
	        else
	         {
	            len = 1;
	         }
	         if (len>max) 
	         {
	            max=len;
	            end=i;
	         }
	     }

	    System.out.println("Longest increasing sequence length: " + max);
	  
	    for (int i=end-max+1;i<=end;i++)
	    {
	       System.out.print(a[i] + " ");
	     }
	       
	}
	   

   }

