package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    //Add 5 to the number inputted by the user and then double it. Print the result to the screen.

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;

        int firstNum;


        System.out.println("Please enter a number: ");

        firstInput  = myScanner.nextLine();

        firstNum = Integer.parseInt(firstInput);

        int addFiveDouble = (firstNum + 5)*2;

        System.out.println("(" + firstNum + " + 5) * 2 = " + addFiveDouble + "." );
    }
}
