package com.company;

import java.util.Scanner;

public class SubtractTwo {

    //Subtract the second number from the first number inputted by the user.

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;
        String secondInput;
        int firstNum;
        int secondNum;

        System.out.println("enter your first number:");
        firstInput  = myScanner.nextLine();
        System.out.println("enter your second number");
        secondInput = myScanner.nextLine();

        firstNum = Integer.parseInt(firstInput);
        secondNum = Integer.parseInt(secondInput);

        int sub = firstNum - secondNum;

        System.out.println(sub);
        //System.out.println(firstNum + " - " + secondNum + " = " + sub + "." );
    }
}
