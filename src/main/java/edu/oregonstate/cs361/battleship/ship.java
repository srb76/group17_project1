package edu.oregonstate.cs361.battleship;

/**
 * Created by tnoelcke on 1/24/2017.
 * This class Encapsulates all the data from a battle ship
 *
 */
public class ship {
    private String name;
    private int length;
    //private point start;
    //private point end;

    public ship(){
        name = null;
        length = 0;
        //start = new point ();
        //end = new point();
    }

    public ship(String name, int length){
        this.name = name;
        this.length = length;

    }

    public ship(ship aship){
        name = aship.name;
        length = aship.length;
        //start = new point(aship.start);
        //end = new point(aship.end);
    }

    public void display (){
        System.out.println("Name: " + name);
        System.out.println("Length: " + length);
        //start.display();
        //end.display();
    }
}
