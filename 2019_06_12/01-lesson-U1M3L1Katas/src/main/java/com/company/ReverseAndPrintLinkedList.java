package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseAndPrintLinkedList {


        public static void main(String[] args) {

            int[] numbers = {2, 4, 5, 3,
                    7, 6, 1, 9,
                    10, 13, 56, 43};


            List<Integer> integerList = new LinkedList<Integer>();
            for (int element : numbers) {
                integerList.add(element);
            }
            System.out.println("Original Array " + integerList);

            List<Integer> intergerRev = new LinkedList<>();
            for (int i = 0; i < integerList.size(); i++) {

                intergerRev.add(integerList.get(integerList.size() - i - 1));
            }


            for (int element : intergerRev) {
            }
            System.out.println("Reversed Array " + intergerRev);
        }
    }








