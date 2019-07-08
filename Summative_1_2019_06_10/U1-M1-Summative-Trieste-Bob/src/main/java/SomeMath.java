public class SomeMath<largest> {

    public static void main(String[] args) {

        System.out.println("Total = " + total5(1, 2, 3, 4, 5));
        System.out.println("Average = " + average5(1, 3, 5, 7, 9));
        System.out.println("Largest = " + largest5(42.0, 35.1, 2.3, 40.2, 15.6));
        //largest5(42.0, 35.1, 2.3, 40.2, 15.6);
    }

    private static int total5(int i, int i1, int i2, int i3, int i4) {


        int sum = (i + i1 + i2 + i3 + i4);


        return sum;
    }

    public static double average5(int i, int i1, int i2, int i3, int i4) {

        double avg = ((i + i1 + i2 + i3 + i4) / 5);


        return avg;


    }

    public static double largest5(double i, double i1, double i2, double i3, double i4) {

        double largest = 0;

        if ((i >= i1) && (i >= i2) && (i >= i3) && (i >= i4)) {

            return i;

        } else if ((i1 >= i2) && (i1 >= i3) && (i1 >= i4) && (i1 >= i)) {

            return i1;


        } else if ((i2 >= i3) && (i2 >= i4) && (i2 >= i1) && ((i2 >= i))) {

            return i2;


        } else if ((i3 >= i4) && (i3 >= i) && (i3 >= i1) && (i3 >= i2)) {

            return i3;

        } else if ((i4 >= i) && (i4 >= i1) && (i4 >= i2) && (i4 >= i3)) {

            return +i4; }

        return (largest);}

}




































