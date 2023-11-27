package Utility;

import Entity.SpaceShip.SpaceShip;

public class DamageRepairSystem {
    private DamageRepairSystem() {
        throw new IllegalStateException("Utility class - cannot be instantiated");
    }


    public static void repairDamage(SpaceShip ship) {
        int health = ship.getHealth();
        if (health < 100) {
            int repairAmount = 100 - health;
            int setHealth = Math.min(100, health + repairAmount);
            ship.setHealth(setHealth);
            System.out.println("Damage Repair System has repaired the " + ship.getName() + " health by " + repairAmount + "%.");
            System.out.println("Current health:" + ship.getHealth() + "%");
            System.out.println("You successfully repaired the " + ship.getName() + ".");
        } else {
            System.out.println("No repair needed. " + ship.getName() + " health is already at 100%.");
        }
    }
}