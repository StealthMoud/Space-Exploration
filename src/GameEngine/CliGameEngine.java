package GameEngine;

import Entity.CelestialBody.CelestialBody;
import Entity.Space;
import Entity.SpaceShip.CargoShip;
import Entity.SpaceShip.ExplorerShip;
import Entity.SpaceShip.ScoutShip;
import Entity.SpaceShip.SpaceShip;
import Factory.SpaceShipFactory;
import Utility.SpaceShipUtils;
import Utility.TimeDurationCalculator;

import java.util.Scanner;

import static Entity.Space.ScannedCelestialBody;
import static Entity.SpaceShip.ExplorerShip.collectResourcesFromCelestialBody;
import static Utility.AccidentalEvent.applyRandomAccidentalEvent;
import static Utility.DamageRepairSystem.repairDamage;
import static Utility.UserInputUtils.waitForC;

public class CliGameEngine extends GameEngine {
    public CliGameEngine() { }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void startGameEngine() {
        System.out.println("Welcome to the Space Exploration Game!");
        System.out.println("Please read the follow-up instructions carefully...\n");
        waitForC(scanner);
        System.out.println("Right now you are in the International Space Station!");
        System.out.println("You have three different types of space ships.");
        System.out.println("Scout-ship, Explorer-ship and Cargo-ship.\n");
        waitForC(scanner);
        System.out.println("Firstly, you are going to use one of the scout ships, navigate remotely and scan surrounding quickly");
        System.out.println("You are going to find some celestial bodies with powerful scanners which is implemented inside your scouting ship,\n");
        System.out.println("and report their Specifications.");
        waitForC(scanner);
        System.out.println("Then, you will start your exciting journey with one of the explorer ships. ");
        System.out.println("By the way, at the same time you are going start one of the Cargo ships and navigate that remotely");
        System.out.println("when you get on the explorer ship, you need to choose one of these scanned celestial bodies.");
        System.out.println("Every celestial body has its own resources.");
        System.out.println("For example: planets have Mineral and Metal resources, and Stars have Gas and Energy resources.\n");
        waitForC(scanner);
        System.out.println("According to every celestial body type, you will collect the collectable amount of resources ");
        System.out.println("and keep them individually inside the temporary tanks.");
        System.out.println("You will transfer those resources inside the Cargo-Ship's tanks and both come back at home.\n");
        waitForC(scanner);
        System.out.println("Now let's start our exciting journey...");
        System.out.println("So, set back and grab a cup of coffee...\n");
        waitForC(scanner);

        System.out.println("Now we are launching our scouting mission...");
        SpaceShipFactory spaceShipFactory = new SpaceShipFactory();
        SpaceShip selectedScoutShip = spaceShipFactory.getSpaceShips("SCOUT-SHIP");
        System.out.println("Scout ship information:");
        SpaceShipUtils.displayCommonInfo(selectedScoutShip);
        SpaceShipUtils.displaySpecificInfo(selectedScoutShip);
        System.out.println("\nLet's start the scouting mission...");
        waitForC(scanner);
        ScoutShip.enableStealthMode();
        ScoutShip.performScanning();
        boolean accidentalEventOccurredOnScoutShip = applyRandomAccidentalEvent(selectedScoutShip);
        waitForC(scanner);
        if (accidentalEventOccurredOnScoutShip) {
            repairDamage(selectedScoutShip);
        }
        waitForC(scanner);
        double TimeDurationForScoutShip = TimeDurationCalculator.calculateDuration(selectedScoutShip, Space.getCelestialObjects());
        ScoutShip.setDurationForScoutShip(TimeDurationForScoutShip);
        selectedScoutShip.consumeFuel();
        waitForC(scanner);
        ScoutShip.disableStealthMode();
        System.out.println("Scouting mission completed.");
        waitForC(scanner);


        System.out.println("""

                Now let's go ahead and choose the Explorer ship and the cargo ship, and then explore
                one of the scanned celestial bodies.""");
        waitForC(scanner);
        System.out.println("we are launching our exploration mission...");
        System.out.println("First, let's choose our explorer ship.\n");
        SpaceShip selectedExplorerShip = spaceShipFactory.getSpaceShips("EXPLORER-SHIP");
        System.out.println("Explorer Ship information:");
        SpaceShipUtils.displayCommonInfo(selectedExplorerShip);
        SpaceShipUtils.displaySpecificInfo(selectedExplorerShip);
        System.out.println("""
                
                Now it's time to choose our cargo ship.
                """);
        waitForC(scanner);
        SpaceShip selectedCargoShip = spaceShipFactory.getSpaceShips("CARGO-SHIP");
        System.out.println("Cargo Ship information:");
        SpaceShipUtils.displayCommonInfo(selectedCargoShip);
        SpaceShipUtils.displaySpecificInfo(selectedCargoShip);
        System.out.println("""

                let's go and check the list of scanned celestial body
                and choose one of them.""");
        waitForC(scanner);
        CelestialBody selectedScannedCelestialBody = ScannedCelestialBody();
        System.out.println("You successfully selected the " + selectedScannedCelestialBody.getName() + " celestial body to explore.");
        System.out.println("the " + selectedExplorerShip.getName() + " will go first and collect the collectable resources of " + selectedScannedCelestialBody.getName());
        System.out.println("while the " + selectedCargoShip.getName() + " will wait near the " + selectedScannedCelestialBody.getName() +
                " to receive the collected resources from " + selectedExplorerShip.getName() + ".") ;
        waitForC(scanner);
        selectedScannedCelestialBody.celestialBodyAtmosphere();
        waitForC(scanner);
        selectedScannedCelestialBody.calculateTimeDilation();
        waitForC(scanner);
        collectResourcesFromCelestialBody(selectedScannedCelestialBody);
        waitForC(scanner);
        boolean accidentalEventOccurredOnExplorerShip = applyRandomAccidentalEvent(selectedExplorerShip);
        waitForC(scanner);
        if (accidentalEventOccurredOnExplorerShip) {
            repairDamage(selectedExplorerShip);
        }
        waitForC(scanner);
        System.out.println("the " + selectedExplorerShip.getName() + " successfully come back form the " + selectedScannedCelestialBody.getName()
        + ".");
        System.out.println("let's transfer the collected resources to " + selectedCargoShip.getName() + ".");
        waitForC(scanner);
        ExplorerShip explorerShip = new ExplorerShip();
        explorerShip.transferResourcesToCargoShip((ExplorerShip) selectedExplorerShip, (CargoShip) selectedCargoShip);
        waitForC(scanner);
        boolean accidentalEventOccurredOnCargoShip = applyRandomAccidentalEvent(selectedCargoShip);
        waitForC(scanner);
        if (accidentalEventOccurredOnCargoShip) {
            repairDamage(selectedCargoShip);
        }
        waitForC(scanner);
        double TimeDurationForExplorerShip = TimeDurationCalculator.calculateDuration(selectedExplorerShip, Space.getCelestialObjects());
        ExplorerShip.setDurationForExplorerShip(TimeDurationForExplorerShip);
        selectedExplorerShip.consumeFuel();
        waitForC(scanner);
        double TimeDurationForCargoShip = TimeDurationCalculator.calculateDuration(selectedCargoShip, Space.getCelestialObjects());
        CargoShip.setDurationForCargoShip(TimeDurationForCargoShip);
        selectedCargoShip.consumeFuel();
        System.out.println("the " + selectedExplorerShip.getName() + " and " + selectedCargoShip.getName() + " has completed their exploring mission\n" +
                "and come back to the International Space Station.\n");
        System.out.println("Congratulations! You've completed your space exploration journey.");
        System.out.println("Thank you for playing the Space Exploration Game!");
    }
}
