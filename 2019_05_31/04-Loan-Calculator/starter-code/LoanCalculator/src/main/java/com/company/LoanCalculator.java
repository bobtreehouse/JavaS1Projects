package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator {

            int loanAmount, int termInYears, int interestRate) {

        // Convert interest rate into a decimal
        // eg. 6.5% = 0.065

        interestRate /= 100.0;



        int monthlyRate = interestRate / 12.0;



        int termInMonths = termInYears * 12;

        // Calculate the monthly payment


        int monthlyPayment =
                (loanAmount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        return monthlyPayment;
    }

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        // Prompt user for details of loan

        System.out.print("Enter loan amount: ");
        int loanAmount = scanner.nextInt();

        System.out.print("Enter loan term (in years): ");
        int termInYears = scanner.nextInt();

        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        // Display details of loan

        double monthlyPayment =
                calculateMonthlyPayment(loanAmount, termInYears, interestRate);




        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        NumberFormat interestFormat =
                NumberFormat.getPercentInstance();

        // Display details of the loan

        System.out.println("Loan Amount: "+
                currencyFormat.format(loanAmount));
        System.out.println("Loan Term: "+
                termInYears+" years");
        System.out.println("Interest Rate: "+
                interestFormat.format(interestRate));
        System.out.println("Monthly Payment: "+
                currencyFormat.format(monthlyPayment));

    }

}