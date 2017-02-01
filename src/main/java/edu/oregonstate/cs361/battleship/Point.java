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
/*
    for testing only!
    public void display(){
        System.out.println("Across: "+ Across);
        System.out.println("Down: "+ Down);
    }
*/
    public int getAcross(){
        return Across;
    }

    public int getDown(){
        return Down;
    }

    public void setPoint(int across, int down){
        Down = down;
        Across = across;
    }

    public boolean equals(Point p) {
        if (Across == p.Across && Down == p.Down) {
            return true;
        }
        return false;
    }

    public int acrossLength(Point p){
        int length;
        if(p.Across >= Across){
            length = p.Across - Across;
        } else{
            length = Across - p.Across;
        }
        return length;
    }

    public int downLength(Point p){
        int length;
        if(p.Down >= Down ){
            length = p.Down - Down;
        } else {
            length = Down - p.Down;
        }
        return length;
    }

}
