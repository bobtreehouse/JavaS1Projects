package com.company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class JSONWriteAndRead {
/*
carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
carList.add(new Car(2001, "Honda", "Civic", "Silver"));
carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
carList.add(new Car(1964, "Ford", "Mustang", "Red"));
 */

    public static void main(String[] args) {
        PrintWriter writer = null;
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            System.out.println(jsonCarList);


            writer = new PrintWriter(new FileWriter("car.json"));

            writer.println(jsonCarList);


            //carList = mapper.readValue(new File("car.json"), new TypeReference<List<Car>>(){});


                for (Car car : carList) {
                    System.out.println("================");
                    System.out.println("=================================");
                    System.out.println(car.getMake());
                    System.out.println(car.getModel());
                    System.out.println(car.getYear());
                    System.out.println(car.getColor());
                }

            } catch (IOException e) {
                System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
            }
        }
    }


