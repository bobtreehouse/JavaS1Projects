package com.company;

import java.util.Scanner;
import java.util.Random;

public class HowManyTimesTo7 {

    public static void main(String[] args) {

        Random random = new Random();
        int random2 = random.nextInt(100) + 1;
        int lucky = 7;
        int numberOfTurns = 0;

        do  {

            numberOfTurns++;

            // "int i is the counter

            System.out.println("The computer will roll a virtual die 100 times to try for a 7. ");


            // System.out.println(rollValue);

            if (lucky == random2) {

                //System.out.println("Congratulations, " + name1 + "!" + "You win!");
                System.out.println("It took " + numberOfTurns + " to roll a 7.");
                // execute code if conditions
                // is true

//            } else if (guess < random2) {
//                System.out.println("You number is too low, try again: ");
//
//            } else if (guess > random2) {
//                System.out.println("You number is too high, try again: ");
            }
            // execute code if condition is false
        } while ( lucky != random2 );

    }
}
/*
# How Many Times to 7?

## Requirements
"roll" a pair of virtual dice (use the random number generator)
100 times and keep track of the following:
    -	How many rolls it took to roll the first 7
    -	The total number of 7s rolled out of the 100 rolls
This information must be displayed to the user after it has been calculated.

## Bonus

1.	Prompt the user for the number of times to roll the dice.
1.	Keep track of and display this information for all numbers that can be rolled (2–12).

---
 */