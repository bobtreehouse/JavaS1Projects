package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter your age: ");
        firstInput = reader.nextLine();

        int num = reader.nextInt();
        int age = 37;

        if (age >= 35) {

            // execute code if conditions
            // is true

            System.out.println("You are eligible to vote and run for president.");

        } else  if (age <35 && age >= 18) {

            // execute code if condition is false

            System.out.println("Eligible to vote but not run for President.");

        } else {
            System.out.println("Not Eligible");

        }
    }

}