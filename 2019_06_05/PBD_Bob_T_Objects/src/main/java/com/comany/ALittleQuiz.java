package com.comany;
import java.util.Scanner;

public class ALittleQuiz {

    /*
    Write an interactive quiz. It should ask the user 3 multiple-choice or t / f questions
    about something. It must keep track of how many they get wrong, and print out a
     "score" at the end.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int answer1, answer2, answer3, score = 0;

        System.out.println("Are you ready for a quiz? (y/n): ");
        scan.nextLine();


        System.out.println("Okay, here it comes!\n" +
                "\n" +
                "Q1) What is the capital of Alaska?\n" +
                "\t1) Melbourne\n" +
                "\t2) Anchorage\n" +
                "\t3) Juneau");
        answer1 = Integer.parseInt(scan.nextLine());

        System.out.println();

        if (answer1 == 3) {
            System.out.println("That's right!");
            score++;
        } else {
            System.out.println("Sorry, Juneau is the capital of Alaska.");
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?\n" +
                "\t1) yes\n" +
                "\t2) no");
        answer2 = Integer.parseInt(scan.nextLine());

        System.out.println();
        if (answer2 == 2) {
            System.out.println("That's right!");
            score++;
        } else {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?\n" +
                "\t1) 5\n" +
                "\t2) 11\n" +
                "\t3) 15/3");
        answer3 = Integer.parseInt(scan.nextLine());
        System.out.println();
        if (answer3 == 2) {
            System.out.println("That's correct!");
            score++;
        } else {
            System.out.println("Sorry, 11 is the result.");
        }
        System.out.println();
        System.out.println("Overall, you got " + score + " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }
}