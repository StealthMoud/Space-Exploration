package Utility;

import Entity.CelestialBody.CelestialBody;
import Entity.SpaceShip.ExplorerShip;
import Entity.SpaceShip.ScoutShip;
import Entity.SpaceShip.SpaceShip;

public class TimeDurationCalculator {
    public static double calculateDuration(SpaceShip spaceShip, CelestialBody[] celestialBodies) {
        double speed = spaceShip.getSpeed();
        double specificMultiplier = 1.0;

        if (spaceShip instanceof ScoutShip) {
            specificMultiplier = 0.5;
            double totalDistance = 0.0;
            for (CelestialBody body : celestialBodies) {
                totalDistance += body.getDistanceInKilometers();
            }
            return (totalDistance / speed) * specificMultiplier;
        } else if (spaceShip instanceof ExplorerShip) {
            specificMultiplier = 1.5;
        }

        if (celestialBodies.length > 0) {
            CelestialBody firstBody = celestialBodies[0];
            double distanceInKilometers = firstBody.getDistanceInKilometers();
            return (distanceInKilometers / speed) * specificMultiplier;
        } else {
            return 0.0;
        }
    }
}


