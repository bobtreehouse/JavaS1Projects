package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
//        similar to the HiLo Kata we learned 03 June 2019 //

        Random random = new Random();
        int newRandom = random.nextInt(10) + 1;

        Scanner scan = new Scanner(System.in);
        System.out.println("I'm thinking of a number from 1 to 10.\n" +
                "Your guess: ");
        int guess = Integer.parseInt(scan.nextLine());

    if (guess != newRandom) {

        System.out.println("Sorry, but I was really thinking of " + newRandom);
    }else {
        System.out.println("That's right!  My secret number was " + guess + "!");
    }
}
}