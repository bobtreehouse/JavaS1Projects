package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> tvs;

            tvs = mapper.readValue(new File("\\C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\starter-code\\U1M3L4Katas\\televisions.json"), new TypeReference<List<Televisions>>() {
            });
            int screenSize = 60;
            tvs.stream().filter(t -> t.getScreenSize() > screenSize)
                    .forEach(t -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + t.getBrand());
                        System.out.println("Model: " + t.getModel());
                        System.out.println("Price: " + t.getPrice());
                        System.out.println("ScreenSize: " + t.getScreenSize());


                    });

            Map<String, List<Televisions>> groupedTvsByBrand =
                    tvs.stream().collect(Collectors.groupingBy(t -> t.getBrand()));

            Set<String> keys = groupedTvsByBrand.keySet();
            System.out.println(" ");
            System.out.println("-------List of Manufacturers------");
            for(String key : keys) {
                System.out.println(key);
            }

            double avgScreenSize =
                    tvs
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average ScreenSize is: " + avgScreenSize);

            int maxScreenSize =
                    tvs
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Max Screen Size: " + maxScreenSize);

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }


}