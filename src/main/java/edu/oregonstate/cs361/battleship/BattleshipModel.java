package edu.oregonstate.cs361.battleship;

import java.util.*;





public class BattleshipModel {

    //Collection of ships that represent the game state
    private ship aircraftCarrier;
    private ship battleship;
    private ship cruiser;
    private ship destroyer;
    private ship submarine;
    private ship computer_aircraftCarrier;
    private ship computer_battleShip;
    private ship computer_cruiser;
    private ship computer_destroyer;
    private ship computer_submarine;

    private ArrayList<Point> AI_Points;
    private ArrayList<Point> HUMAN_Points;

    //collection of hits and misses.
    private ArrayList<Point> playerHits;
    private ArrayList<Point> playerMisses;
    private ArrayList<Point> computerHits;
    private ArrayList<Point> computerMisses;



    public BattleshipModel() {
        Point x = new Point(0, 0);
        aircraftCarrier = new ship("AircraftCarrier", 5, x, x);
        battleship = new ship("Battleship", 4, x, x);
        cruiser = new ship("Cruiser", 3, x, x);
        destroyer = new ship("Destroyer", 2, x, x);
        submarine = new ship("Submarine", 2, x, x);
        computer_aircraftCarrier = new ship("Computer_AircraftCarrier", 5, x, x);
        computer_battleShip = new ship("Computer_BattleShip", 4, x, x);
        computer_cruiser = new ship("Computer_Crusier", 3, x, x);
        computer_destroyer = new ship("Computer_Destroyer", 2, x, x);
        computer_submarine = new ship("Computer_Submarine", 2, x, x);
        playerHits = new ArrayList<Point>();
        playerMisses = new ArrayList<Point>();
        computerHits = new ArrayList<Point>();
        computerMisses = new ArrayList<Point>();
        HUMAN_Points = new ArrayList<Point>();

    }
/*
    DIDN't NEED and don't want to test
    // creates a new battle ship from ships and a collections of hits.
    // don't user unless you have too!
    public BattleshipModel(ship aircraftCarrier, ship battleShip, ship cruiser, ship destroyer, ship submarine,
                           ship computer_aircraftCarrier, ship computer_battleShip, ship computer_cruiser,
                           ship computer_destroyer, ship computer_submarine, ArrayList<Point> playerHits,
                           ArrayList<Point> playerMisses, ArrayList<Point> computerHits,
                           ArrayList<Point> computerMisses) {
        this.aircraftCarrier = new ship(aircraftCarrier);
        this.battleship = new ship(battleShip);
        this.cruiser = new ship(cruiser);
        this.destroyer = new ship(destroyer);
        this.submarine = new ship(submarine);

        this.computer_aircraftCarrier = new ship(computer_aircraftCarrier);
        this.computer_battleShip = new ship(computer_battleShip);
        this.computer_cruiser = new ship(computer_cruiser);
        this.computer_destroyer = new ship(computer_destroyer);
        this.computer_submarine = new ship(computer_submarine);
        this.playerHits = new ArrayList<Point>(playerHits);
        this.playerMisses = new ArrayList<Point>(playerMisses);
        this.computerHits = new ArrayList<Point>(computerHits);
        this.computerMisses = new ArrayList<Point>(computerMisses);
    }
*/
    //Copy constructor does a deep copy
    public BattleshipModel(BattleshipModel toCopy) {
        aircraftCarrier = toCopy.aircraftCarrier;
        battleship = new ship(toCopy.battleship);
        cruiser = new ship(toCopy.cruiser);
        destroyer = new ship(toCopy.destroyer);
        submarine = new ship(toCopy.submarine);

        computer_aircraftCarrier = new ship(toCopy.computer_aircraftCarrier);
        computer_battleShip = new ship(toCopy.computer_battleShip);
        computer_cruiser = new ship(toCopy.computer_cruiser);
        computer_destroyer = new ship(toCopy.computer_destroyer);
        computer_submarine = new ship(toCopy.computer_submarine);

        playerHits = new ArrayList<Point>(toCopy.playerHits);
        playerMisses = new ArrayList<Point>(toCopy.playerMisses);
        computerHits = new ArrayList<Point>(toCopy.computerHits);
        computerMisses = new ArrayList<Point>(toCopy.computerMisses);
        HUMAN_Points = new ArrayList<Point>(toCopy.HUMAN_Points);
    }

