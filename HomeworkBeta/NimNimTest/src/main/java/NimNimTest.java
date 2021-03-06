import java.util.*;
public class NimNimTest {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int pileA = 3;
        int pileB = 3;
        int pileC = 3;
        int turns = 0;
        int removal = 0;

        String name1;
        String name2;
        String currentPlayer = "";

        //inputs
        System.out.print("Player 1, enter your name: ");
        name1 = keyboard.nextLine();
        System.out.print("Player 2, enter your name: ");
        name2 = keyboard.nextLine();

        //game progress while not zero;

        while (pileA > 0 || pileB > 0 || pileC > 0) {
            if (turns % 2 == 0) {
                currentPlayer = name1;
            } else if (turns % 2 > 0) {
                currentPlayer = name2;
            }
            System.out.println("A:" + pileA + "     " + "B:" + pileB + "     " + "C" + pileC);
            for (int i = 0; i < pileA; i++) {
//
//            }
//            System.out.println("A:" + pileA + "     " + "B:" + pileB + "     " + "C" + pileC);
//            for (int i = 0; i < pileB; i++) {
//
//            }
//            System.out.println("A:" + pileA + "     " + "B:" + pileB + "     " + "C" + pileC);
//            for (int i = 0; i < pileC; i++) {
//                //System.out.print("*");
            }


            System.out.print("\n" + currentPlayer + " Choose a pile: ");

            String userPick = keyboard.nextLine();

            // pick from non-zero pile;
            while (userPick.equals("A") && pileA <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again: ");
                userPick = keyboard.nextLine();
            }
            while (userPick.equals("B") && pileB <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again: ");
                userPick = keyboard.nextLine();
            }
            while (userPick.equals("C") && pileC <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again: ");
                userPick = keyboard.nextLine();
            }
            //prompt for removal from pile
            System.out.print("How many to remove from pile " + userPick + ": ");
            removal = keyboard.nextInt();
            if (userPick.equals("A")) {
                while (removal > pileA) {
                    System.out.print("Pile A doesn't have that many. Try again: ");
                    removal = keyboard.nextInt();
                }
                pileA = pileA - removal;
            } else if (userPick.equals("B")) {
                while (removal > pileB) {
                    System.out.print("Pile B doesn't have that many. Try again: ");
                    removal = keyboard.nextInt();
                }
                pileB = pileB - removal;
            } else if (userPick.equals("C")) {
                while (removal > pileC) {
                    System.out.print("Pile C doesn't have that many. Try again: ");
                    removal = keyboard.nextInt();
                }
                pileC = pileC - removal;
            }
            keyboard.nextLine();
            ++turns; //keep count of # of turns

            //who's the winner?
            if (pileA + pileB + pileC == 1 && currentPlayer.equals(name1)) {
                System.out.print(name2 + ", you must take the last remaining counter, so you lose. " + name1 + " wins!");
                break;
            } else if (pileA + pileB + pileC == 1 && currentPlayer.equals(name2)) {
                System.out.print(name1 + ", you must take the last remaining counter, so you lose. " + name2 + " wins!");
            }
        }
    }
}