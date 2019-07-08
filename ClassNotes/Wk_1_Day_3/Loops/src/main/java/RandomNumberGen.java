import java.util.Random;

public class RandomNumberGen {

    public static void main(String[] args) {
        // simulate roll of single die
        Random random = new Random();
        for ( int i = 0; i < 10; i++);

        // so the above for loop uses "i" but we are Not printing that out
        // "i" here is JUST a COUNTER !!
        //WHAT we are printing is in below "RollVALUE"

        int rollValue = random.nextInt(5) + 1;
        System.out.println(rollValue);
    }
}
