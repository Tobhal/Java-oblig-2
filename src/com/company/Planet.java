package com.company;

import static com.company.Main.sc;

public class Planet extends CelestialBody {
    Planet(String name) { super(name); }
    Planet(String name, double mass) { super(name, mass); }
    Planet(String name, double mass, double radius) { super(name, mass, radius); }

    public Planet() { }

    public void printPlanet() {   // Prints all of the plannets that is stored
        System.out.println("The planet " + name + " has a radus of: " + radius + " km and the gravity is: " + mass + "");
    }

    public void printRadius() {
        System.out.println(radius + "km");
    }

    public void printMass() {
        System.out.println(mass + "kg");
    }

    public void printMjup() { System.out.println("Mjup: " + mass/1.898E27); }

    public double getMjup() { return mass/1.898E27; }

    public void printMearth() { System.out.println("Mearth: " + mass/5.972E24); }

    public double getMearth() { return mass/5.972E24; }

    public void printRjup() { System.out.println("Rjup: " + radius/71492); }

    public double getRjup() { return radius/71492; }

    public void printRearth() { System.out.println("Rearth: " + radius/6371); }

    public double getRearth() { return radius/6371; }

    public double surfaceGravity() { return (0.00000000006674 * mass)/(Math.pow((radius * 1000), 2)); }

    public void printAllInfo() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(name + " has theas properties:");
        System.out.println("Radius: " + radius + " and Rjup: " + getRjup() + "\nMass: " + mass + "and Mjup: " + getMjup() + "\nThe surface gravity is: " + surfaceGravity());
        System.out.println("--------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRadius: " + radius + "km\nRjup: " + getRjup() + "Rjup\nMass: " + mass + "kg\nMjup:" + getMjup() + "\nThe surface gravity is: " + surfaceGravity();
    }
}

/*
 */