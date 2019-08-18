package com.company;

import java.util.Scanner;

public class Registration2 {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Hi, what is your first name please? ");
        String nameFirst = myScanner.nextLine();

        System.out.println("What is your last name please? ");
        String nameLast = myScanner.nextLine();

        System.out.println("Please enter your E-mail: ");
        String emailMain = myScanner.nextLine();

        System.out.println("Please enter your Twitter handle: ");
        String twitterMain = myScanner.nextLine();

        System.out.println("Please enter your age: ");
        String age = myScanner.nextLine();

        System.out.println("Please enter your country: ");
        String country = myScanner.nextLine();

        System.out.println("Profession? ");
        String jobMain = myScanner.nextLine();

        System.out.println("Favorite OS? ");
        String oxFav = myScanner.nextLine();

        System.out.println("Who is your favorite computer scientist? ");
        String sciComp = myScanner.nextLine();

        System.out.println("Please enter your Favorite keyboard shortcut: (inside quotation marks please)");
        String keyShortcut = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String compBuild = myScanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String superHero = myScanner.nextLine();


        System.out.println("Hi there " + nameFirst + nameLast + "!\n");
        System.out.println("Great to meet you and I look forward to following " + twitterMain + ".\n");
        System.out.println("I will send you an invite to " + emailMain + " to tell you about a \n");
        System.out.println("great event I am hosting to discuss " + country + "and also " + sciComp +"!\n");
        System.out.println("Did you know he also liked " + superHero + "has been known to use " + keyShortcut + " as well !!\n");


    }
}
//# Registration Form
//        ## Requirements
//        The purpose of this program is to prompt the user for registration information for a new social media service called CommandLineGram.
//
//        The program must prompt the user for the following information and then display it, nicely formatted, back to the user after all the information has been collected:
//
//        1. First name
//        1. Last name
//        1. Email
//        1. Twitter handle
//        1. Age
//        1. Country
//        1. Profession
//        1. Favorite operating system
//        1. Favorite programming language
//        1.	Favorite computer scientist
//        1.	Favorite keyboard shortcut
//        1.	Have you ever built your own computer?
//        1.	If you could be any superhero, who would it be?
