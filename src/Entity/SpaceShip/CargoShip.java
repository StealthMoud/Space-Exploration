package Entity.SpaceShip;

import Utility.SpaceShipUtils;

public class CargoShip implements SpaceShip {
    protected String name;
    private final int speed;
    private int health;
    private final int fuelCapacity;
    private int currentFuel;

    private double metalTank;
    private double mineralTank;
    private double gasTank;
    private double energyTank;
    private static double durationForCargoShip;

    public CargoShip(String name) {
        this.name = name;
        this.speed = 5000;
        this.health = 100;
        this.fuelCapacity = 5000;
        this.currentFuel = fuelCapacity;
        this.metalTank = 0;
        this.mineralTank = 0;
        this.gasTank = 0;
        this.energyTank = 0;
    }
    public CargoShip(String name, int speed, int fuelCapacity) {
        this.name = name;
        this.speed = speed;
        this.health = 100;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;
        this.metalTank = 0;
        this.mineralTank = 0;
        this.gasTank = 0;
        this.energyTank = 0;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getMetalTank() {
        return metalTank;
    }

    public void setMetalTank(double metalTank) {
        this.metalTank = metalTank;
    }

    public double getMineralTank() {
        return mineralTank;
    }

    public void setMineralTank(double mineralTank) {
        this.mineralTank = mineralTank;
    }

    public double getGasTank() {
        return gasTank;
    }

    public void setGasTank(double gasTank) {
        this.gasTank = gasTank;
    }

    public double getEnergyTank() {
        return energyTank;
    }

    public void setEnergyTank(double energyTank) {
        this.energyTank = energyTank;
    }


    public double getDurationForCargoShip() {
        return durationForCargoShip;
    }

    public static void setDurationForCargoShip(double durationForCargoShip) {
        CargoShip.durationForCargoShip = durationForCargoShip;
    }

    @Override
    public void consumeFuel() {
        if (getCurrentFuel() > 0) {
            int fuelConsumed = (int) (getDurationForCargoShip() * getSpeed() * 0.01);

            double hours = (int) getDurationForCargoShip() ;
            double minutes = (getDurationForCargoShip()  - hours) * 60;

            SpaceShipUtils.consumeFuelAndPrintInfo(this, fuelConsumed, hours, minutes);
        } else {
            System.out.println(getName() + " has no fuel. Cannot consume fuel for exploring mission.");
        }
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}
