package com.company;

import java.util.ArrayList;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        for (String element : wordList) {
            //System.out.println(element);
        }

        List<String> bobList = new ArrayList<String>();

        bobList.add("byte");
        bobList.add("case");
        bobList.add("catch");
        bobList.add("class");
        bobList.add("const");
        bobList.add("continue");
        bobList.add("do");
        bobList.add("double");
        bobList.add("else");
        bobList.add("extends");

        //System.out.println("enhanced for loop below");
        for (String element : bobList) { //enhanced for loop
            System.out.println(element); // prints all elements in myList

        }

    }
}

