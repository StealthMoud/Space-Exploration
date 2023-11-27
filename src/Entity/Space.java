package Entity;

import Entity.CelestialBody.CelestialBody;
import Entity.CelestialBody.Planet;
import Entity.CelestialBody.Star;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Space {
    private static Space instance;
    private static CelestialBody[] celestialObjects;

    private static final List<CelestialBody> generatedObjectsList = new ArrayList<>();

    public static CelestialBody[] getCelestialObjects() {
        return celestialObjects;
    }

    public static List<CelestialBody> getGeneratedObjectsList() {
        return generatedObjectsList;
    }

    private Space() {

    }

    public static Space getInstance() {
        if (instance == null) {
            instance = new Space();
        }
        return instance;
    }

    public void createCelestialBodies() {
        int numDetectedObjects = (int) (Math.random() * 5) + 3;
        celestialObjects = new CelestialBody[numDetectedObjects];
        for (int i = 0; i < numDetectedObjects; i++) {
            celestialObjects[i] = generateRandomObjectType();
            generatedObjectsList.add(celestialObjects[i]);
        }
    }




    private CelestialBody generateRandomObjectType() {
        String[] objectTypes = {"Planet", "Star"};
        int randomIndex = (int) (Math.random() * objectTypes.length);

        if (objectTypes[randomIndex].equals("Planet")) {
            return new Planet();
        } else {
            return new Star();
        }
    }

    public static CelestialBody ScannedCelestialBody() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scanned Celestial Body:\n");

            for (int i = 0; i < getGeneratedObjectsList().size(); i++) {
                System.out.println((i + 1) + ". " + getGeneratedObjectsList().get(i).getInformation());
            }

            System.out.print("\nChoose a celestial body to explore: ");

            try {
                int chosenNumber = scanner.nextInt();
                if (chosenNumber >= 1 && chosenNumber <= getGeneratedObjectsList().size()) {
                    return getGeneratedObjectsList().get(chosenNumber - 1);
                } else {
                    System.out.println("Invalid selection. Please choose a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

}
