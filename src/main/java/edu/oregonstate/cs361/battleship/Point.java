package edu.oregonstate.cs361.battleship;

/**
 * Created by Garrett on 1/25/2017.
 */
public class Point {

    private int Across;
    private int Down;

  public Point(){
     Across = 0;
     Down = 0;
    }
    public Point(Point toCopy){
        Across =  toCopy.Across;
        Down = toCopy.Down;
    }

    public Point(int across, int down){
        this.Across = across;
        this.Down = down;
    }

    public void display(){
        System.out.println("Across: "+ Across);
        System.out.println("Down: "+ Down);
    }
}
