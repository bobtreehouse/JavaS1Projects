package com.company;

import java.util.Scanner;



public class Exercises55 {

    public static void main(String[] args) {

        System.out.println("I will add up the numbers you give me. (enter '0' to stop)");
        System.out.println("Number: ");

        Scanner myScanner = new Scanner(System.in);
        int number1=0;
        int sum = 0;
        System.out.print("Number: ");
        number1 = myScanner.nextInt();
        sum = number1 + sum;

        while(number1!=0){
            System.out.println("The total so far is " + sum + ".");
            System.out.print("Number: ");
            number1 = myScanner.nextInt();
            sum = number1 + sum;
        }
        System.out.println();
        System.out.println("The total is "+sum+".");
    }
}