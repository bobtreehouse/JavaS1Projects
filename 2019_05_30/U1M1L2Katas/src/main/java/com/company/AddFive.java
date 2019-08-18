package com.company;

import java.util.Scanner;

public class AddFive {

    // Add 5 numbers inputted by the user.
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;
        String secondInput;
        String thirdInput;
        String fourthInput;
        String fifthInput;
        int firstNum;
        int secondNum;
        int thirdNum;
        int fourthNum;
        int fifthNum;

        System.out.println("enter a number:");
        firstInput  = myScanner.nextLine();

        System.out.println("enter a second number:");
        secondInput = myScanner.nextLine();

        System.out.println("enter a third number:");
        thirdInput = myScanner.nextLine();

        System.out.println("enter a third number:");
        fourthInput = myScanner.nextLine();

        System.out.println("enter a fifth number:");
        fifthInput = myScanner.nextLine();

        firstNum = Integer.parseInt(firstInput);
        secondNum = Integer.parseInt(secondInput);
        thirdNum = Integer.parseInt(thirdInput);
        fourthNum = Integer.parseInt(fourthInput);
        fifthNum = Integer.parseInt(fifthInput);

        int sum = firstNum + secondNum + thirdNum + fourthNum + fifthNum;

        System.out.println(sum);
    }
}


