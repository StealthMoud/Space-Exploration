package Utility;

import Entity.SpaceShip.CargoShip;
import Entity.SpaceShip.ExplorerShip;
import Entity.SpaceShip.ScoutShip;
import Entity.SpaceShip.SpaceShip;

import java.text.DecimalFormat;

public class SpaceShipUtils {

    public static void displayCommonInfo(SpaceShip ship) {
        System.out.println("Name: " + ship.getName() + ".");
        System.out.println("Speed: " + ship.getSpeed() + " kilometers per hour.");
        System.out.println("Health: " + ship.getHealth() + "%.");
        System.out.println("Fuel Capacity: " + ship.getFuelCapacity() + " kg.");
        System.out.println("Current Fuel: " + ship.getCurrentFuel() + " kg.");
    }

    public static void displaySpecificInfo(SpaceShip ship) {
        if (ship instanceof ScoutShip scoutShip) {
            System.out.println("Number of Scanners: " + scoutShip.getNumScanners() + " scanners.");
            System.out.println("Is stealth mode on: " + scoutShip.isStealthMode());
        } else if (ship instanceof ExplorerShip) {
            System.out.println("Metal inventory: " + ExplorerShip.getMetalCollected());
            System.out.println("Mineral inventory: " + ExplorerShip.getMineralCollected());
            System.out.println("Gas inventory: " + ExplorerShip.getGasCollected());
            System.out.println("Energy inventory: " + ExplorerShip.getEnergyCollected());
        } else if (ship instanceof CargoShip cargoShip) {
            System.out.println("Metal tank: " + cargoShip.getMetalTank());
            System.out.println("Mineral tank: " + cargoShip.getMineralTank());
            System.out.println("Gas tank: " + cargoShip.getGasTank());
            System.out.println("Energy tank: " + cargoShip.getEnergyTank());
        }

    }

    public static void consumeFuelAndPrintInfo(SpaceShip spaceShip, double fuelConsumed, double hours, double minutes) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (fuelConsumed > spaceShip.getCurrentFuel()) {
            System.out.println("The total fuel is burned.");
            System.out.println("Using the emergency fuel. ");
        }
        spaceShip.setCurrentFuel((int) (spaceShip.getCurrentFuel() - fuelConsumed));
        System.out.println(spaceShip.getName() + " consumed fuel for exploring mission for " + hours + " hours and " + df.format(minutes) + " minutes");
        System.out.println("Fuel consumed: " + fuelConsumed + " kg.");
        System.out.println("Current fuel: " + spaceShip.getCurrentFuel() + " kg.");
    }
}

