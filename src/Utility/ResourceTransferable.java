package Utility;

import Entity.SpaceShip.CargoShip;
import Entity.SpaceShip.ExplorerShip;
@FunctionalInterface
public interface ResourceTransferable {
    void transferResourcesToCargoShip(ExplorerShip explorerShip, CargoShip cargoShip);
}
