package edu.oregonstate.cs361.battleship;

/**
 * Created by tnoelcke on 1/24/2017.
 */
public class ship {
    private String name;
    private int length;
    private int start;
    private int end;

    public ship(){
        name = null;
        length = 0;
        start = 0;
        end = 0;
    }

    public ship(String name, int length, int start, int end){
        this.name = name;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public ship(ship aship){
        name = aship.name;
        length = aship.length;
        start = aship.start;
        end = aship.end;
    }

    public static void display (){
        
    }
}
