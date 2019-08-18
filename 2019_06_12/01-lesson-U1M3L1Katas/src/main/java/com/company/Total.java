package com.company;

import java.util.ArrayList;
import java.util.List;

public class Total {

    public static void main(String[] args) {

        int[] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};
        int  total = 0;
//
//        int total = 0;
//
//        for (int element : numbers) {
//            total += element;
//        }

        //System.out.println("The sum of all elements in the array is " + total);


        List<Integer> integerList = new ArrayList<Integer>();
        for (int element : numbers) {
            integerList.add(element);
        }
        for (int element : integerList) {
            total += element;
        }

            System.out.println("The sum of all elements in the array is " + total);
    }
}


