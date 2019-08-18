package com.company;

import java.util.Scanner;

public class LuxuryTaxCalc {

    /*Calc Lux Tax IF over $40M payroll;
    enter the salary for Player 1 (without the dollar sign or commas).
    enter the salary for Player 2 (without the dollar sign or commas).
    enter the salary for Player 3 (without the dollar sign or commas).
    Calculate and display the total salary for all three players.
    IF team went over; calculate and display the cost of the luxury tax.
    team's spending limit is $40,000,000.
    tax rate is 18%
     */

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;
        String secondInput;
        String thirdInput;
        float firstSalary;
        float secondSalary;
        float thirdSalary;

        System.out.println("Enter the salary for Player 1 (without the dollar sign or commas).");
        firstInput = myScanner.nextLine();
        System.out.println("Enter the salary for Player 2 (without the dollar sign or commas).");
        secondInput = myScanner.nextLine();
        System.out.println("Enter the salary for Player 3 (without the dollar sign or commas).");
        thirdInput = myScanner.nextLine();
        firstSalary = Float.parseFloat(firstInput);
        secondSalary = Float.parseFloat(secondInput);
        thirdSalary = Float.parseFloat(thirdInput);

        float totalSalary = firstSalary + secondSalary + thirdSalary;
        if (totalSalary <= 40000000) {
            System.out.println("There is no luxury tax due.");
        } else {
            float tax = (totalSalary * 0.18f);
            System.out.printf("The luxury tax is: %.2f ", tax);
        }
    }
}

