package com.company;

public class CelestialBody {
    protected String name;     // The name of the planet
    protected double radius;   // The radius of the planet
    protected double mass;  // The gravoty of the planet

    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setPlanetPropByName(String prop, String value) {
        switch (prop) {
            case "name":
                this.name = new UserInput(value).getString();
                break;
            case "mass":
                this.mass = new UserInput(value).getDouble();
                break;
            case "radius":
                this.radius = new UserInput(value).getDouble();
                break;
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public double getMassRadiusRatio() { return mass / radius; }

    CelestialBody() {
    }

    CelestialBody(String name) {
        this.name = name;
    }

    CelestialBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    CelestialBody(String name, double mass, double radius) {  // Makes it posible to use constroctors with the class, so i can add parameters to the new Planet insted of setting that later
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }
}
