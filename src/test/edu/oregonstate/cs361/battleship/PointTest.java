package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tnoelcke on 1/30/2017.
 */
class PointTest {
    Point test;

    @Test
    void getAcross() {
        test = new Point();
        int result = test.getAcross();
        assertEquals(result, 0);
    }

    @Test
    void getDown() {
        test = new Point();
        int result = test.getDown();
        assertEquals(result, 0);
    }

    @Test
    void setPoint() {
        test = new Point();
        test.setPoint(9, 9);
        int across = test.getAcross();
        int down = test.getDown();
        assertEquals(across, 9);
        assertEquals(down, 9);
    }

}