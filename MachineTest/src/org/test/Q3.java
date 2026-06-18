/*
 * Q3. Write a Java program to count Perfect numbers in an array. 
A Perfect number is equal to sum of its proper divisors. 
Example: 6 = 1 + 2 + 3 
Input :- arr = [6, 28, 10, 12, 496] 
Output :- Count of Perfect numbers = 3 

 */
package org.test;
import java.util.*;

public class Q3 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter size of array");
        int s = sc.nextInt();

        int arr[] = new int[s];
        System.out.println("enter elements");
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        int c = 0; 

        for (int n=0;n<s;n++) {
            int num = arr[n];   
            int sum = 0;

            
            for (int i=1;i<=num/2;i++) 
            {
                if (num%i==0) 
                {
                    sum +=i;
                }
            }
            if (sum == num) 
            {
                c++;
            }
        }

        System.out.println("Count of Perfect numbers = " + c);
    }
}
