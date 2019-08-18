package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SwapAndPrintLinked {


        public static void main(String[] args) {

            int[] numbers = {2, 4, 5, 3,
                    7, 6, 1, 9,
                    10, 13, 56, 43};

            //System.out.println("----------------");
            //System.out.println("Original Array");

            List<Integer> integerList = new LinkedList<Integer>();
            for (int element : numbers) {
                integerList.add(element);
                System.out.println( element);
            }


             //System.out.println("Original Array " + integerList);

            List<Integer> rev = new LinkedList<>();
            for(int i=0; i < integerList.size(); i++) {
                rev.add(integerList.get(integerList.size() - i - 1));
            }
            System.out.println("----------------");
            //System.out.println("Swapped Array");

            for(int element : rev) {
                System.out.println( element);
                //System.out.println("Swapped Array " + rev);
            }



        }

    }


