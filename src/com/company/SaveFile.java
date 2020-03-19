package com.company;

import java.util.List;
import java.io.File;
import java.io.FileWriter;

import static com.company.Main.createCenterStar;

public class SaveFile {

    static String planetSavePath = "solar_system_planets";
    static String planetSaveExtension = ".csv";
    static String planetCSVDevider = ",";

    public static void saveFile_V1(List<PlanetSystem> planetSystems) {
        planetSaveExtension = ".csv";
        try {
            File file = new File(planetSavePath + "_UserSaved" + planetSaveExtension);    // Creates the file
            FileWriter fileWriter = new FileWriter(file);   // Starts a new file Writer on the file

            fileWriter.write("Name, Radius, Gravitasjon");  // Adds the headers

            for (int i = 0; i < planetSystems.get(0).getNumberOfPlanets(); i++) {
                fileWriter.write("\n");
                fileWriter.write(planetSystems.get(0).getPlanet(i).getName() + planetCSVDevider + planetSystems.get(0).getPlanet(i).getMass() + planetCSVDevider + planetSystems.get(0).getPlanet(i).getRadius());
            }

            fileWriter.flush();   // Remoes the buffer of characters
            fileWriter.close();   // Close the fileWriter afther the it is flushed

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void saveFile_V2(List<PlanetSystem> planetSystems) {
        planetSaveExtension = ".txt";
        try {
            File file = new File(planetSavePath + "_UserSaved_test" + planetSaveExtension);
            FileWriter fileWriter = new FileWriter(file);

            for (int i = 0; i < planetSystems.size(); i++) {
                fileWriter.write(planetSystems.get(i).getName() + "\n");

                fileWriter.write("  " + "Stars:\n");

                if (planetSystems.get(i).getCenterStar() == null) {
                    createCenterStar(i);
                }

                fileWriter.write("    " + "Name: " + planetSystems.get(i).getCenterStar().getName() + "\n");

                fileWriter.write("      " + "Mass: " + planetSystems.get(i).getCenterStar().getMass() + "\n");
                fileWriter.write("      " + "Radius: " + planetSystems.get(i).getCenterStar().getRadius() + "\n");
                fileWriter.write("      " + "Effective Temprature: " + planetSystems.get(i).getCenterStar().getEffectiveTemp() + "\n");

                fileWriter.write("  " + "Planets:\n");

                for (int l = 0; l < planetSystems.get(i).getNumberOfPlanets(); l++) {    // Prints the planets
                    fileWriter.write("    " + "Name: " + planetSystems.get(i).getPlanet(l).getName() + "\n");

                    fileWriter.write("      " + "Mass: " + planetSystems.get(i).getPlanet(l).getMass() + "\n");
                    fileWriter.write("      " + "Radius: " + planetSystems.get(i).getPlanet(l).getRadius() + "\n");
                }

                fileWriter.write("\n");
            }

            fileWriter.flush();   // Remoes the buffer of characters
            fileWriter.close();   // Close the fileWriter afther the it is flushed

        } catch (Exception e) { }
    }

}