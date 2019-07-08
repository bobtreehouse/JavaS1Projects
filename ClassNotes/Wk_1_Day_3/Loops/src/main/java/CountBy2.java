
import java.util.Scanner;

// now count by 2

public class CountBy2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What number would you like to count to?");
        String userInput = myScanner.nextLine();
        int userNum = Integer.parseInt(userInput);

        // change below from i++ (count by 1's; to i+2 to count by 2's
        for(int i = 2; i <= userNum; i += 2) {
            System.out.println(i);

        }

    }
}
