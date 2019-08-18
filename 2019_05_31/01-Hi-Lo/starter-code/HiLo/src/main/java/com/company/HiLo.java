package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {

    public static void main(String[] args) {
        System.out.println("Welcome to Hi-Low!");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name1 = myScanner.nextLine();

        System.out.println("OK, " + name1 + ", here are the rules: ");
        System.out.println("The computer will come up with a number between 1 and 100 (inclusive).\n" +
                "\tYou will try to guess the number.\n");


        // generate # from 1 to 100
        Random random = new Random();
        int random2 = random.nextInt(100) + 1;
        int guess;
        int numberOfTurns = 0;

        do  {

            numberOfTurns++;

        // "int i is the counter

        System.out.println("Guess the number (1-100): ");
        guess = Integer.parseInt(myScanner.nextLine());

        // System.out.println(rollValue);

        if (guess == random2) {

            System.out.println("Congratulations, " + name1 + "!" + "You win!");
            System.out.println("It took you " + numberOfTurns + " turns to get it right!");
                    // execute code if conditions
                    // is true

        } else if (guess < random2) {
            System.out.println("You number is too low, try again: ");

        } else if (guess > random2) {
            System.out.println("You number is too high, try again: ");
        }
            // execute code if condition is false
        } while ( guess != random2 );

    }
}

//

/*
Hi-Lo
The purpose of this assessment is to create a program that is a number guessing game.

## Structure

- Complete the below requirements in the `HiLo` project found in the `starter-code` directory.
- All code must be contained within the `main` method of the `HiLo` class.
- The requirements must be implemented in the order found below.
- Once your code has been written, it can be tested using `HiLoTest`.

## Requirements

1.	The program displays a message that says, “Welcome to Hi-Low!”
1.	The program prompts for the user’s name.
1.	The program displays a message that says, “OK, <name of user>, here are the rules:”
1.	The program then displays the rules of the game, which are:
    1.	The computer will come up with a number between 1 and 100 (inclusive).
    1.	The user will be prompted to guess the number.
    1.	If the user guesses the number correctly, the program displays:
        1.	“Congratulations, [name of user]! You win!”
        1. "It took you [number of guesses] guesses to find my number!"
    1. If the user does not guess the number correctly, the program will display
    “Too low!” if the guess is too low and “Too high!” if the guess is too high, and
    then will prompt the user for another guess.  This goes on until the number is
    guessed correctly.
 */