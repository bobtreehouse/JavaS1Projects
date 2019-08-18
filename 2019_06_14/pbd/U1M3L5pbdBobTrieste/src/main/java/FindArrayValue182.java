import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindArrayValue182 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int random = new Random().nextInt();

        ArrayList<Integer> basicList = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            random = new Random().nextInt(50) + 10;
            basicList.add(random);

        }

        System.out.println(basicList);

        System.out.println("Value to find: ");

        int userGuess = s.nextInt();

        for (int i = 0; i < basicList.size(); i++)

            if (basicList.contains(userGuess)) {


                System.out.println(userGuess + " is in the list!");

            } else {
                System.out.println(userGuess + " is not in the list.");

            }
    }
}

