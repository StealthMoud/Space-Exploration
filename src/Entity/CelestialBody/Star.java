package Entity.CelestialBody;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static Entity.CelestialBody.Planet.getString;

public class Star extends CelestialBody {
    private final double gasResource;
    private final double energyResource;

    private static final Set<String> usedNames = new HashSet<>();
    public Star() {
        Random random = new Random();
        this.gasResource = random.nextDouble() * 1000.0;
        this.energyResource = random.nextDouble() * 500.0;
    }

    public double getGasResource() {
        return gasResource;
    }
    public double getEnergyResource() {
        return energyResource;
    }

    @Override
    public String getInformation() {
        return "Star: \n" +
                "Name: " + getName() + "\n" +
                "Mass: " + String.format("%.2f", getMass()) + " kg\n" +
                "Diameter: " + String.format("%.2f", getDiameter()) + " km\n" +
                "Radius: " + String.format("%.2f", getRadius()) + " km\n" +
                "Distance: " + String.format("%.2f", getDistanceInKilometers()) + " km\n" +
                "Gas Resource: " + String.format("%.2f", getGasResource()) + " m^3\n" +
                "Energy Resource: " + String.format("%.2f", getEnergyResource()) + " MJ\n";
    }





    public String generateRandomName() {
        String[] starNames = {
                "Sirius",
                "Betelgeuse",
                "Vega",
                "Proxima Centauri",
                "Antares",
                "Altair",
                "Polaris",
                "Deneb",
                "Aldebaran",
                "Rigel",
                "Regulus",
                "Spica",
                "Arcturus",
                "Albireo",
                "Castor",
                "Pollux",
                "Fomalhaut",
                "Bellatrix",
                "Alpheratz",
                "Mirach",
                "Capella",
                "Achernar",
                "Rigil Kentaurus",
                "Dubhe",
                "Gacrux",
                "Menkalinan",
                "Mizar",
                "Diphda",
                "Hamal",
                "Algol",
                "Mintaka",
                "Meissa",
                "Thuban",
                "Alrescha",
                "Kaus Australis",
                "Enif",
                "Alshain",
                "Nashira",
                "Zaurak"
        };


        return getString(starNames, usedNames);
    }

    @Override
    public void celestialBodyAtmosphere() {
        Random random = new Random();

        int minTemperature = 2000;
        int maxTemperature = 20000;
        int starTemperatureInFahrenheit = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;

        System.out.println("The " + getName() + " star has a surface temperature of " + starTemperatureInFahrenheit + " degrees Fahrenheit!");

        String starType;
        if (starTemperatureInFahrenheit < 3500) {
            starType = "Cool Red Star";
        } else if (starTemperatureInFahrenheit < 6000) {
            starType = "Yellow Dwarf Star";
        } else {
            starType = "Hot Blue Star";
        }

        System.out.println("Star Type: " + starType);

        int objectLuminosityInLumens = starTemperatureInFahrenheit * 100;
        System.out.println("Luminosity: " + objectLuminosityInLumens + " lumens");

        String temperatureDescription;
        if (starTemperatureInFahrenheit < 3500) {
            temperatureDescription = "This star has a relatively low surface temperature, emitting a dim reddish light.";
        } else if (starTemperatureInFahrenheit < 6000) {
            temperatureDescription = "With a moderate surface temperature, this star shines with a bright, yellowish-white light.";
        } else {
            temperatureDescription = "This star boasts a scorching surface temperature, radiating a brilliant blue-white light.";
        }

        System.out.println("Temperature description: " + temperatureDescription);

    }

    @Override
    public void calculateTimeDilation() {
        double calculateTimeDilationOnTheStar = Math.sqrt(1.0 - 2.0 * CelestialBody.G * CelestialBody.getMass() / (CelestialBody.getRadius() * (c * c)));
        System.out.println("Time Dilation near the " + getName() + " star: " + calculateTimeDilationOnTheStar);
        System.out.println("It means that for one second that passes here , "+ calculateTimeDilationOnTheStar + " seconds will pass"
        + " on the " + getName() + ".");
        System.out.println("and for one minute that passes here , "+ calculateTimeDilationOnTheStar * 60 + " seconds will pass"
                + " on the " + getName() + ".");

    }


}
