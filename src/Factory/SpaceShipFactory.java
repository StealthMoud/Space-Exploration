package Factory;

import Entity.SpaceShip.CargoShip;
import Entity.SpaceShip.ExplorerShip;
import Entity.SpaceShip.ScoutShip;
import Entity.SpaceShip.SpaceShip;

import java.util.Scanner;

import static Utility.UserInputUtils.getInputWithDefault;

public class SpaceShipFactory {
    private final Scanner scanner = new Scanner(System.in);
    private static final String[] SCOUT_SHIP_NAMES = {
            "Scout-Alpha", "Scout-Beta", "Scout-Gamma", "Scout-Delta", "Scout-Epsilon"
    };

    private static final String[] EXPLORER_SHIP_NAMES = {
            "Explorer-Alpha", "Explorer-Beta", "Explorer-Gamma", "Explorer-Delta", "Explorer-Epsilon"
    };

    private static final String[] CARGO_SHIP_NAMES = {
            "Cargo-Alpha", "Cargo-Beta", "Cargo-Gamma", "Cargo-Delta", "Cargo-Epsilon"
    };

    public SpaceShip getSpaceShips(String spaceShipType) {
        System.out.println("Do you want to create a custom " + spaceShipType + " or choose from predefined options?");
        System.out.print("Enter 'custom' for custom ship or 'predefined' for predefined ships: ");


        while (true) {
            String choice = scanner.nextLine().trim();
            if (spaceShipType.equalsIgnoreCase("SCOUT-SHIP")) {

                if (choice.equalsIgnoreCase("custom")) {
                    SpaceShip customScoutShip = createScoutShipWithUserInput();
                    System.out.println("You selected custom ship: " + spaceShipType);
                    return customScoutShip;
                } else if (choice.equalsIgnoreCase("predefined")) {
                    SpaceShip[] createdScoutShips = createScoutShips();
                    return getSpaceShip(createdScoutShips);
                } else {
                    System.out.println("Invalid choice. Please enter 'custom' or 'predefined'.");
                }
            } else if (spaceShipType.equalsIgnoreCase("EXPLORER-SHIP")) {

                if (choice.equalsIgnoreCase("custom")) {
                    SpaceShip customExplorerShip = createExplorerShipWithUserInput();
                    System.out.println("You selected custom ship: " + spaceShipType);
                    return customExplorerShip;
                } else if (choice.equalsIgnoreCase("predefined")) {
                    SpaceShip[] createdExplorerShips = createExplorerShips();
                    return getSpaceShip(createdExplorerShips);
                } else {
                    System.out.println("Invalid choice. Please enter 'custom' or 'predefined'.");
                }

            } else if (spaceShipType.equalsIgnoreCase("CARGO-SHIP")) {

                if (choice.equalsIgnoreCase("custom")) {
                    SpaceShip customCargoShip = createCargoShipWithUserInput();
                    System.out.println("You selected custom ship: " + spaceShipType);
                    return customCargoShip;
                } else if (choice.equalsIgnoreCase("predefined")) {
                    SpaceShip[] createdCargoShips = createCargoShips();
                    return getSpaceShip(createdCargoShips);
                } else {
                    System.out.println("Invalid choice. Please enter 'custom' or 'predefined'.");
                }
            }


        }
    }

    private SpaceShip getSpaceShip(SpaceShip[] createdSpaceShips) {
        String chosenSpaceShipName;
        for (int i = 0; i < createdSpaceShips.length; i++) {
            System.out.println((i + 1) + ". " + createdSpaceShips[i].getName());
        }

        while (true) {
            try {
                String userInput = scanner.nextLine().trim();
                int chosenNumber = Integer.parseInt(userInput);

                if (chosenNumber >= 1 && chosenNumber <= createdSpaceShips.length) {
                    chosenSpaceShipName = createdSpaceShips[chosenNumber - 1].getName();
                    System.out.println("You selected: " + chosenSpaceShipName);
                    return createdSpaceShips[chosenNumber - 1];
                } else {
                    System.out.println("Invalid selection. Please choose a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    public SpaceShip[] createScoutShips() {
        SpaceShip[] scoutShips = new SpaceShip[SCOUT_SHIP_NAMES.length];
        for (int i = 0; i < SCOUT_SHIP_NAMES.length; i++) {
            ScoutShip scoutShip = new ScoutShip(SCOUT_SHIP_NAMES[i]);
            scoutShip.setName(SCOUT_SHIP_NAMES[i]);
            scoutShips[i] = scoutShip;
        }
        return scoutShips;
    }

    public SpaceShip createScoutShipWithUserInput() {
        int customSpeed;
        int customFuelCapacity;
        System.out.print("Enter a name for your Scout Ship: ");
        String customName = scanner.nextLine().trim();

        customSpeed = getInputWithDefault(scanner, "speed", "Enter the speed for your Scout Ship or leave it empty for the default. (default: 15000): ", 15000);
        customFuelCapacity = getInputWithDefault(scanner, "fuel capacity", "Enter the fuel capacity for your Scout Ship or leave it empty for the default (default: 3700): ", 3700);

        return new ScoutShip(customName, customSpeed, customFuelCapacity);
    }


    public SpaceShip[] createExplorerShips() {
        SpaceShip[] explorerShips = new SpaceShip[EXPLORER_SHIP_NAMES.length];
        for (int i = 0; i < EXPLORER_SHIP_NAMES.length; i++) {
            ExplorerShip explorerShip = new ExplorerShip(EXPLORER_SHIP_NAMES[i]);
            explorerShip.setName(EXPLORER_SHIP_NAMES[i]);
            explorerShips[i] = explorerShip;
        }
        return explorerShips;
    }

    public SpaceShip createExplorerShipWithUserInput() {
        String customName;
        int customSpeed;
        int customFuelCapacity;
        System.out.print("Enter the name for your Explorer Ship: ");
        customName = scanner.nextLine().trim();

        customSpeed = getInputWithDefault(scanner, "speed", "Enter the speed for your Explorer Ship or leave it empty for the default. (default: 5000):", 5000);
        customFuelCapacity = getInputWithDefault(scanner, "fuel capacity", "Enter the fuel capacity for your Explorer Ship or leave it empty for the default. (default: 2000):", 2000);

        return new ExplorerShip(customName, customSpeed, customFuelCapacity);
    }

    public SpaceShip[] createCargoShips() {
        SpaceShip[] cargoShips = new SpaceShip[CARGO_SHIP_NAMES.length];
        for (int i = 0; i < CARGO_SHIP_NAMES.length; i++) {
            CargoShip cargoShip = new CargoShip(CARGO_SHIP_NAMES[i]);
            cargoShip.setName(CARGO_SHIP_NAMES[i]);
            cargoShips[i] = cargoShip;
        }
        return cargoShips;
    }

    public SpaceShip createCargoShipWithUserInput() {
        String customName;
        int customSpeed;
        int customFuelCapacity;
        System.out.print("Enter the name for your Cargo Ship: ");
        customName = scanner.nextLine().trim();

        customSpeed = getInputWithDefault(scanner,"speed", "Enter the speed for your Explorer Ship or leave it empty for the default. (default: 5000):", 5000);
        customFuelCapacity = getInputWithDefault(scanner, "fuel capacity", "Enter the fuel capacity for your Cargo Ship or leave it empty for the default. (default: 5000): ", 5000);
        return new CargoShip(customName, customSpeed, customFuelCapacity);
    }


}
