import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);

        System.out.println("Together we will build an Array. Please enter your first number: ");
        String userInput1 = myScanner.nextLine();
        int userInputDigit1 = Integer.parseInt(userInput1);

        System.out.println("Please enter your second number: ");
        String userInput2 = myScanner.nextLine();
        int userInputDigit2 = Integer.parseInt(userInput2);

        System.out.println("Please enter your third number: ");
        String userInput3 = myScanner.nextLine();
        int userInputDigit3 = Integer.parseInt(userInput3);

        System.out.println("Please enter your fourth number: ");
        String userInput4 = myScanner.nextLine();
        int userInputDigit4 = Integer.parseInt(userInput4);

        System.out.println("Please enter your fifth number: ");
        String userInput5 = myScanner.nextLine();
        int userInputDggit5 = Integer.parseInt(userInput5);


        int[] array = {userInputDigit1, userInputDigit2, userInputDigit3, userInputDigit4, userInputDggit5};

        System.out.println("Here is your array: ");

        for (int element : array) {

            System.out.println(element);


        }
    }
}

