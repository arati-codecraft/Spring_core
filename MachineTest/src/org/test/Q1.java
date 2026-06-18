/*
 * Q1. Write a Java program to: 
1.	Check whether a given number is a Kaprekar number or not.  
2.	Display all Kaprekar numbers up to n.  
A Kaprekar number is a non-negative integer whose square can be split into two parts that add up to the original number. 
Example 
45² = 2025 
20 + 25 = 45 
So, 45 is a Kaprekar number. 
Input : Enter limit: 50 
Output : Kaprekar Numbers: 1 9 45 

 */
package org.test;

import java.util.*;

public class Q1 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit: ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++) 
        {
            int sq=i*i;
            int temp=i;
            int digit=0;
            while (temp>0) 
            {
                digit++;
                temp = temp / 10;
            }
            int pow=1;
            for (int j=1;j<=digit;j++) 
            {
                pow=pow*10;
            }

            int r=sq%pow;
            int l=sq/pow;

            if (l+r==i) 
            {
                System.out.print(i + " ");
            }
        }
    }
}
