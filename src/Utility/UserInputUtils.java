package Utility;

import java.util.Scanner;

public class UserInputUtils {

    public static void waitForC(Scanner scanner) {
        System.out.println("\n\nPlease press 'C' to continue...");
        while (true) {
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("C")) {
                break;
            } else {
                System.out.println("Please press 'C' to continue...");
            }
        }
    }

    public static int getInputWithDefault(Scanner scanner, String parameter, String prompt, int defaultValue) {
        boolean validInput = false;
        int customValue = defaultValue;

        while (!validInput) {
            System.out.print(prompt);
            String userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                validInput = true;
            } else {
                try {
                    customValue = Integer.parseInt(userInput);
                    if (customValue <= 0) {
                        System.out.println(parameter + " cannot be negative. Please enter a valid value.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid " + parameter + " format. Please enter a valid number or leave it empty for the default.");
                }
            }
        }

        return customValue;
    }
}
