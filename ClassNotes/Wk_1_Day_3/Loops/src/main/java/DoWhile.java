
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;

        do {
            System.out.println("Please enter 1 to 10.");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);

        } while(userInt < 1 || userInt > 10);

        /*
        so with the above we keep going back the "do" during the
        "while" is IN PLACE

         */
    }
}
