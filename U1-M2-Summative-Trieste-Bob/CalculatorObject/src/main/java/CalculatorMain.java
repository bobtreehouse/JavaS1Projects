import java.text.DecimalFormat;

public class CalculatorMain {


    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) {



        System.out.println("Methods using Ints:");
        System.out.println("1 + 1 = "+ Calculator.addIorD(1, 1));
        System.out.println("23 - 52 = "+Calculator.subtractIorD(23, 53));
        System.out.println("34 * 2 = "+ Calculator.multIorD(34, 2));
        System.out.println(" 12 / 3 = "+Calculator.divIorD(12, 3));
        System.out.println("12 / 7 = "+Calculator.divIorD(12, 7));
        System.out.println("3.4 + 2.3 = "+df2.format(Calculator.addIorD(3.4, 2.3)));
        System.out.println("6.7 * 4.4 = "+df2.format(Calculator.multIorD(6.7, 4.4)));
        System.out.println("5.5 -.05 = "+df2.format(Calculator.subtractIorD(5.5,0.5)));
        System.out.println("10.8 / 2.2 = "+df2.format(Calculator.divIorD(10.8, 2.2)));

        System.out.println("Methods using Doubles:");

        System.out.println("1 + 1 = "+ Calculator.addIorD(1, 1));
        System.out.println("23 - 52 ="+Calculator.subtractIorD(23, 53));
        System.out.println("34 * 2 = "+Calculator.multIorD(34, 2));
        System.out.println("12 / 3 = "+Calculator.divIorD(12, 3));
        System.out.println("12 / 7 = "+Calculator.divIorD(12, 7));
        System.out.println("3.4 + 2.3 = "+df2.format(Calculator.addIorD(3.4, 2.3)));
        System.out.println("6.7 * 4.4 ="+df2.format(Calculator.multIorD(6.7, 4.4)));
        System.out.println("5.5 - .05 = "+df2.format(Calculator.subtractIorD(5.5, 0.5)));
        System.out.println("10.8 / 2.2 = "+df2.format(Calculator.divIorD(10.8, 2.2)));
    }


}
