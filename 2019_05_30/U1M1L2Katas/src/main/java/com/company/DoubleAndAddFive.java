package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    //Double the number inputted by the user and then add 5. Print the result to the screen..

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;

        int firstNum;


        System.out.println("Please enter a number: ");

        firstInput  = myScanner.nextLine();

        firstNum = Integer.parseInt(firstInput);

        int addDoubleThenAdd5 = (firstNum * 2)+5;

        System.out.println("(" + firstNum + " * 2) + 5 = " + addDoubleThenAdd5 + "." );
    }
}