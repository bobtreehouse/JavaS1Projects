package com.company;


import java.util.Scanner;


public class ConverterApplication {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ConvertIf ifChoice = new ConvertIf();
        ConverterSwitch switchChoice = new ConverterSwitch();

        System.out.println("Enter 1 to 12 for month:");
        String userInput = scan.nextLine();
        int userInputMonth = Integer.parseInt(userInput);

        System.out.println("Enter 1 to 7 for day:");
        String userInput2 = scan.nextLine();
        int userInputDay = Integer.parseInt(userInput);


        System.out.println("Month via If/Else = " +ifChoice.convertMonth(userInputMonth) + "\n");
        System.out.println("Month via Switch = " +switchChoice.convertDay(userInputDay) + "\n");
        System.out.println("Day via If/Else = " +ifChoice.convertDay(userInputDay) + "\n");
        System.out.println("Day via Switch = " +switchChoice.convertDay(userInputDay) + "\n");

    }
}

























