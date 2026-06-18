/*
 * Q7. Write a Java program to Create deposit and withdrawal threads using synchronization. 
Explanation 
•	One thread deposits money.  
•	Another withdraws money.  
•	Synchronization avoids data inconsistency. 
•	Initial Balance = 1000 
Output :- Deposited: 500 
                  Withdrawn: 1200 
                  Remaining Balance: 300 

 */
package org.test;
import java.util.*;

class Bank
{
    int balance = 1000;

    synchronized void deposit(int amt)
    {
        balance += amt;
        System.out.println("Deposit:" + amt);
    }

    synchronized void withdraw(int amt)
    {
        if (amt<=balance)
        {
            balance -= amt;
            System.out.println("Withdraw: " + amt);
        } 
        else 
        {
            System.out.println("insufficient balance " + amt);
        }
    }
}

class DepositThread implements Runnable 
{
    Bank bank;
    int amount;

    DepositThread(Bank bank, int amount) 
    {
        this.bank = bank;
        this.amount = amount;
    }

    public void run() 
    {
        bank.deposit(amount);
    }
}

class WithdrawThread implements Runnable 
{
    Bank bank;
    int amount;

    WithdrawThread(Bank bank, int amount)
    {
        this.bank = bank;
        this.amount = amount;
    }

    public void run() 
    {
        bank.withdraw(amount);
    }
}

public class Q7
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        System.out.print("enter deposit amount");
        int d = sc.nextInt();

        System.out.print("enter withdraw amount");
        int w = sc.nextInt();

        Thread t1 = new Thread(new DepositThread(b, d));
        Thread t2 = new Thread(new WithdrawThread(b, w));

        t1.start();
        try { 
        	   t1.join(); 
        	} 
        catch(Exception e) 
        {
        	System.out.println("error is "+e);
        }

        t2.start();
        try { 
        	  t2.join(); 
            } 
        catch(Exception e) 
        {
        	System.out.println("error is "+e);
        }

        System.out.println("remaining balance: " + b.balance);
    }
}
