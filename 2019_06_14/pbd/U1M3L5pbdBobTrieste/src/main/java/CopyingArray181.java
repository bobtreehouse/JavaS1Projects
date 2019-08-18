import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class CopyingArray181 {

    public static void main(String[] args) {

        int random  = new Random().nextInt();

        ArrayList<Integer> basicList = new ArrayList<Integer>();
        ArrayList<Integer> basicList2 = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            random = new Random().nextInt(90) + 10;
            basicList.add(random);
        }
        for(int i=0; i<basicList.size(); i++) {
            basicList2.add(basicList.get(i));
        }
            basicList.remove(basicList.size()-1);
            basicList.add(-7);

            System.out.println( basicList);
            System.out.println( basicList2);
        }


    }
