package com.company;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.*;

public class CarLists {

    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");


        /*
        create some lists


         */
        List<Car> toyotaList = new ArrayList<Car>();
        toyotaList.add(camry);
        toyotaList.add(corolla);
        toyotaList.add(highlander);

        List<Car> hondaList = new ArrayList<Car>();
        hondaList.add(accord);
        hondaList.add(civic);
        hondaList.add(fit);

        List<Car> fordList = new ArrayList<Car>();
        fordList.add(mustang);
        fordList.add(fusion);
        fordList.add(taurus);



        // Store all 3 lists in  Map
        Map<String, List<Car>> carMap = new HashMap<>();
        carMap.put("Toyota", toyotaList);
        carMap.put("Ford", fordList);
        carMap.put("Honda", hondaList);



        // Print out  make  &  model
        Set<String> keys = carMap.keySet();
        for(String key : keys) {
            List<Car> carList = carMap.get(key);

            for(Car car : carList) {
                System.out.println(car.getMake() + " " + car.getModel());
            }
        }
    }
}
