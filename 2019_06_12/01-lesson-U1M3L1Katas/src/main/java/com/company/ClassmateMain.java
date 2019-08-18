package com.company;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class ClassmateMain {

        public static void main(String[] args) {
            List<Classmate> classmateList = new ArrayList<Classmate>();


            classmateList.add(new Classmate("Bill", "Short"));
            classmateList.add(new Classmate("Michael", "Blond-ish"));
            classmateList.add(new Classmate("Bob", "Grey-ish"));
            classmateList.add(new Classmate("Marc", "Black"));
            classmateList.add(new Classmate("Joseph", "Brown"));
            classmateList.add(new Classmate("Ward", "Grey"));
            classmateList.add(new Classmate("Usman", "Dark"));


            for (Classmate BobsList: classmateList) {
                System.out.println("Name: " + BobsList.getName() + "  Hair Color: " + BobsList.getHairColor());
            }

        }
    }


