package edu.oregonstate.cs361.battleship;

import java.util.*;




/**
 * Created by DanielSchroederMac on 1/23/17.
 */
public class BattleshipModel {

    //
    private ship aircraftCarrier;
    private ship battleShip;
    private ship cruiser;
    private ship destroyer;
    private ship submarine;
    private ship computer_aircraftCarrier;
    private ship computer_battleShip;
    private ship computer_cruiser;
    private ship computer_destroyer;
    private ship computer_submarine;

    //collection of hits and misses.
    //ArrayList<point> playerHits;
    //ArrayList<point> playerMisses;
    //ArrayList<point> computerHits;
    //ArrayList<point> computerMisses;

    public BattleshipModel (){
        aircraftCarrier = new ship();
        battleShip = new ship();
        cruiser = new ship();
        destroyer = new ship();
        submarine = new ship();
        computer_aircraftCarrier = new ship();
        computer_battleShip = new ship();
        computer_cruiser = new ship();
        computer_destroyer = new ship();
        computer_submarine = new ship();

    }

    // creates a new battle ship from ships and a collections of hits
    public BattleshipModel (ship aircraftCarrier, ship battleShip, ship cruiser, ship destroyer, ship submarine,
                            ship computer_aircraftCarrier, ship computer_battleShip, ship computer_cruiser,
                            ship computer_destroyer, ship computer_submarine) {
            this.aircraftCarrier =  new ship(aircraftCarrier);
            this.battleShip = new ship(battleShip);
            this.cruiser = new ship(cruiser);
            this.destroyer = new ship(destroyer);
            this.submarine = new ship (submarine);
            this.computer_aircraftCarrier = new ship(computer_aircraftCarrier);
            this.computer_battleShip = new ship (computer_battleShip);
            this.computer_cruiser = new ship(computer_cruiser);
            this.computer_destroyer = new ship(computer_destroyer);
            this.computer_submarine = new ship(computer_submarine);

    }

    //Copy constructor does a deep copy
    public BattleshipModel(BattleshipModel toCopy){
        aircraftCarrier = toCopy.aircraftCarrier;
        battleShip      = new ship(toCopy.battleShip);
        cruiser         = new ship (toCopy.cruiser);
        destroyer       = new ship(toCopy.destroyer);
        submarine       = new ship(toCopy.submarine);

        computer_aircraftCarrier    = new ship(toCopy.computer_aircraftCarrier);
        computer_battleShip         = new ship(toCopy.computer_battleShip);
        computer_cruiser            = new ship(toCopy.computer_cruiser);
        computer_destroyer          = new ship(toCopy.computer_destroyer);
        computer_submarine          = new ship(toCopy.computer_submarine);
    }

    //Displays the game state to the console
    public void display(){
            //displays the user ships
            aircraftCarrier.display();
            battleShip.display();
            cruiser.display();
            destroyer.display();
            submarine.display();

            // displays the computer ships
            computer_aircraftCarrier.display();
            computer_battleShip.display();
            computer_destroyer.display();
            computer_destroyer.display();
            computer_submarine.display();

            // displays the list of hits.

    }

}
