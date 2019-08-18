package com.company;

import java.util.ArrayList;
import java.util.List;

public class SwapAndPrint {

    public static void main(String[] args) {

        int[] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        //System.out.println("----------------");
        //System.out.println("Original Array");

        List<Integer> integerList = new ArrayList<Integer>();
        for (int element : numbers) {
            integerList.add(element);
        }
        System.out.println("Original Array " + integerList);


        Integer rev = integerList.get(0);
        integerList.set(0, integerList.get(integerList.size() - 1));
        integerList.set(integerList.size() - 1, rev);

        System.out.println("----------------");
        //System.out.println("Swapped Array");

        for(int element : integerList) {
            System.out.println( element);
            //System.out.println("Swapped Array " + rev);
        }



        }

    }
