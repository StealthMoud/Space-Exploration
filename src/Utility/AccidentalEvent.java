package Utility;

import Entity.SpaceShip.SpaceShip;

import java.util.Random;

public class AccidentalEvent {

    private AccidentalEvent() {
        throw new IllegalStateException("Utility class - cannot be instantiated");
    }
    private static final Random random = new Random();

    public static <T extends SpaceShip> boolean applyRandomAccidentalEvent(T ship) {
        int eventType = random.nextInt(6);

        switch (eventType) {
            case 1:
                asteroidCollision(ship);
                return true;
            case 2:
                solarFlareDamage(ship);
                return true;

            case 3:
                navigationError(ship);
                return true;
            case 4:
                microMeteoroidImpact(ship);
                return true;
            case 5:
                engineMalfunction(ship);
                return true;
            default:
                return false;
        }
    }

    private static <T extends SpaceShip> void asteroidCollision(T ship) {
        System.out.println("WARNING: CATASTROPHIC ASTEROID COLLISION DETECTED!");

        int collisionSeverity = random.nextInt(100) + 1;

        if (collisionSeverity >= 90) {
            int damage = random.nextInt(50) + 50;
            ship.takeDamage(damage);
            System.out.println("CRITICAL DAMAGE! The asteroid impact has caused massive destruction!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (collisionSeverity >= 70) {
            int damage = random.nextInt(40) + 30;
            ship.takeDamage(damage);
            System.out.println("SIGNIFICANT DAMAGE! The asteroid impact has compromised ship " + ship.getName() + " systems!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (collisionSeverity >= 50) {

            int damage = random.nextInt(20) + 10;
            ship.takeDamage(damage);
            System.out.println("MINOR DAMAGE! The asteroid impact has caused minor hull damage.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else {
            System.out.println("NEAR MISS! The " + ship.getName() + " skillfully maneuvers, narrowly avoiding the asteroid.");
        }

    }




    private static <T extends SpaceShip> void solarFlareDamage(T ship) {
        System.out.println("WARNING: MASSIVE SOLAR FLARE DETECTED!");

        int flareSeverity = random.nextInt(100) + 1;

        if (flareSeverity >= 90) {
            int damage = random.nextInt(40) + 60;
            ship.takeDamage(damage);
                System.out.println("CATASTROPHIC DAMAGE! The " + ship.getName() + " is engulfed in searing solar flames!");
                System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (flareSeverity >= 70) {
            int damage = random.nextInt(30) + 30;
            ship.takeDamage(damage);
            System.out.println("SEVERE DAMAGE! The " + ship.getName() + "'s systems are under intense solar stress!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (flareSeverity >= 50) {
            int damage = random.nextInt(20) + 10;
            ship.takeDamage(damage);
            System.out.println("MODERATE DAMAGE! The " + ship.getName() + "'s shielding is strained by the solar flare.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else {
            System.out.println("MINOR DAMAGE! The " + ship.getName() + "'s shields hold against the solar flare's energy.");
        }

    }


    private static <T extends SpaceShip> void navigationError(T ship) {
        System.out.println("WARNING: CRITICAL NAVIGATION SYSTEM ERROR!");

        int errorSeverity = random.nextInt(100) + 1;

        if (errorSeverity >= 90) {
            int damage = random.nextInt(20) + 80;
            ship.takeDamage(damage);
            System.out.println("CATASTROPHIC DAMAGE! The " + ship.getName() + " spirals out of control!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (errorSeverity >= 70) {
            int damage = random.nextInt(20) + 40;
            ship.takeDamage(damage);
            System.out.println("SEVERE DAMAGE! The " + ship.getName() + " struggles to maintain course.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (errorSeverity >= 50) {
            int damage = random.nextInt(20) + 20;
            ship.takeDamage(damage);
            System.out.println("MODERATE DAMAGE! The " + ship.getName() + " experiences navigation disruptions.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else {
            System.out.println("MINOR DAMAGE! The " + ship.getName() + "'s systems quickly correct the navigation error.");
        }

    }

    private static <T extends SpaceShip> void microMeteoroidImpact(T ship) {
        System.out.println("WARNING: IMPACT ALERT - MICRO-METEOROID STRIKE!");

        int impactSeverity = random.nextInt(100) + 1;

        if (impactSeverity >= 90) {
            int damage = random.nextInt(20) + 80;
            ship.takeDamage(damage);
            System.out.println("CATASTROPHIC DAMAGE! The " + ship.getName() + "'s hull is breached!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (impactSeverity >= 70) {
            int damage = random.nextInt(20) + 40;
            ship.takeDamage(damage);
            System.out.println("SEVERE DAMAGE! The " + ship.getName() + "'s integrity is compromised.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (impactSeverity >= 50) {
            int damage = random.nextInt(20) + 20;
            ship.takeDamage(damage);
            System.out.println("MODERATE DAMAGE! The " + ship.getName() + "'s outer hull is compromised.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else {
            int damage = random.nextInt(10) + 1;
            ship.takeDamage(damage);
            System.out.println("MINOR DAMAGE! The " + ship.getName() + "'s shields absorb most of the impact.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the" + ship.getName() + ".");
        }

    }


    private static <T extends SpaceShip> void engineMalfunction(T ship) {
        System.out.println("ALERT: ENGINE MALFUNCTION DETECTED!");

        int malfunctionSeverity = random.nextInt(100) + 1;

        if (malfunctionSeverity >= 90) {
            int damage = random.nextInt(20) + 80;
            ship.takeDamage(damage);
            System.out.println("CATASTROPHIC MALFUNCTION! The " + ship.getName() + "'s engines have failed!");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (malfunctionSeverity >= 70) {
            int damage = random.nextInt(20) + 40;
            ship.takeDamage(damage);
            System.out.println("SEVERE MALFUNCTION! The " + ship.getName() + "'s engines are severely impaired.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else if (malfunctionSeverity >= 50) {
            int damage = random.nextInt(20) + 20;
            ship.takeDamage(damage);
            System.out.println("MODERATE MALFUNCTION! The " + ship.getName() + "'s engines are partially impaired.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        } else {
            int damage = random.nextInt(10) + 1;
            ship.takeDamage(damage);
            System.out.println("MINOR MALFUNCTION! The " + ship.getName() + "'s engines experience minor issues.");
            System.out.println("ALERT: Current health: " + ship.getHealth() + "%");
            System.out.println("Please repair the " + ship.getName() + ".");
        }

    }

}
