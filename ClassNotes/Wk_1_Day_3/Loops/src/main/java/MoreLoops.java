
import java.util.Scanner;

public class MoreLoops {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Would you like to inout a word to display? (y/n");
        String userInput = myScanner.nextLine();

        while (userInput.equals("y")) {
            System.out.println("Type in word to display");
            String word = myScanner.nextLine();
            System.out.println(word);
            System.out.println("Would you like to do another? (y/n)");
            userInput = myScanner.nextLine();
        }
    }
}
