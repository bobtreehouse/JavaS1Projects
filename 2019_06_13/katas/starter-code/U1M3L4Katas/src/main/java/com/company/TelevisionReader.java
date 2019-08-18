package com.company;


import com.company.Phones;
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

public class TelevisionReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> televisionsList;

            televisionsList = mapper.readValue(new File("\\C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\starter-code\\U1M3L4Katas\\televisions.json"), new TypeReference<List<Televisions>>(){});

            for (Televisions moto : televisionsList) {
                System.out.println("================");
                System.out.println(moto.getBrand());
                System.out.println(moto.getModel());
                System.out.println(moto.getPrice());
                System.out.println(moto.getScreenSize());

            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }




}