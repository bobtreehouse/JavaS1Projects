package com.company;

import java.util.Scanner;

public class MultiplyThree {

   //  Multiply 3 numbers inputted by the user.

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

            String firstInput;
            String secondInput;
            String thirdInput;
            int firstNum;
            int secondNum;
            int thirdNum;

            System.out.println("Please enter your first number: ");
            firstInput  = myScanner.nextLine();

            System.out.println("Please enter a second number: ");
            secondInput = myScanner.nextLine();

            System.out.println("Please enter a third number: ");
            thirdInput = myScanner.nextLine();

            firstNum = Integer.parseInt(firstInput);
            secondNum = Integer.parseInt(secondInput);
            thirdNum = Integer.parseInt(thirdInput);

            int prod = firstNum * secondNum * thirdNum;

            System.out.println(prod);
            //System.out.println(firstNum + " * " + secondNum + " * "  + thirdNum + " = " + prod + "." );
        }
    }

