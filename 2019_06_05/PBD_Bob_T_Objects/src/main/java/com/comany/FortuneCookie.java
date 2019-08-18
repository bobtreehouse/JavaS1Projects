package com.comany;
import java.util.Random;
import java.util.Scanner;

public class FortuneCookie {

    /*
    Write a program that simulates a random fortune from a fortune cookie. You must have at least six fortunes.

For bonus points, also add randomly-chosen lotto numbers to the fortune. In Texas, the lotto chooses 6 numbers, each from 1-54.
     */


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Press Enter for your Fortune.");
        scan.nextLine();

        System.out.println("Fortune cookie says: ");

        Random random = new Random();
        int newRandom = random.nextInt(6) + 1;

        if (newRandom == 1) {
            System.out.println("You will find happiness with a new programming language.");
        } else if (newRandom == 2) {
            System.out.println("You should always stick with mass transit !! ");
        } else if (newRandom == 3) {
            System.out.println("Don't drink a milkshake before skydiving.");
        } else if (newRandom == 4) {
            System.out.println("Programmers should go to bed by 11pm.");
        } else if (newRandom == 5) {
            System.out.println("You should review arrays and loops.");
        } else if (newRandom == 6) {
            System.out.println("Your life is stuck in a never-ending whileLoop!");
        }
    }
}