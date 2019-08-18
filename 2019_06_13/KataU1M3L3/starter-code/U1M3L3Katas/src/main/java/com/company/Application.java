package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Application {

    public static void main(String[] args) {
        /*
        needs a TRY + CATCHES + FINALLY
         */

        try{
        int petIndex = Pets.choosePet();

        String chosenPet = Pets.retrievePet(petIndex);

        Pets.readPetsFromFile();

        Pets.writePetToFile(chosenPet);

    } catch(NumberFormatException e) {

        System.out.println("Please enter a valid number.");
    } catch(ArrayIndexOutOfBoundsException e) {

        System.out.println("Please choose an available pet.");
    } catch(FileNotFoundException e) {

        System.out.println("File does not exist.");
        System.out.println(e);
    } catch(IOException e) {

        System.out.println("There was a problem writing the file.");
        System.out.println(e);


    } finally {
        System.out.println("Have a nice day!");
    }

    }
}
