package Entity.SpaceShip;


public interface SpaceShip {
    String getName();
    int getSpeed();
    int getHealth();
    void setHealth(int health);
    int getFuelCapacity();
    int getCurrentFuel();
    void setCurrentFuel(int currentFuel);

    void consumeFuel();

    void takeDamage(int damage);
}
