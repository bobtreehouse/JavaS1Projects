

package com.company;

import java.util.Random;

public class Exercise58 {

    public static void main(String[] args) {
        System.out.println("HERE COMES THE DICE!");

        System.out.println();
        Random random = new Random();
        int roll1 = 0;
        int roll2 = 0;
        roll1 = 1 + random.nextInt(6);
        roll2 = 1 + random.nextInt(6);

        do {
            System.out.println("Roll #1: " + roll1);
            System.out.println("Roll #2: " + roll2);
            int sum = roll1 + roll2;


            System.out.println();
            System.out.println("Roll #1: " + roll1);
            System.out.println("Roll #2: " + roll2);
            System.out.println("The total is " + (roll1 + roll2) + "!");
        } while (roll1 != roll2);
    }
}

