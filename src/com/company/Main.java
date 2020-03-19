package com.company;

import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    public static ArrayList<PlanetSystem> planetSystemList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    static int whatSystem = 0;
    static PlanetSystem system = new PlanetSystem("System_kake");
    static Boolean running = true;

    public static void saveMenu() {
        System.out.println("Do you want to import planets (1), save planets to CSV(2) or save to file(3). 4 to cansle");

        switch (new UserInput().getString()) {
            case "1":
                ReadFile.readFile_V1(whatSystem);
                //importPlanetCSV();
                break;
            case "2":
                SaveFile.saveFile_V1(planetSystemList);
                break;
            case "3":
                SaveFile.saveFile_V2(planetSystemList);
                break;
            case "4":
                moreThings();
                break;
            default:
                System.out.println("That is not a valid command");
                saveMenu();
                break;
        }
    }

    public static void showMenu() {
        if (planetSystemList.isEmpty() || planetSystemList.get(0) == null || planetSystemList.get(0).getNumberOfPlanets() == 0) {       // if there is no planet system or no planets int the system, it wil just exit.
            System.out.println("There is nothing in any sysmtem... pleas add or import some before listing");
             moreThings();
        } else {
            System.out.println("Show all info for the current system " + whatSystem + "(1), show all in all systems(2), 3 to cansle");

            switch (new UserInput().getString()) {
                case "1":
                    if (planetSystemList.get(whatSystem).getCenterStar() == null) {
                        createCenterStar(whatSystem);
                    }
                    System.out.println(planetSystemList.get(whatSystem).getCenterStar().toString() + "\n");
                    for (int i = 0; i < planetSystemList.get(whatSystem).getNumberOfPlanets(); i++) {
                        System.out.println(planetSystemList.get(whatSystem).getPlanet(i).toString());
                        System.out.println("\n");
                    }
                    break;
                case "2":
                    for (PlanetSystem planetSystem : planetSystemList) {        // For loop for all of the planets in planetSystemList
                        if (planetSystem.getCenterStar() == null) {     // Test if there is a star and if not then it adds a center star
                            createCenterStar(whatSystem);
                        }
                        System.out.println(planetSystem.getCenterStar().toString() + "\n");
                        for (int j = 0; j < planetSystem.getNumberOfPlanets(); j++) {
                            System.out.println(planetSystem.getPlanet(j).toString());
                            System.out.println("\n");
                        }
                    }
                    break;
                case "3":
                    moreThings();
                    break;
                default:
                    System.out.println("That is not a valid command");
                    showMenu();
                    break;
            }
        }
    }

    public static void systemMenu() {
        clearConsoll();

        System.out.println("Do you want to add a new system(1), or change to a existing system(2)? 3 to exit.");

        switch (new UserInput().getString()) {
            case "1":
                createSystem();
                break;
            case "2":
                System.out.println("What system do you want to chnage to?");
                for (int i = 0; i < planetSystemList.size(); i++) {
                    System.out.println(i + " - " + planetSystemList.get(i).getName());
                }
                whatSystem = new UserInput().getInt();
                break;
            case "3":
                moreThings();
                break;
            default:
                break;
        }
    }

    public static void createSystem() {
        clearConsoll();
        System.out.println("What is the name of the new system");
        UserInput input1 = new UserInput();

        PlanetSystem planetSystem = new PlanetSystem(input1.getString());

        planetSystemList.add(planetSystem);     // Adds a new planet system to the planetSystem arrayList

        systemMenu();
    }

    public static void createCenterStar(int index) {        // Creates a new star
        System.out.println("Write the name of the Center Star");
        UserInput input1 = new UserInput();

        System.out.println("Write the mass of the Center Star");
        UserInput input2 = new UserInput();

        System.out.println("Write the radius of the Center Star");
        UserInput input3 = new UserInput();

        System.out.println("Write the efective temprature of the Center Star");
        UserInput input4 = new UserInput();

        CenterStar centerStar = new CenterStar(input1.getString(), input2.getDouble(), input3.getDouble(), input4.getDouble());

        if (index >=0) {
            planetSystemList.get(index).setCenterStar(centerStar);
        } else {
            planetSystemList.get(0).setCenterStar(centerStar);
        }
    }

    public static void clearConsoll() {   // Clears the console
        try {
            if (System.getProperty("os.name").contains("Windows"))    // Test if the system is windows or not
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();   // Runs cmd, then the command (/c) cls
            else {
                System.out.print("\033[H\033[2J");    // If it is not windows then this. find the height of the consol window (\033[H) then puts that many new lines (\033[2J)
                // System.out.flush();    // Not needed, but i have it her if i finde errors
            }
        } catch (IOException | InterruptedException ignored) {}
    }

    public static void create() {
        if (planetSystemList.get(whatSystem).getName() == null) {
            // Create a new system
            System.out.println("Create new system");
        }

        System.out.println("What do you want to do? \nAdd new planet to the system(1). Add multiple planets(2). Import planets from file (CSV) (3)");

        switch (new UserInput().getString()) {
            case "1":
                planetSystemList.get(whatSystem).createPlanet();
                break;
            case "2":
                boolean adding = true;
                while (adding) {
                    planetSystemList.get(whatSystem).createPlanet();
                    System.out.print("Done adding planets? Y/N");
                    UserInput input1 = new UserInput(sc.next());

                    if (input1.getString().equals("Y") || input1.getString().equals("y")) {
                        adding = false;
                    }
                }
                break;
            case "3":
                ReadFile.readFile_V1(whatSystem);
                break;
            default:
                System.out.print("That is not a valid command, try again!");
                create();
                break;
        }
    }

    public static void edit() {
        System.out.println("Do you want to edit a planet(1) or the center star(2). 3 to cansle");

        switch (new UserInput().getString()) {
            case "1":
                editPlanet();
                break;
            case "2":
                editCenterStar();
                break;
            case "3":
                moreThings();
                break;
            default:
                System.out.println("That is not a valid command");
                break;
        }
    }

    public static void editPlanet() {
        System.out.println("What planet do you want to edit? 5 to cansle");
        for (int i = 0; i < planetSystemList.get(whatSystem).getNumberOfPlanets(); i++) {       // Loops thrue all of the planets in the system and prints them out
            System.out.println(i + " - " + planetSystemList.get(whatSystem).getPlanet(i));
        }
        UserInput index = new UserInput();

        System.out.println("What part of the planet do you want to edit? name(1), mass(2), radius(3), all info(4). 5 to cansle");

        switch (new UserInput().getString()) {
            case "1":
                System.out.println("Type the new name for the planet:");
                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setName(new UserInput().getString());
                break;
            case "2":
                System.out.println("Type the new mass for the planet");
                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setMass(new UserInput().getDouble());
                break;
            case "3":
                System.out.println("Type the new radius for the planet");
                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setRadius(new UserInput().getDouble());
                break;
            case "4":
                System.out.print("Name:");
                UserInput input1 = new UserInput();     // Gets a input

                System.out.print("Mass:");
                UserInput input2 = new UserInput();     // Gets a input

                System.out.print("Radius:");
                UserInput input3 = new UserInput();     // Gets a input

                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setName(input1.getString());     // Eddits the planet
                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setMass(input2.getDouble());     // Eddits the planet
                planetSystemList.get(whatSystem).getPlanet(index.getInt()).setRadius(input3.getDouble());   // Eddits the planet
                break;
            case "5":
                moreThings();
                break;
            default:
                break;
        }
    }

    public static void editCenterStar() {
        System.out.println("What part of the center star do you want to edit?");
        // TODO: do this thing, oblig 3?
    }

    public static void mainTask() {
        //2.2
        CenterStar centerStar = new CenterStar("Sun", 695700, 98892E30, 5777);      // Creates a star

        planetSystemList.get(0).setCenterStar(centerStar);      // Adds the star to the planetSystem

        ReadFile.readFile_V1(whatSystem);       // Imports the CSV file with all of the planetst to the planet system

        //2.3
        System.out.println("2.3");
        System.out.println(planetSystemList.get(0).getPlanet(3).toString());
        System.out.println(planetSystemList.get(0).getCenterStar().toString());

        //2.4
        System.out.println("2.4");
        System.out.println("Saturn has a Mjup of: " + planetSystemList.get(0).getPlanetByName("Saturn").getMjup() + " and a Rjup of: " + planetSystemList.get(0).getPlanetByName("Saturn").getRjup());
        System.out.println("The sun has a Msun of: " + planetSystemList.get(0).getCenterStar().getMsun() + " and a Rsun of: " + planetSystemList.get(0).getCenterStar().getRsun());

        //2.5
        System.out.println("2.5.\n Neptune has a surface gravity of " + planetSystemList.get(0).getPlanetByName("Neptune").surfaceGravity() + "g^2");

        // 2.6
        System.out.println("2.6.");
        System.out.println("The biggest planet in the solar system is: " + planetSystemList.get(0).getBiggestPlanet().getName());
        System.out.println("The samllets plannet in the solar system is: " + planetSystemList.get(0).getSmallestPlanet().getName());

        // Bonus 3.1
        System.out.println("Bonus task 3.1");
        System.out.println("Uranus has a Mearth of: " + planetSystemList.get(0).getPlanetByName("Uranus").getMearth() + " and a Rearth of: " + planetSystemList.get(0).getPlanetByName("Uranus").getRearth());
    }

    public static void listCommands() {
        System.out.println("0 - List commands");
        System.out.println("1 - Create");
        System.out.println("2 - List/show");
        System.out.println("3 - Edit/delete");
        System.out.println("4 - Save/load/delete file");
        System.out.println("5 - Change planet system");
        System.out.println("9 - Exit");
    }

    public static void moreThings() {
        clearConsoll();

        listCommands();

        switch (new UserInput().getString()) {
            case "0":
            case "help":
            case "Help":
                listCommands();
                break;
            case "1":
                create();
                break;
            case "2":
                showMenu();
                break;
            case "3":
                edit();
                break;
            case "4":
                saveMenu();
                break;
            case "5":
                systemMenu();
                break;
            case "9":
            case "exit":
            case "Exit":
                System.exit(1);
                running = false;
                sc.close();
                break;

            default:
                clearConsoll();
                System.out.println("That is not a valid command. \n type 0 to list all commands");
                break;
        }
    }

    public static void gameLoop() {
        System.out.println("Runt the task (1), or standalone program (2)?");

        String input = new UserInput().getString();

        if (input.equals("1")) {
            mainTask();
        } else {
            while (running) moreThings();       // Runs the moreThings function in a while loop, so when i want to exit the program i can sett running to false
        }

        sc.close();
    }

    public static void main(String[] args) throws UnknownHostException {
        //java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
        System.out.print("\nHello " + System.getProperty("user.name") + "!\n");
        planetSystemList.add(system);
        gameLoop();     // Runs the main loop for the program
    }
}

/*
TODO: make save to csv a class?
TODO: Store the systems in a ArrayList so i can have more systems?
TODO: Comment!!
 */