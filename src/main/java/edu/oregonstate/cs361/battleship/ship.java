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

    public void display (){
        System.out.println("Name: " + name);
        System.out.println("Length: " + length);
        start.display();
        end.display();
    }

    //this function takes two points as paramaters and checks
    // weather or not the points give intersect with the points
    // already in the ship.
    public boolean shipOverlap(ship check){
        if(start.equals(check.start) || start.equals(check.end) || end.equals(check.end) || end.equals(check.start)){
            return true;
        }
        return false;
    }
}
