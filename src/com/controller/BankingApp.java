package com.controller;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankServiceController bankServiceController = new BankServiceController();
        CustomerController customerController = new CustomerController();
        Scanner sc=new Scanner(System.in);
        System.out.println("****ABC BANK****");
        System.out.println("Enter 1 for Bank service provider");
        System.out.println("Enter 2 for customer service provider");
        System.out.println("Enter 0 to exit the app");
        int input=sc.nextInt();
        if(input==0)
        {
        	System.out.println("Thank you");
        }
      
        switch(input)
        {
        case 1:
        System.out.println("Running BankServiceController:");
        bankServiceController.main(args);
        break;
        
        case 2:
        System.out.println("Running CustomerController:");
        customerController.main(args);
        break;
        }
    }
}