    //Displays the game state to the console
    /* FOR TESTING ONLY
    public void display(){
            //displays the user ships
            aircraftCarrier.display();
            battleship.display();
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
*/
    // This function will place the ship on the game board where it needs to go
    // and do some error checking to make sure that the request follows
    // the rules of the game
    public String placeShip(String id, int across, int down, String direction) {
        // makes sure starting point isn't out of bounds
        boolean isVertical = direction.equals("vertical");
        if(across > 10 || down > 10){
            return "Failure: Placement out of bounds";
        }
        //checks name to make sure that the ship exists


        ship toAdd;
        int length;
        if(aircraftCarrier.checkName(id)) {
            toAdd = aircraftCarrier;
            length = toAdd.getLength();
            System.out.println("Ship: " + toAdd.getName() + "Length: " + toAdd.getLength());
        }
        else if(battleship.checkName(id)) {
            toAdd = battleship;
            length = toAdd.getLength();
            System.out.println("Ship: " + toAdd.getName() + "Length: " + toAdd.getLength());
        }
        else if (cruiser.checkName(id)) {
            toAdd = cruiser;
            length = toAdd.getLength();
            System.out.println("Ship: " + toAdd.getName() + "Length: " + toAdd.getLength());
        }
        else if(destroyer.checkName(id)) {
            toAdd = destroyer;
            length = toAdd.getLength();
            System.out.println("Ship: " + toAdd.getName() + "Length: " + toAdd.getLength());
        }
        else if(submarine.checkName(id)){
            toAdd = submarine;
            length = toAdd.getLength();
            System.out.println("Ship: " + toAdd.getName() + "Length: " + toAdd.getLength());
        }
        else
            return "Failure: Ship does not exist";

        //checks to make sure the ship doesn't get placed that it falls off the board
        if(isVertical){
            if((across + length - 1 ) > 10)
                return "Failure: Placement out of bounds";
        } else{//direction == horizontal
            if((down + length - 1 ) > 10)
                return "Failure: Placement out of bounds";
        }
        int endAcross;
        int endDown;
        Point start = new Point(across, down);
        Point end = new Point();
        if(isVertical){
            endAcross = across + length - 1;
            endDown = down;
            end.setPoint(endAcross, endDown);
        } else { //direction == horizontal
            endAcross = across;
            endDown = down + length - 1;
            end.setPoint(endAcross, endDown);
        }

        ship toCheck = new ship(id, length, start, end);
        boolean overlaps = checkShipOverlap(toCheck);
        if(overlaps){
            return "Failure: Placement overlaps another ship";
        }
        toAdd.setStart(across, down);
        toAdd.setEnd(endAcross, endDown);


        return "Success: Placed " + id + " at " + across + ", " + down;
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
        //returns true if location has not been fired before
        //Assign vars
        int row = x;
        int col = y;
        int pAcross, pDown;
        boolean newFire = true;
        ArrayList<Point> hits = this.computerHits;
        ArrayList<Point> misses = this.computerMisses;

        //Check if shot has already hit
        for (Point hit: hits)
        {
            //check each computerHits for match
            pAcross = hit.getAcross();
            pDown = hit.getDown();

            if (x==pAcross && y==pDown)
                return false;
        }

        //Check if shot has already missed
        for (Point miss: misses)
        {
            //Check each computerMisses for match
            pAcross = miss.getAcross();
            pDown = miss.getDown();

            if (x==pAcross && y==pDown)
                return false;
        }

        return newFire;
    }

    // returns false if it doesn't over lap any other ships returns true if it does
    private boolean checkShipOverlap(ship toCheck) {
        return aircraftCarrier.shipOverlap(toCheck) || battleship.shipOverlap(toCheck) || cruiser.shipOverlap(toCheck) || destroyer.shipOverlap(toCheck) || submarine.shipOverlap(toCheck);
    }

    public Point AIfirePoint(){
        Random rand = new Random();
        while(true){
            int across = rand.nextInt(9)+1;
            int down = rand.nextInt(9)+1;
            Point point = new Point(across,down);

            for(int x = 0; x< computerHits.size(); x++){
                if (computerHits.get(x).equals(point) == true)
                    break;
            }
            for(int x = 0; x< computerMisses.size(); x++){
                if (computerMisses.get(x).equals(point) == true)
                    break;
            }
            return point;
        }

    }
    public void AIHitsAndMisses(Point point){
        if(aircraftCarrier.AIShipHitCheck(point,aircraftCarrier) == true || battleship.AIShipHitCheck(point,battleship) == true ||
        cruiser.AIShipHitCheck(point,cruiser) == true || destroyer.AIShipHitCheck(point,destroyer) == true ||
                submarine.AIShipHitCheck(point,submarine) == true){
            playerHits.add(point);
        }
        else{
            playerMisses.add(point);
        }

}

