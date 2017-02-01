package edu.oregonstate.cs361.battleship;


import java.util.*;





public class BattleshipModel {

    //Collection of ships that represent the game state
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
    private ArrayList<Point> playerHits;
    private ArrayList<Point> playerMisses;
    private ArrayList<Point> computerHits;
    private ArrayList<Point> computerMisses;

    public BattleshipModel (){
        Point x = new Point(0, 0);

        aircraftCarrier = new ship("AircraftCarrier", 5, x, x);
        battleShip = new ship("BattleShip", 4,x,x);
        cruiser = new ship("Crusier", 3, x, x);
        destroyer = new ship("Destoryer",2, x, x);
        submarine = new ship("Submarine", 2, x, x);
        computer_aircraftCarrier = new ship("Computer_AircraftCarrier", 5,x,x);
        computer_battleShip = new ship("Computer_BattleShip",4,x, x);
        computer_cruiser = new ship("Computer_Crusier", 3, x, x);
        computer_destroyer = new ship("Computer_Destroyer", 2, x ,x);
        computer_submarine = new ship("Computer_Submarine",2, x, x);
        playerHits = new ArrayList<Point>();
        playerMisses = new ArrayList<Point>();
        computerHits = new ArrayList<Point>();
        computerMisses = new ArrayList<Point>();
    }

    // creates a new battle ship from ships and a collections of hits.
    // don't user unless you have too!
    public BattleshipModel (ship aircraftCarrier, ship battleShip, ship cruiser, ship destroyer, ship submarine,
                            ship computer_aircraftCarrier, ship computer_battleShip, ship computer_cruiser,
                            ship computer_destroyer, ship computer_submarine, ArrayList<Point> playerHits,
                            ArrayList<Point> playerMisses, ArrayList<Point> computerHits,
                            ArrayList<Point> computerMisses) {
            this.aircraftCarrier    =  new ship(aircraftCarrier);
            this.battleShip         = new ship(battleShip);
            this.cruiser            = new ship(cruiser);
            this.destroyer          = new ship(destroyer);
            this.submarine          = new ship (submarine);

            this.computer_aircraftCarrier   = new ship(computer_aircraftCarrier);
            this.computer_battleShip        = new ship (computer_battleShip);
            this.computer_cruiser           = new ship(computer_cruiser);
            this.computer_destroyer         = new ship(computer_destroyer);
            this.computer_submarine         = new ship(computer_submarine);
            this.playerHits                 = new ArrayList<Point>(playerHits);
            this.playerMisses               = new ArrayList<Point>(playerMisses);
            this.computerHits               = new ArrayList<Point>(computerHits);
            this.computerMisses             = new ArrayList<Point>(computerMisses);
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

        playerHits      = new ArrayList<Point>(toCopy.playerHits);
        playerMisses    = new ArrayList<Point>(toCopy.playerMisses);
        computerHits    = new ArrayList<Point>(toCopy.computerHits);
        computerMisses  = new ArrayList<Point>(toCopy.computerMisses);
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
            computer_cruiser.display();
            computer_destroyer.display();
            computer_submarine.display();


            // displays the list of hits.
            System.out.println("playerHits: " + playerHits);
            System.out.println("PlayerMisses: " + playerMisses);
            System.out.println("Computer Hits: " + computerHits);
            System.out.println("Computer Misses " + computerMisses);
    }

    public static boolean shotInBounds(int x, int y) {
        //Checks if given x,y coordinate is within the 1-9 board
        //Returns true for valid shot coordinates
        //Returns false for invalid shot coordinates

        //Assign vars
        int row = x;
        int col = y;
        boolean inBounds = true;

        //Check if row in on board
        if (row > 10 || row < 1)
            inBounds = false;

        //Check if col in on board
        else if (col > 10 || col < 1)
            inBounds = false;

        return inBounds;
    }

    public boolean hasFired(int x, int y) {
        //Checks if passed location has been fired at before
        //returns true if
        //Assign vars
        int row = x;
        int col = y;
        boolean newFire = true;
        ArrayList<Point> hits = this.playerHits;

        //Check if shot has already hit
        /*
        for (Point hit: hits)
        {
            //check each playerHits for match
        }
        //Check if shot has already missed

*/
        return newFire;
    }

    public void hitShip(int x, int y) {
        //Checks to see if a shot location hits any ships
        //and adds to playerHits or playerMisses accordingly
    }

}
