package Entity.CelestialBody;

import java.util.Random;

public abstract class CelestialBody {
    public static final double G = 6.67430e-11;  // Gravitational constant (m^3/kg/s^2)
    public static final double c = 299792458;  // Speed of light (m/s)
    static Random rand = new Random();
    private final String name;
    private static double mass;
    private final double diameter;
    private static double radius;

    private final double distanceInKilometers = rand.nextDouble() * 150000.0 + 10000;

    public CelestialBody() {
        this.name = generateRandomName();
        mass = rand.nextDouble() * 1.0e30;
        this.diameter = rand.nextDouble() * 1.0e8;
        radius = diameter/2.0;
    }

    public String getName() {
        return name;
    }

    public static double getMass() {
        return mass;
    }

    public double getDiameter() {
        return diameter;
    }

    public static double getRadius() {
        return radius;
    }

    public double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public abstract String generateRandomName();

    public abstract String getInformation();

    public abstract void celestialBodyAtmosphere();

    public abstract void calculateTimeDilation();



}
