import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int pileA = 3;
        int pileB = 3;
        int pileC = 3;


        System.out.println("In this game we start with these 3 piles of counters.");
        System.out.println("Keep selecting until all piles are empty.");


            while(pileA >0 || pileB > 0 || pileC > 0) {

                System.out.println("A:" + pileA + "     " + "B:" + pileB + "     " + "C" + pileC);

                System.out.println("Choose a pile: \r");

                String userPick = scan.nextLine();


                System.out.println("\nHow Many to remove from Pile " + userPick + ": ");


                int userInputDigit = scan.nextInt();
                scan.nextLine();

                if (userPick.equals("a")) {
                    pileA = pileA - userInputDigit;

                } else if (userPick.equals("b")) {
                    pileB = pileB - userInputDigit;

                } else if (userPick.equals("c")) {
                    pileC = pileC - userInputDigit;
                }
                if (pileA <= 0 && pileB <= 0 && pileC <= 0) {

                    System.out.println("All are now zero = You are complete !!");
                }
            }

        }
    }







