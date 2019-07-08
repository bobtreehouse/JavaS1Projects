import java.util.Scanner;
import java.util.*;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Let's play Fun Five Words ! Please enter your first word: ");
        String userInput1 = myScanner.nextLine();
        //int userInputDigit1 = Integer.parseInt(userInput1);

        System.out.println("Please enter your second word: ");
        String userInput2 = myScanner.nextLine();
        //int userInputDigit2 = Integer.parseInt(userInput2);

        System.out.println("Please enter your third word: ");
        String userInput3 = myScanner.nextLine();
        //int userInputDigit3 = Integer.parseInt(userInput3);

        System.out.println("Please enter your fourth word: ");
        String userInput4 = myScanner.nextLine();
        //int userInputDigit4 = Integer.parseInt(userInput4);

        System.out.println("Please enter your fifth word: ");
        String userInput5 = myScanner.nextLine();
        //int userInputDggit5 = Integer.parseInt(userInput5);


        String[] array = new String[5];
        String[] arrayWord = {userInput1, userInput2, userInput3, userInput4, userInput5};

        System.out.println("Here is your word array: ");

        System.out.println(Arrays.toString(arrayWord));


    }
}


