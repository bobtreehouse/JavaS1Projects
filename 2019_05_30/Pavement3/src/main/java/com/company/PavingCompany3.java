package com.company;

import java.util.Scanner;

public class PavingCompany3 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String firstInput;
        String secondInput;
        String  cement;
        String frame;
        float firstNum;
        float secondNum;
        float cement2;
        float frame2;

        System.out.println("Please enter the width of the driveway (in feet):");
        firstInput = myScanner.nextLine();

        System.out.println("Please enter the length of the driveway (in feet)");
        secondInput = myScanner.nextLine();

        System.out.println("Please enter the cost of cement per sq foot: )");
        cement = myScanner.nextLine();

        System.out.println("Please enter the cost of framing and footers per foot: )");
        frame = myScanner.nextLine();

        firstNum = Float.parseFloat(firstInput);
        secondNum = Float.parseFloat(secondInput);
        cement2 = Float.parseFloat(cement);
        frame2 = Float.parseFloat(frame);

        // find area

        float area = firstNum * secondNum;

        System.out.printf("The area of your driveway is %.2f \n", area);

        // find perim

        float perim = (firstNum * 2) + (secondNum * 2);

//       float cement = thirdInput;
//       float framing = fourthInput;

        System.out.printf("The perimeter of your driveway is %.2f \n", perim);
        System.out.printf("The cost of cement will be %.2f \n", area * cement2);
        System.out.printf("The cost of framing will be %.2f \n", perim * frame2);
    }
}




//    Rectangular Paving Company
//        ## Requirements
//        The purpose of the program is to calculate the total cost to pave a driveway.  Here are the requirements:
//
//        1. It must prompt the user for the width of the driveway (in feet).
//        1. It must prompt the user for the length of the driveway (in feet).
//        1. It must calculate and display the area of the driveway.
//        1. It must calculate and display the perimeter of the driveway.
//        1. Based on the area and perimeter, it must calculate the total cost of the driveway:
//        - The cement for the driveway cost $12.50/square foot.
//        - The framing/footers for the driveway cost $8.25/linear foot.
//        - The program must calculate and display the subtotal cost of the cement.
//        - The program must calculate and display the subtotal cost of the framing/footers.
//
//        ### Version 2
//        Modify the program so that it does the following:
//
//        1. Prompts the user for the cost of cement
//        1. Prompts the user for the cost of the framing/footers
//        1. Displays both the cost of cement and framing/footers