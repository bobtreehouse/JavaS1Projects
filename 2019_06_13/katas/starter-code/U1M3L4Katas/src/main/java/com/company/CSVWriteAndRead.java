package com.company;

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

public class CSVWriteAndRead {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();




            //new CsvToBeanBuilder<Car>(new FileReader("C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\starter-code\\U1M3L4Katas\\Car.csv")).withType(Car.class).build().parse();



            Car[] carsList;
            //for (Car car : carsList) {
                    carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
                    carList.add(new Car(2001, "Honda", "Civic", "Silver"));
                    carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
                    carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
                    carList.add(new Car(1964, "Ford", "Mustang", "Red"));
                // Now let's write the motorcycle list to another file

        try {

            List<Car> cars =
                    new CsvToBeanBuilder<Car>(new FileReader("C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\new_cars_file.csv")).withType(Car.class).build().parse();

            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());

            }
            Writer writer = new FileWriter("new_cars_file.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(carList);
                writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }

    }

}