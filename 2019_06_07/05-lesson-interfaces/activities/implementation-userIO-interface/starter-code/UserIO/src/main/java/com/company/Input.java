package com.company;

import com.company.interfaces.UserIO;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Input implements UserIO {

  Scanner scan = new Scanner(System.in);

  // read int //
    public int readInt(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        int input = Integer.parseInt(userInput);

        return input;

    }
    // read Long //
    public long readLong(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        long input = Long.parseLong(userInput);

        return input;

    }// read Double //

    public double readDouble(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        double input = Double.parseDouble(userInput);

        return input;

    }
    // read Float //
    public float readFloat(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        float input = Float.parseFloat(userInput);

        return input;

    }
    // read String //
    public String readString(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        String input = (userInput);

        return input;

    }









    }


        /*
        This interface defines the following methods:

    readInt, which displays a prompt and then reads an int from the user
    readLong, which displays a prompt reading a long from the user
    readDouble, which displays a prompt reading a double from the user
    readFloat, which displays a prompt reading a float from the user
    readString, which displays a prompt reading a string from the user

         */


