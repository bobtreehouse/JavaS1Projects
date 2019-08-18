package com.company;


import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int num = reader.nextInt();

        for (int i = 0; i < num + 1; i++)
            System.out.println(i);

    }
}

