package com.comany;

public class ModulusAnimmation {

    public static void main( String[] args ) throws Exception
    {
        int repeats = 5;
        int steps_per_second = 10;


        /*
        Add several if statements in ModulusAnimation.java so that
        it draws a little animation of your choosing.
        You must have a minimum of eight (8) different frames
        of animation, and it must loop smoothly.
         */

        for ( int i=0; i<repeats*11 ; i++ )
        {
            if ( i%11 == 0 )
                System.out.print(" .Bob T. is cool...... \r");
            else if ( i%11 == 1 )
                System.out.print(" ..Bob T. is cool..... \r");
            else if ( i%11 == 2 )
                System.out.print(" ...Bob T. is cool.... \r");
            else if ( i%11 == 3 )
                System.out.print(" ....Bob T. is cool... \r");
            else if ( i%11 == 4 )
                System.out.print(" .....Bob T. is cool.. \r");
            else if ( i%11 == 5 )
                System.out.print(" ......Bob T. is cool. \r");
            else if ( i%11 == 6 )
                System.out.print(" .......Bob T. is cool. \r");
            else if ( i%11 == 7 )
                System.out.print(" .......Bob T. is cool.. \r");
            else if ( i%11 == 8 )
                System.out.print("......Bob T. is cool.... \r");
            else if ( i%11 == 9 )
                System.out.print(" .....Bob T. is cool.... \r");
            else if ( i%11 == 10 )
                System.out.print(" ....Bob T. is cool..... \r");
            else if ( i%11 == 11 )
                System.out.print(" ...Bob T. is cool...... \r");
            else if ( i%11 == 12 )
                System.out.print(" ..Bob T. is cool....... \r");
            else if ( i%11 == 12 )
                System.out.print(" .Bob T. is cool........ \r");
            else if ( i%11 == 12 )
                System.out.print(" Bob T. is cool......... \r");

            Thread.sleep(1000/steps_per_second);
        }

    }
}

/*
Create a new IntelliJ project called <Firsname><Lastname>U1M2L1PBD where Firstname and Lastename are your first name and last name respectively.
Implement solutions for the following exercises found at https://programmingbydoing.com/
The solution for each problem should be in its own Java file
If Statements:
26
27
28
Random Numbers:
43
44
45
While Loops:
49
53
54
 */