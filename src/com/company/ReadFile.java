package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.company.Main.planetSystemList;

public class ReadFile {

    static String planetSavePath = "solar_system_planets";
    static String planetSaveExtension = ".csv";
    static String planetCSVDevider = ",";
    static boolean emtySystem = false;

    public static void readFile_V1(int whatSystem) {
        planetSaveExtension = ".csv";

        try {
            File file = new File(planetSavePath + planetSaveExtension);    // Finds the file path
            Scanner fileScanner = new Scanner(file);    // Scanns thrue the file that is spesefied in File and finds the content

            String[] stringProp = fileScanner.nextLine().split(planetCSVDevider);

            emtySystem = planetSystemList.get(whatSystem).getNumberOfPlanets() == 0;

            while (fileScanner.hasNextLine()) {
                String[] splitFileString = fileScanner.nextLine().split(planetCSVDevider);
                Planet planet = new Planet();

                if (emtySystem) {
                    for (int i = 0; i < stringProp.length; i++) {
                        planet.setPlanetPropByName(stringProp[i], splitFileString[i]);
                    }
                    planetSystemList.get(whatSystem).addPlanetToSystem(planet);
                } else {
                    for (int i = 0; i < planetSystemList.get(whatSystem).getNumberOfPlanets(); i++) {     // This fixes the "bug" that allowd you to import multiple of the same planet.
                        if (planetSystemList.get(whatSystem).getPlanet(i).getName().equals(splitFileString[0]) && Double.toString(planetSystemList.get(whatSystem).getPlanet(i).getMass()).equals(splitFileString[1]) && Double.toString(planetSystemList.get(whatSystem).getPlanet(i).getRadius()).equals(splitFileString[2])) {       // Test if the name, radius and mass it the same, if it is the do not import the planet
                            System.out.println("Skipping planet: " + splitFileString[0]);
                        } else if (planetSystemList.get(whatSystem).getPlanet(i).getName().equals(splitFileString[0])) {        // Test if a the planet from the CSV and array has the same name
                            System.out.println();

                            System.out.println("Found " + splitFileString[0] + " in the CSV file and that planet matches " + planetSystemList.get(whatSystem).getPlanet(i).getName() + " that is already in the system.");
                            System.out.println("What planet do you want to keep?");
                            System.out.println("Planet in CSV(1): " + splitFileString[0] + "," + splitFileString[1] + "," + splitFileString[2]);
                            System.out.println("Planet in system(2): " + planetSystemList.get(whatSystem).getPlanet(i).getName() + " , " + planetSystemList.get(whatSystem).getPlanet(i).getMass() + " , " + planetSystemList.get(whatSystem).getPlanet(i).getRadius());

                            switch (new UserInput().getString()) {
                                case "csv":
                                case "CSV":
                                case "1":
                                    for (int j = 0; j < stringProp.length; j++) {
                                        planetSystemList.get(whatSystem).getPlanet(i).setPlanetPropByName(stringProp[j],splitFileString[j]);
                                    }
                                    System.out.println("Changing to " + splitFileString[0] + " from the CSV");
                                    break;
                                case "2":
                                    System.out.println("Skipping " + splitFileString[0]);
                                    break;
                            }
                        }
                    }
                }
            }

            fileScanner.close();
            System.out.println("Planets Added:");
            planetSystemList.get(whatSystem).printPlanetList();
            System.out.println();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Eksisterer " + planetSavePath + planetSaveExtension + " ?");   // If the file does not exist this will be printet
            System.out.println(e.toString());   // -------------------------------------
        }
    }

    public static void readFile_V2(int whatSystem) {
        planetSaveExtension = ".txt";

        //TODO: Make this read the .txt file that i create in SaveFile.saveFile_V2(), can do next oblig also
    }

}
