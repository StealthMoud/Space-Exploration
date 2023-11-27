package Entity.SpaceShip;

import Entity.CelestialBody.CelestialBody;
import Entity.Space;
import Utility.SpaceShipUtils;

import java.util.Random;
import java.util.Scanner;

import static Utility.UserInputUtils.waitForC;

public class ScoutShip implements SpaceShip {
    protected String name;
    private final int speed;
    private static int health;
    private final int fuelCapacity;
    private int currentFuel;
    private static boolean stealthMode;
    static Random random = new Random();
    private static double durationForScoutShip;



    private static final int numScanners = random.nextInt(5) + 1;
    public ScoutShip(String name) {
        this.name = name;
        speed = 15000;
        health = 100;
        fuelCapacity = 3700;
        this.currentFuel = fuelCapacity;
        stealthMode = false;
    }

    public ScoutShip(String name, int speed, int fuelCapacity) {
        this.name = name;
        this.speed = speed;
        health = 100;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;
        stealthMode = false;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        ScoutShip.health = health;
    }
    @Override
    public int getFuelCapacity() {
        return fuelCapacity;
    }
    @Override
    public int getCurrentFuel() {
        return currentFuel;
    }

    @Override
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }


    public static double getDurationForScoutShip() {
        return durationForScoutShip;
    }

    public static void setDurationForScoutShip(double durationForScoutShip) {
        ScoutShip.durationForScoutShip = durationForScoutShip;
    }

    public boolean isStealthMode() {
        return stealthMode;
    }

    public int getNumScanners() {
        return numScanners;
    }

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public static void enableStealthMode() {
        if (!stealthMode) {
            stealthMode = true;
            System.out.println("\nScout ship has entered stealth mode.");
        } else {
            System.out.println("Scout ship is already in stealth mode.");
        }
    }

    public static void performScanning() {
        System.out.println("Scout ship is performing scans using " + numScanners + " scanners.\n");
        waitForC(scanner);

        if (numScanners > 0) {

            for (int i = 0; i < numScanners; i++) {
                scanNearbyObjects(i);
                waitForC(scanner);
            }
        }
    }


    private static void scanNearbyObjects(int scannerIndex) {

        Space space = Space.getInstance();
        space.createCelestialBodies();

        CelestialBody[] celestialBodies = Space.getCelestialObjects();

        System.out.println("Scanner " + (scannerIndex + 1) + " is active and scanning for nearby objects...");

        System.out.println("Scanner " + (scannerIndex + 1) + " Detected " + celestialBodies.length + " objects.\n");

        for (int i = 0; i < celestialBodies.length; i++) {
            CelestialBody objectType = celestialBodies[i];

            System.out.println((i + 1) + ". " + objectType.getInformation() + "\n");

        }
        System.out.println("Scan operation of scanner " + (scannerIndex + 1) + " is completed.\n");
    }


    @Override
    public void consumeFuel() {
        if (getCurrentFuel() > 0) {
            int fuelConsumed = (int) (getDurationForScoutShip() * getSpeed() * 0.01);


            int hours = (int) getDurationForScoutShip();
            double minutes = (getDurationForScoutShip() - hours) * 60;

            SpaceShipUtils.consumeFuelAndPrintInfo(this, fuelConsumed, hours, minutes);
        } else {
            System.out.println(getName() + " has no fuel. Cannot consume fuel for scouting mission.");
        }
    }


    public static void disableStealthMode() {
        if (stealthMode) {
            stealthMode = false;
            System.out.println("Scout ship has exited stealth mode.");
        } else {
            System.out.println("Scout ship is not in stealth mode.");
        }
    }


}
