package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class ComputerReader {


    public static void main(String[] args) {
        try {
            List<Computers> computers =
                    new CsvToBeanBuilder<Computers>(new FileReader("C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\starter-code\\U1M3L4Katas\\computers.csv")).withType(Computers.class).build().parse();

            for (Computers computers1 : computers) {
                System.out.println("=================================");
                System.out.println(computers1.getBrand());
                System.out.println(computers1.getcPU());
                System.out.println(computers1.getrAM());
                System.out.println(computers1.getStorageSize());


            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());


        }
    }
}
