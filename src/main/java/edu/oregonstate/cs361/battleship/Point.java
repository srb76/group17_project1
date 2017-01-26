package edu.oregonstate.cs361.battleship;

/**
 * Created by Garrett on 1/25/2017.
 */
public class Point {
    private int across;
    private int down;

    public Point(){
     across = 0;
     down = 0;
    }
    public Point(Point toCopy){
        across =  toCopy.across;
        down = toCopy.down;
    }
    public void display(){
        System.out.println("Across: "+ across);
        System.out.println("Down "+ down);
    }
}
