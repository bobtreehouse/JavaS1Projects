
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


public class PhoneReader {
    public static void main(String[] args) {
        try {
            XmlMapper mapper = new XmlMapper();
            List<Phones> phones;

            phones = mapper.readValue(new File("C:\\Users\\bobtr\\OneDrive\\CTSH\\RU-RCOG-E-CJS1_HOMEWORK_Bob_Trieste\\2019_06_13\\katas\\starter-code\\U1M3L4Katas\\phones.xml"), new TypeReference<List<Phones>>(){});

            for (Phones phone : phones) {
                System.out.println("Brand: " + phone.getBrand());
                System.out.println("Model: " + phone.getModel());
                System.out.println("Processor: " + phone.getProcessor());
                System.out.println("Storage: " + phone.getStorage());
                System.out.println("Price: " + phone.getPrice());
                System.out.println("===============================");
            }

        } catch (Exception e) {
            System.out.println("An error occurred:");
            System.out.println(e);
        }
    }
}