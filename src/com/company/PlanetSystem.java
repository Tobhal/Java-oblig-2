package com.company;

import java.util.ArrayList;
import static com.company.Main.sc;      // imports sc (input scanner) from main so i can use it here

public class PlanetSystem {
    private String name;
    private CenterStar centerStar;
    private static ArrayList<Planet> planetList = new ArrayList<Planet>();      // Array list with all of the planets in

    PlanetSystem() {
    }

    PlanetSystem(String name) {
        this.name = name;
    }

    PlanetSystem(String name, Planet planet) {
        this.name = name;
        planetList.add(planet);
    }

    PlanetSystem(String name, Planet planet, CenterStar senterStar) {
        this.name = name;
        planetList.add(planet);
        this.centerStar = senterStar;
    }

    // Add
    public void addPlanetToSystem(Planet planet) {
        planetList.add(planet);
    }

    public void createPlanet() {        // Function to add planets.
        System.out.print("Type the name of the planet: ");
        UserInput input1 = new UserInput(sc.next());
        System.out.print("Type the mass of the planet: ");
        UserInput input2 = new UserInput(sc.next());
        System.out.print("Type the radius of the planet: ");
        UserInput input3 = new UserInput(sc.next());

        planetList.add(new Planet(input1.getString(), input2.getDouble(), input3.getDouble()));
    }

    // Sett
    public void setName(String name) {
        this.name = name;
    }

    public void setCenterStar(CenterStar senterStar) {
        this.centerStar = senterStar;
    }

    // Get
    public String getName() {
        return name;
    }

    public CenterStar getCenterStar() {
        return centerStar;
    }

    public Planet getPlanet(int index) {
        if (planetList.get(index) != null) {
            return planetList.get(index);
        } else {
        return null;
        }
    }

    public int getNumberOfPlanets() {
        return planetList.size();
    }

    public Planet getPlanetByName(String name) {
        for (Planet planet : planetList) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    public Planet getBiggestPlanet() {
        Planet tempPlanet = planetList.get(0);
        for (Planet planet : planetList) {
            if (tempPlanet.getMassRadiusRatio() < planet.getMassRadiusRatio()) {
                tempPlanet = planet;
            }
        }
        return tempPlanet;
    }

    public Planet getSmallestPlanet() {
        Planet tempPlanet = planetList.get(0);
        for (Planet planet : planetList) {
            if (tempPlanet.getMassRadiusRatio() > planet.getMassRadiusRatio()) {
                tempPlanet = planet;
            }
        }
        return tempPlanet;
    }

    // Print
    public void printPlanetList() {
        for (Planet planet : planetList) {
            System.out.println(planet.getName());
        }
    }

    public void printAllInfo() {
        centerStar.printAllInfo();
        for (Planet planet : planetList) {
            planet.printAllInfo();
        }
    }
}
