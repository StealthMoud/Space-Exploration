package Entity.CelestialBody;

import java.util.*;
import java.util.stream.Collectors;

public class Planet extends CelestialBody {
    private final double mineralResource;
    private final double metalResource;
    private static final Set<String> usedNames = new HashSet<>();

    public Planet() {
        Random random = new Random();
        this.mineralResource = random.nextDouble() * 1000.0;
        this.metalResource = random.nextDouble() * 500.0;
    }

    public double getMineralResource() {
        return mineralResource;
    }

    public double getMetalResource() {
        return metalResource;
    }


    @Override
    public String getInformation() {
        return "Planet: \n" +
                "Name: " + getName() + "\n" +
                "Mass: " + String.format("%.2f", getMass()) + " kg\n" +
                "Diameter: " + String.format("%.2f", getDiameter()) + " km\n" +
                "Radius: " + String.format("%.2f", getRadius()) + " km\n" +
                "Distance:" + String.format("%.2f", getDistanceInKilometers()) + " km\n" +
                "Mineral Resource: " + String.format("%.2f", getMineralResource()) + " kg\n" +
                "Metal Resource: " + String.format("%.2f", getMetalResource()) + " kg\n";
    }


    @Override
    public String generateRandomName() {
        String[] planetNames = {
                "Mercury",
                "Venus",
                "Earth",
                "Mars",
                "Jupiter",
                "Saturn",
                "Uranus",
                "Neptune",
                "Pluto",
                "Eris",
                "Haumea",
                "Makemake",
                "Ceres",
                "Io",
                "Europa",
                "Ganymede",
                "Callisto",
                "Titan",
                "Enceladus",
                "Triton",
                "Oberon",
                "Ariel",
                "Charon",
                "Deimos",
                "Phobos",
                "Mimas",
                "Dione",
                "Rhea",
                "Hyperion",
                "Iapetus",
                "Miranda",
                "Tethys",
                "Proteus",
                "Umbriel",
                "Calypso",
                "Janus",
                "Pandora",
                "Atlas",
                "Prometheus"
        };


        return getString(planetNames, usedNames);
    }

    static String getString(String[] planetNames, Set<String> usedNames) {
        List<String> availableNames = Arrays.stream(planetNames)
                .filter(name -> !usedNames.contains(name))
                .collect(Collectors.toList());

        if (availableNames.isEmpty()) {
            usedNames.clear();
            availableNames.addAll(Arrays.asList(planetNames));
        }

        int randomIndex = new Random().nextInt(availableNames.size());
        String selectedName = availableNames.get(randomIndex);

        usedNames.add(selectedName);

        return selectedName;
    }

    public void celestialBodyAtmosphere() {
        Random random = new Random();

        int minTemperature = -200;
        int maxTemperature = 1000;
        int planetTemperatureInCelsius = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;

        System.out.println("The " + getName() + " planet has a surface temperature of " + planetTemperatureInCelsius + " degrees Celsius!");

        String planetType;
        if (planetTemperatureInCelsius < -100) {
            planetType = "Frozen Ice Planet";
        } else if (planetTemperatureInCelsius < 100) {
            planetType = "Temperate Earth-like Planet";
        } else {
            planetType = "Scorching Desert Planet";
        }

        System.out.println("Planet Type: " + planetType);

        String temperatureDescription;
        if (planetTemperatureInCelsius < -100) {
            temperatureDescription = "This frozen ice planet is a realm of perpetual snow and ice, where life finds a way to thrive in extreme conditions.";
        } else if (planetTemperatureInCelsius < 100) {
            temperatureDescription = "An Earth-like planet with a temperate climate, this world is teeming with diverse ecosystems and vibrant landscapes.";
        } else {
            temperatureDescription = "A scorching desert planet where searing temperatures dominate the landscape, challenging the hardiest of life forms.";
        }

        System.out.println("Temperature description: " + temperatureDescription);
    }

    @Override
    public void calculateTimeDilation() {
        double calculateTimeDilationOnThePlanet = Math.sqrt(1.0 - 2.0 * CelestialBody.G * CelestialBody.getMass() / (CelestialBody.getRadius() * (c * c)));
        System.out.println("Time Dilation on the surface of the " + getName() + " planet: " + calculateTimeDilationOnThePlanet);
        System.out.println("It means that for one second that passes here, "+ calculateTimeDilationOnThePlanet + " seconds will pass"
                + " on the " + getName() + ".");
        System.out.println("and for one minute that passes here , "+ calculateTimeDilationOnThePlanet * 60 + " seconds will pass"
                + " on the " + getName() + ".");
    }


}
