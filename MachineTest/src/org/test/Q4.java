/*
 * Q4. Write a Java program to find all unique triplets whose sum is equal to zero. 
Explanation 
1.	Sort array.  
2.	Fix one element.  
3.	Use two pointers.  
4.	Avoid duplicate triplets. 
 
Input : [-1,0,1,2,-1,-4] 
Output : -1 -1 2  ,  -1 0 1 

 */
package org.test;
import java.util.*;
public class Q4 
{
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("enter size");
	        int n = sc.nextInt();
	        int[] a = new int[n];

	        System.out.println("enter elements");
	        for (int i=0;i<n;i++) 
	        {
	            a[i] = sc.nextInt();
	        }

	       
	        for (int i=0;i<n-1;i++) 
	        {
	            for (int j=0;j<n-i-1;j++) 
	            {
	                if (a[j]> a[j+1]) 
	                {
	                    int temp=a[j];
	                    a[j]=a[j+1];
	                    a[j+1]=temp;
	                }
	            }
	        }

	        for (int i = 0; i < n - 2; i++) 
	        {
	            int l=i+1;
	            int r=n-1;

	            while (l<r) 
	            {
	                int sum = a[i]+ a[l]+a[r];
                     if (sum == 0) 
                     {
	                    System.out.println(a[i]+" "+a[l]+" "+a[r]);
	                    if(l<r&&a[l]==a[l+1])
	                    {
	                    	l++;
	                    }
	                    if(l<r&&a[r]==a[r-1])
	                    {
	                    	r--;
	                    }
	                    l++;
	                    r--; 
	                  } 
                     else if (sum<0) 
                     {
	                    l++;
	                 } 
                     else 
                     {
	                    r--;
	                 }
	            }
	        }
	    }
	}

