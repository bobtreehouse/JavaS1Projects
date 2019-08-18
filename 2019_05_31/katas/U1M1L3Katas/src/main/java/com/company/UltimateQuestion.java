package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int userPick;

        do {
            System.out.println("Pick a number between 1 and 100");
            userInput = myScanner.nextLine();
            userPick = Integer.parseInt(userInput);
        } while (userPick != 42); {
            System.out.println("That's the number I was looking for! 42 is definitely the answer!");
        }
    }
}