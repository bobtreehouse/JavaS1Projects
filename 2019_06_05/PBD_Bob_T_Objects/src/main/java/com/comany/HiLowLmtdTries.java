package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLowLmtdTries {

    public static void main(String[] args) {
//        similar to the HiLo Kata we learned 03 June 2019 //

        Random random = new Random();
        int newRandom = random.nextInt(100) + 1;

        // begin with counter

        //establish range of the game
        int highNumber = 100;
        int lowNumber = 0;

        //Here I am assigning "userNumber" to their guess
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Pick a number between 1-100 (inclusive) You have 7 tries. ");
        int userNumber = myScanner.nextInt();

        //if # tries stays below 7 keep going thru this //
        while (userNumber != newRandom && counter <= 7) {
            //will move thru user guess changes the hi / low range as we //
            // do with the counter++ piece recording # of tries.//
            if (userNumber < newRandom) {
                System.out.println("Too Low");
                lowNumber = userNumber;
                System.out.println("Pick again");

                userNumber = myScanner.nextInt();
                counter++;
            } else {
                System.out.println("Too High");
                highNumber = userNumber;
                System.out.println("Pick again");

                userNumber = myScanner.nextInt();
                counter++;
            }
        }
        //Now come OUT of loop either with a correct ; or "sorry u lose'.
        if (userNumber != newRandom) {
            System.out.println("Sorry, out of guesses. ");
            System.out.println("The correct number was " + newRandom);
        }else {
            System.out.println("CORRECT !! .  It took you " + counter + " guesses.");
            System.out.println("The number really was  " + newRandom + " !!");
        }
    }
}