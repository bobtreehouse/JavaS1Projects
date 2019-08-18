
import java.util.Random;


public class FortuneCookieWithArray {

    // try with array

    public static void main(String[] args) {
        String[] fortunes = {"fortune1", "fortune2", "fortune3" ,"fortune4" ,"fortune5" ,"fortune6"};


        Random randomNum = new Random();
        int random = randomNum.nextInt(6);

        System.out.println(fortunes[random]);
    }
}

