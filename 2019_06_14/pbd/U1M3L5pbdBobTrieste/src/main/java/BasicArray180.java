import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BasicArray180 {

    public static void main(String[] args) {

    int random  = new Random().nextInt();


        ArrayList<Integer> basicList = new ArrayList<Integer>();
        for (int i = 1; i <= 1000; i++) {
            random = new Random().nextInt(90) + 10;
            basicList.add(random);
        }
            for(int i=0; i<basicList.size(); i++){

            System.out.println("Number " + (i+1) + "=" + basicList.get(i));
        }
    }
}






