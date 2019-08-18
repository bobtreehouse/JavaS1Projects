import java.util.*;

public class Exercises60 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("SQUARE ROOT!");

        System.out.print("Enter a number: ");
        int number=keyboard.nextInt();

        if(number<0){
            do{
                System.out.println("You can\'t take the square root of a negative number, silly.");
                System.out.print("Try again: ");
                number = keyboard.nextInt();
            }while(number<0);
        }
        double root=Math.sqrt(number);
        System.out.println("The square root of "+number+" is "+root);

    }
}
