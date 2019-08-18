import java.util.Scanner;

import java.util.Random;

public class NumberGUessWithCounter {

    public static void main( String[] args ) {

        Scanner keyboard = new Scanner(System.in);

        Random r = new Random();

        int guess, number, counter;
        number = 1 + r.nextInt(10);

        System.out.println( "I have chosen a number between 1 and 10. Try to guess it." );
        System.out.print( "Your guess: \n" );
        guess = keyboard.nextInt();

        counter = 1;

        while ( guess != number ) {
            System.out.println( "That is incorrect. Guess again." );
            System.out.print( "Your guess: \n" );
            guess = keyboard.nextInt();
            counter++;
        }

        System.out.println( "That's right! You're a good guesser." );
        System.out.println( "It took you " + counter + " guesses." );

    }
}