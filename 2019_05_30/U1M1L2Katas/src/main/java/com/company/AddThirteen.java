package com.company;

import java.util.Scanner;

public class AddThirteen {

    //Add 13 to the value inputted by the user and print the result to the screen..

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String firstInput;

        int firstNum;


        System.out.println("Please enter a number: ");

        firstInput  = myScanner.nextLine();

        firstNum = Integer.parseInt(firstInput);

        int numPlusthirteen = firstNum +13;

        System.out.println(firstNum + " + 13 = " + numPlusthirteen + "." );
        }
    }