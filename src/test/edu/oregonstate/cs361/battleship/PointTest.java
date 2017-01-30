package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tnoelcke on 1/30/2017.
 */
class PointTest {
    Point test;
    Point p;

    //checks that getAcross gets the across paramater
    @Test
    void getAcross() {
        test = new Point();
        int result = test.getAcross();
        assertEquals(result, 0);
    }

    //checks that get down gets the down paramater
    @Test
    void getDown() {
        test = new Point();
        int result = test.getDown();
        assertEquals(result, 0);
    }

    //checks that set point sets the point
    @Test
    void setPoint() {
        test = new Point();
        test.setPoint(9, 9);
        int across = test.getAcross();
        int down = test.getDown();
        assertEquals(across, 9);
        assertEquals(down, 9);
    }

    //Checks that equal returns true if the points are equal
    @Test
    void equalTest(){
        test = new Point();
        p = new Point();
        boolean result = test.equals(p);
        assertEquals(result, true);
    }

    //checks that equal returns false if the points are not equal
    @Test
    void notEqualTest(){
        test = new Point(1, 3);
        p = new Point(2, 5);
        boolean result = test.equals(p);
        assertEquals(result, false);
    }


}