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


//         int integerList2 = integerList.get(0);
//
//         integerList.get(0) = integerList[integerList.size()-1];
//
//        integerList[integerList.size() -1] = integerList2;
	    //System.out.println("New array after swaping the first and last elements: "+Arrays.toString(array_nums));

        int temp = integerList.get(0);
        int last = integerList.size()-1;
        integerList.get(0) = integerList.get(0);(integerList.size()-1);
        integerList[numbers.length - 1] = temp;

        int temp2 = integerList.get(0);
        temp2 = temp2[temp2 - 1];
        temp2[temp2 - 1] = temp;
          for (int i = 0; i < integerList2; i++) {



            System.out.println("Swapped Array " + integerList2);


        }

    }
}


//for (int element : integerList) {
//System.out.println(element);



//        for(int element : integerList) {
//         System.out.println(element);


//        int temp = numbers[0];
//        numbers[0] = numbers[numbers.length - 1];
//        numbers[numbers.length - 1] = temp;
//
//        int temp2 = integerList.get(0);
//        temp2 = temp2[temp2 - 1];
//        temp2[temp2 - 1] = temp;

//    int[] array_nums = {20, 30, 40};
//	System.out.println("Original Array: "+Arrays.toString(array_nums));