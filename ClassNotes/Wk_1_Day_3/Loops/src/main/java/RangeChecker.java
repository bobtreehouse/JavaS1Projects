package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;

        do {
            System.out.println("Please pick a number between 15 and 32: ");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);

        } while(userInt <= 15 || userInt >=32);
        System.out.println(userInput);

        /*
        so with the above we keep going back the "do" during the
        "while" is IN PLACE

         */
    }
}


/*
    Write a program that asks the user for a number between
    15 and 32 (not inclusive) and then prints that number back
    out to the screen. The program must continue to prompt the user
    until they provide a number that is in range.
     */


