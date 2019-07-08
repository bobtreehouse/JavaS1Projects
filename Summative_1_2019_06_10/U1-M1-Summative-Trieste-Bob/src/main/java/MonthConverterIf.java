import java.util.Scanner;


public class MonthConverterIf {


    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 12 for the month: ");
        String userInput = myScanner.nextLine();
        int userInputDigit = Integer.parseInt(userInput);

        if (userInputDigit == 1) {
            System.out.println("January");
        } else if (userInputDigit == 2) {
            System.out.println("February");
        } else if (userInputDigit == 3) {
            System.out.println("March");
        } else if (userInputDigit == 4) {
            System.out.println("April");
        } else if (userInputDigit == 5) {
            System.out.println("May");
        } else if (userInputDigit == 6) {
            System.out.println("June");
        } else if (userInputDigit == 7) {
            System.out.println("July");
        }else if (userInputDigit == 8) {
            System.out.println("August");
        }else if (userInputDigit == 9) {
            System.out.println("September");
        }else if (userInputDigit == 10) {
            System.out.println("October");
        }else if (userInputDigit == 11) {
            System.out.println("November");
        }else if (userInputDigit == 12) {
            System.out.println("December");
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }

    }
}
