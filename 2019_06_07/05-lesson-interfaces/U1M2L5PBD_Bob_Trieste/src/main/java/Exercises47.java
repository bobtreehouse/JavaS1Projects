package com.company;

import java.util.Scanner;
import java.util.Random;

public class Exercises47 {

    public static void main(String[] args) {

        Random random = new Random();
        int newRandom = random.nextInt(3) +1 ;
        int ace = newRandom;

        // int answer1, answer2, answer3, score = 0;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n" +
                "\n" +
                "Which one is the ace?\n" +
                "\n" +
                "\t##  ##  ##\n" +
                "\t##  ##  ##\n" +
                "\t1   2   3\n" +
                "> ");
        Scanner scan = new Scanner(System.in);
        int guess = Integer.parseInt(scan.nextLine());

//        if newRandom = (1) {
//            System.out.println("\n"+
//                            "\tAA  ##  ##\n"+
//                            "\tAA  ##  ##\n"+
//                            "\t1   2   3\n"
//                    "> ");

        if (guess != newRandom) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + newRandom);
//                    "\n"+
//                    "\t##  ##  AA\n"+
//                    "\t##  ##  AA\n"+
//                    "\t1   2   3");
        } else {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling. The ace was card number " + guess + "!");
        }

        if (ace == 1) {
            System.out.println("\n" +
                    "AA ## ##\n" +
                    "AA ## ##\n" +
                    "1   2   3");
        } else if (ace == 2) {

            System.out.println("\n" +
                    "## AA ##\n" +
                    "## AA ##\n" +
                    "1   2  3");

        } else if (ace == 3) {
                System.out.println("\n" +
                        "## ## AA\n" +
                        "## ## AA\n" +
                        "1   2  3");
            }
        }
    }





