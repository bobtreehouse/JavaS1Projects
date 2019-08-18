import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayWhereIsIt184 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Integer> intArrList = new ArrayList<>();

        int random = new Random().nextInt();

        for(int i = 0; intArrList.size() < 10; i ++){
            random = new Random().nextInt(50-1)+1;
            intArrList.add(random);
        }
        System.out.println(intArrList);

        System.out.println("Value to find: ");
        int userGuess = s.nextInt();

        boolean isInList = false;
        int position = 0;

        for(int i = 0; i < intArrList.size(); i ++){
            if(userGuess == intArrList.get(i)){
                isInList = true;
                position = i;
            }
        }

        if(isInList == true) {
            System.out.println(userGuess + " is in the list!");
            System.out.println("Position is " + position);
        }else {
            System.out.println(userGuess + " is not in the list.");
        }

    }
}