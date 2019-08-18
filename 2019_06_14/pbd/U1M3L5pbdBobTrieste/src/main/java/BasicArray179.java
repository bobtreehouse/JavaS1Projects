import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BasicArray179<basicList> {

    public static int getNumbers() {
        Random r = new Random();
        int x = 1 + r.nextInt(100);
        return x;
    }

    public static void main(String[] args) {


    ArrayList<Integer> basicList = new ArrayList<Integer>();
	for(int i=1; i<=10; i++){
        basicList.add(getNumbers());

    }System.out.println("ArrayList: "+basicList);


    }

}


/*
Create an ArrayList of Integers.

Fill up the list with ten random numbers,
each from 1 to 100. Then display the contents
 */