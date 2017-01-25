package edu.oregonstate.cs361.battleship;

/**
 * Created by DanielSchroederMac on 1/23/17.
 */
public class BattleshipModel {
    private ship aircraftShip;


    public BattleshipModel (){
        aircraftShip = new ship();
    }

    public BattleshipModel (ship aircraftShip) {
        this.aircraftShip = new ship(aircraftShip);
    }

}
