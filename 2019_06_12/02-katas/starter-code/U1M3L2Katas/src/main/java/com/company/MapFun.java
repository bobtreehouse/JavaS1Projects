package com.company;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Set;


public class MapFun {

    public static void printKeyValue(Map<String, Integer> map) {
        Set<String> keys = map.keySet();

        for (String key : keys) {
            System.out.println(map.get(key) + " " + key);
        }
        System.out.println("===============================");

    }

    public static void main(String[] args) {

        // Create HashMap

        Map<String, Integer> cars = new HashMap<String,Integer>();

        /*
        keys  /  values

         */

        cars.put("Toyota Camry", 2012);
        cars.put("Chevy Camaro", 1969);
        cars.put("Hyundai Genesis", 2015);
        cars.put("Jeep Wrangler", 2003);
        cars.put("Honda Civic", 2018);
        cars.put("Toyota Supra", 1995);
        cars.put("Pontiac GTO", 1964);

        // print what we have

        printKeyValue(cars);

        // add two  more

        cars.put("Ford Explorer", 2012);
        cars.put("Smart Fortwo", 2013);

        // print out all key/value pairs

        printKeyValue(cars);


        cars.remove("Jeep Wrangler");

        // print out all key/value pairs
        printKeyValue(cars);
    }
}