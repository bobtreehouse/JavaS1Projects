package com.company;

import java.util.Scanner;

public class AverageThree {

     public static void main(String[] args) {
            String[] results = {"10.00", "29.33", "1.00"};
            //String[] args = null;

            Scanner myScanner = new Scanner(System.in);

            String firstInput;
            String secondInput;
            String thirdInput;
            float firstNum;
            float secondNum;
            float thirdNum;

            System.out.println("enter a number:");
            firstInput  = myScanner.nextLine();
            System.out.println("enter a second number");
            secondInput = myScanner.nextLine();
            System.out.println("enter a third number");
            thirdInput = myScanner.nextLine();

            firstNum = Float.parseFloat(firstInput);
            secondNum = Float.parseFloat(secondInput);
            thirdNum = Float.parseFloat(thirdInput);

            float sum = firstNum + secondNum + thirdNum;
            float avg = sum  / 3;

            //System.out.printf("%.2f", avg);
            //System.out.println("The average of your three numbers is %.2f" + avg + ".");
            System.out.printf("The average of your three numbers is %.2f", avg);
            //System.out.printf("%.2f", "" + avg);*/

            //System.out.println("The average of your three numbers is " + String.format(java.util.Locale.US,"%.2f", avg));
        }
}

