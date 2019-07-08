import java.util.Scanner;


public class ValidNumber {


    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);

        {
            System.out.println("Please enter a number from 1 to 10.");
            String userInput = myScanner.nextLine();
            int userInputDigit = Integer.parseInt(userInput);

            do {
                System.out.println("You must enter a number between 1 and 10, please try again.");
                userInput = myScanner.nextLine();
                userInputDigit = Integer.parseInt(userInput);

            } while (userInputDigit < 1 || userInputDigit > 10);

            {
                System.out.println("Thank you for entering valid number: " + userInputDigit + ".");
            }
        }
    }
}


