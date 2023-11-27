package Entity.SpaceShip;

import Entity.CelestialBody.CelestialBody;
import Entity.CelestialBody.Planet;
import Entity.CelestialBody.Star;
import Utility.ResourceTransferable;
import Utility.SpaceShipUtils;



public class ExplorerShip implements SpaceShip, ResourceTransferable{
    protected String name;
    private int speed;
    private int health;
    private  int fuelCapacity;
    private int currentFuel;
    private static double metalCollected = 0;
    private static double mineralCollected = 0;
    private static double gasCollected = 0;
    private static double energyCollected = 0;
    private static   double durationForExplorerShip ;

    public ExplorerShip(String name) {
        this.name = name;
        this.speed = 5000;
        this.health = 100;
        this.fuelCapacity = 2000;
        this.currentFuel = fuelCapacity;
    }

    public ExplorerShip(String name, int speed, int fuelCapacity) {
        this.name = name;
        this.speed = speed;
        this.health = 100;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;
    }

    public ExplorerShip() {}


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
        this.health = health;
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

    public static double getDurationForExplorerShip() {
        return durationForExplorerShip;
    }

    public static void setDurationForExplorerShip(double durationForExplorerShip) {
        ExplorerShip.durationForExplorerShip = durationForExplorerShip;
    }

    public static double getMetalCollected() {
        return metalCollected;
    }

    public static void setMetalCollected(double metalCollected) {
        ExplorerShip.metalCollected = metalCollected;
    }

    public static double getMineralCollected() {
        return mineralCollected;
    }

    public static void setMineralCollected(double mineralCollected) {
        ExplorerShip.mineralCollected = mineralCollected;
    }

    public static double getGasCollected() {
        return gasCollected;
    }

    public static void setGasCollected(double gasCollected) {
        ExplorerShip.gasCollected = gasCollected;
    }

    public static double getEnergyCollected() {
        return energyCollected;
    }

    public static void setEnergyCollected(double energyCollected) {
        ExplorerShip.energyCollected = energyCollected;
    }


    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }


    public static void collectResourcesFromCelestialBody(CelestialBody celestialBody) {
        if (celestialBody instanceof Planet planet) {
            double metalResource = planet.getMetalResource();
            double mineralResource = planet.getMineralResource();
            setMetalCollected(getMetalCollected() + metalResource);
            setMineralCollected(getMineralCollected() + mineralResource);

            System.out.println("""
                    we successfully explored this celestial body
                    Below is the report:
                    """);
            System.out.println("Collected resources from a planet:");
            System.out.println("Metal collected: " + metalResource);
            System.out.println("Mineral collected: " + mineralResource);
        } else if (celestialBody instanceof Star star) {
            double gasResource = star.getGasResource();
            double energyResource = star.getEnergyResource();
            setGasCollected(getGasCollected() + gasResource);
            setEnergyCollected(getEnergyCollected() + energyResource);

            System.out.println("""
                    we successfully explored this celestial body
                    Below is the report:
                    """);
            System.out.println("Collected resources from a star:");
            System.out.println("Gas collected: " + gasResource);
            System.out.println("Energy collected: " + energyResource);
        }

    }

    @Override
    public void consumeFuel() {
        if (getCurrentFuel() > 0) {
            int fuelConsumed = (int) (getDurationForExplorerShip() * getSpeed() * 0.01);

            double hours = (int) getDurationForExplorerShip() ;
            double minutes = (getDurationForExplorerShip()  - hours) * 60;

            SpaceShipUtils.consumeFuelAndPrintInfo(this, fuelConsumed, hours, minutes);
        } else {
            System.out.println(getName() + " has no fuel. Cannot consume fuel for exploring mission.");
        }
    }

    @Override
    public void transferResourcesToCargoShip(ExplorerShip explorerShip, CargoShip cargoShip) {
        if (cargoShip != null) {
            cargoShip.setMetalTank(getMetalCollected());
            cargoShip.setMineralTank(getMineralCollected());
            cargoShip.setGasTank(getGasCollected());
            cargoShip.setEnergyTank(getEnergyCollected());

            setMetalCollected(0);
            setMineralCollected(0);
            setGasCollected(0);
            setEnergyCollected(0);
            reportResourceTransfer(explorerShip, cargoShip);
        } else {
            System.out.println("Cannot transfer resources. No cargo ship assigned to this explorer ship.");
        }
    }

    public void reportResourceTransfer(ExplorerShip explorerShip, CargoShip cargoShip) {
        System.out.println("Transferred resources report:");
        System.out.println("Metal transferred: " + cargoShip.getMetalTank());
        System.out.println("Mineral transferred: " + cargoShip.getMineralTank());
        System.out.println("Gas transferred: " + cargoShip.getGasTank());
        System.out.println("Energy transferred: " + cargoShip.getEnergyTank());
        System.out.println("Transferred successfully from " + explorerShip.getName() + " to " + cargoShip.getName() + ".\n");
    }


}
