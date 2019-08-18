package com.company;

//package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAndPrint {

    public static void main(String[] args) {

        int[] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

//        System.out.println("--------------");
//        System.out.println("Normal");
//        System.out.println("--------------");

        List<Integer> integerList = new ArrayList<Integer>();
        for (int element : numbers) {
            integerList.add(element);
        }
        System.out.println("Original Array " + integerList);

        List<Integer> intergerRev = new ArrayList<Integer>();
        for (int i = 0; i < integerList.size(); i++) {

            intergerRev.add(integerList.get(integerList.size() - i - 1));
        }

//        System.out.println("--------------");
//        System.out.println("Reversed");
//        System.out.println("--------------");

        for (int element : intergerRev) {
        }
            System.out.println("Reversed Array " + intergerRev);
        }
    }







//        for(int element : numbers) {
//            System.out.println(element);

//        }
//
//        int[] reversed = new int[numbers.length];
//
//        for(int i = 0; i < numbers.length; i++) {
//            reversed[i] = numbers[numbers.length-(i+1)];
//        }
//
//        System.out.println("--------------");
//        System.out.println("Reversed");
//        System.out.println("--------------");
//
//        for(int element : reversed) {
//            System.out.println(element);

