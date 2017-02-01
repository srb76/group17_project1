package edu.oregonstate.cs361.battleship;

/**
 * Created by tnoelcke on 1/24/2017.
 * This class Encapsulates all the data from a battle ship
 *
 */
public class ship {
    private String name;
    private int length;
    private Point start;
    private Point end;

    // default constructor
    public ship(){
        name = null;
        length = 0;
        start = new Point ();
        end = new Point();
    }

    // constructor with args to initialize
    public ship(String name, int length, Point start, Point end){
        this.name = name;
        this.length = length;
        this.start = new Point(start);
        this.end = new Point(end);
    }

    // copy constructor
    public ship(ship aship){
        name = aship.name;
        length = aship.length;
        start = new Point(aship.start);
        end = new Point(aship.end);
    }
/*
    Was for testing only noo need for it to be here
    public void display (){
        System.out.println("Name: " + name);
        System.out.println("Length: " + length);
        start.display();
        end.display();
    }
*/

    //checks if the name is the same as toCheck
    // returns false if no and true if yes.
    public boolean checkName(String toCheck){
        String tempName = name.toLowerCase();
        return tempName.equals(toCheck.toLowerCase());
    }
    //this function takes two points as paramaters and checks
    // weather or not the points give intersect with the points
    // already in the ship.
    public boolean shipOverlap(ship check){
        if(start.equals(check.start) || start.equals(check.end) || end.equals(check.end)|| end.equals(check.start)){
            return true;
        }

        // checks to see which way the ships are placed.
        int thisADistance = start.acrossLength(end);
        int aDistance = check.start.acrossLength(check.end);

        //creates new objects so that i can change the objects with out breaking
        // the current object
        Point thisObject = new Point(start);
        Point checkObject = new Point(check.start);

        //loops through all the points in both ships and checks for equality.
        for(int i = 0; i < length; ++i){
            checkObject.setPoint(check.start.getAcross(), check.start.getDown());
            for(int j = 0; j < check.length; ++j){
                if(thisObject.equals(checkObject)){
                    return true;
                }
                //Incremnts check point to the next point in the ship.
                if(aDistance != 0){
                    checkObject.setPoint(checkObject.getAcross() + 1, checkObject.getDown());
                } else {
                    checkObject.setPoint(checkObject.getAcross(), checkObject.getDown() + 1);
                }
            }

            //incriments this object to the next object in the ship.
            if(thisADistance != 0){
                thisObject.setPoint(thisObject.getAcross() + 1, thisObject.getDown());
            } else {
                thisObject.setPoint(thisObject.getAcross(), thisObject.getDown() + 1);
            }
        }
        return false;
    }

    public void setStart(int across, int down) {
        start.setPoint(across, down);
    }

    public void setEnd(int across, int down) {
        end.setPoint(across, down);
    }

    public boolean AIShipHitCheck(Point point,ship check){
        int horizontalCheck = check.start.acrossLength(check.end);
        if(point == check.start || point == check.end)
            return true;
        Point checkPoint = new Point();
        checkPoint.setPoint(check.start.getAcross(), check.start.getDown());
            for(int x = 0; x < check.length; ++x) {
                if (point.equals(checkPoint)) {
                    return true;
                }
                if (horizontalCheck != 0) {
                    checkPoint.setPoint(checkPoint.getAcross() + 1, checkPoint.getDown());
                }
                else {
                    checkPoint.setPoint(checkPoint.getAcross(), checkPoint.getDown() + 1);
                }
            }
        return false;

            }


    }

