package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

public class PrintSet {
    public static void main(String[] args) {
        Set<Integer> printSet = new HashSet<>();

        printSet.add(5);

        printSet.add(1);

        printSet.add(2);

        printSet.add(1);

        printSet.add(4);

        printSet.add(1);

        printSet.add(7);

        Iterator iter = printSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
}