    //The player equivalent of AIHitsAndMisses
    //String is returned only for testing purposes
    public String PlayerHitsAndMisses(Point point){
        String result;

        if(computer_aircraftCarrier.AIShipHitCheck(point,computer_aircraftCarrier) == true || computer_battleShip.AIShipHitCheck(point,computer_battleShip) == true ||
                computer_cruiser.AIShipHitCheck(point,computer_cruiser) == true || computer_destroyer.AIShipHitCheck(point,computer_destroyer) == true ||
                computer_submarine.AIShipHitCheck(point,computer_submarine) == true){
            computerHits.add(point);
            result = "Hit!";
        }
        else{
            computerMisses.add(point);
            result = "Miss!";
        }
        return result;

    }


    public void placeComputerShips(){

        //create an array of all ships to place
        ship[] computerShips = {computer_aircraftCarrier,computer_battleShip,computer_cruiser,computer_destroyer,computer_submarine};

        //initialize our array list of points
        AI_Points = new ArrayList<Point>();
        int counter = 0;

        //while we have not been through all the ships:
        while(counter < computerShips.length){

            //get current ship out of the array
            ship currentShip = computerShips[counter];

            boolean test = false; //this will turn true once it passes isValidMove()

            while(!test) {

                //get a random orientation
                int randomOrientation = (int) (Math.random() * 2);
                String orientation = "";
                if (randomOrientation == 0)
                    orientation = "horizontal";
                else
                    orientation = "vertical";

                //get a random x,y value for start point
                int tempAcross = (int) (Math.random() * 10 + 1);
                int tempDown = (int) (Math.random() * 10 + 1);

                //checks if these are valid coordinates
                if (isValidComputerMove(currentShip.getLength(), orientation, tempAcross, tempDown, false )){
                    test=true;

                    //add points to array list of compputer points
                    for(int i = 0; i < currentShip.getLength(); i++){

                        //adds points moving horizontally away from start
                        if(orientation == "horizontal") {
                            Point temp = new Point(tempAcross+i, tempDown);
                            //System.out.println("Adding Point: (" + temp.getAcross() +", " + temp.getDown() + ")");
                            AI_Points.add(temp);
                        }
                        //adds points moving vertically away from start
                        else{
                            Point temp = new Point(tempAcross, tempDown+i);
                            //System.out.println("Adding Point: (" + temp.getAcross() +", " + temp.getDown() + ")");
                            AI_Points.add(temp);
                        }

                    }
                    //test prints
                    /*
                    System.out.println("orientation:" + orientation);
                    System.out.println("Across:" + tempAcross);
                    System.out.println("Down:" + tempDown);
                    System.out.println(currentShip.getName());
                    System.out.println("Length: " + currentShip.getLength());
                    System.out.println(AI_Points.toString());*/
                }

            }
            //go to next computer ship
            counter++;

        }

    }

    public int get_AI_Point_Length(){
        return AI_Points.size();
    }

    private boolean isValidComputerMove(int length, String orientation, int across, int down, boolean isHuman){

        ArrayList<Point> temp_Points = new ArrayList<Point>();
        ArrayList<Point> myPoints = null;
        if(isHuman)
            myPoints = HUMAN_Points;
        else
            myPoints = AI_Points;

        //first check to see if it runs off the page
        if(orientation == "horizontal"){
            if((across + length) > 10)
                return false;
        }
        else {
            if ((down + length) > 10)
                return false;
        }



        //add points to temp array list of current points
        for(int i = 0; i < length; i++){
            if(orientation == "horizontal") {
                Point temp = new Point(across+i, down);
                temp_Points.add(temp);
            }
            else{
                Point temp = new Point(across, down+i);
                temp_Points.add(temp);
            }
        }


        //iterates though both array lists to see if any points are the same (an overlap)
        for(int i = 0; i < temp_Points.size(); i++){
            Point checkPoint = temp_Points.get(i);

            int counter = 0;
            while(counter < myPoints.size()){

                //System.out.println("Comparing myPoint(" + checkPoint.getAcross()+ ", " + checkPoint.getDown() +") " +
                //        "and AI POINT (" + myPoints.get(counter).getAcross() + ", " + myPoints.get(counter).getDown()+ ")");

                if((checkPoint.getAcross() == (myPoints.get(counter).getAcross())) && (checkPoint.getDown() == (myPoints.get(counter).getDown()))){
                    //System.out.println("Overlapping points");
                    return false;
                }
                counter++;
            }

        }

        //if all tests pass, return true
        return true;

    }
}
