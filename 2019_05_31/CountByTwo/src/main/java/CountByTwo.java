package com.company;


import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int num = reader.nextInt();

        for (int i = 0; i < num + 1; i+=2)
            System.out.println(i);

    }
}

