package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tnoelcke on 1/30/2017.
 */
class shipTest {
    ship test;
    ship overlap;

    //test for the case that ships are in the same spot
    @Test
    void shipsInSameSpot() {
        test = new ship();
        overlap = new ship();
        boolean result = test.shipOverlap(overlap);
        assertEquals(true, result);
    }

    // test for the case that ships partially overlap
   @Test
    void shipsPartiallyOverlap(){
        // Sets up two ships that overlap paritally
        Point start = new Point(1,1);
        Point end = new Point(1, 5);
        test = new ship("battleShip", 4, start, end);
        start.setPoint(1,3);
        end.setPoint(1, 8);
        overlap = new ship("aircraftCairrier", 5, start, end);

        boolean result = test.shipOverlap(overlap);
        assertEquals(true, result);
    }

    //tests for the case that ships are parallel
    @Test
    void shipsParallel() {
        // creates parallel ships and tests if they intersect
        Point start = new Point(1, 1);
        Point end = new Point(1, 3);
        test = new ship("battleShip", 4, start, end);
        start.setPoint(2,1);
        end.setPoint(2, 3);
        overlap = new ship("submarine", 2, start, end);

        boolean result = test.shipOverlap(overlap);
        assertEquals(false, result);
    }

    //tests for the case that ships intersect
    @Test
    void shipsIntersect() {
        Point start = new Point(1,1);
        Point end = new Point(1, 5);
        test = new ship("battleShip", 4, start, end);
        start.setPoint(1, 3);
        end.setPoint(6, 3);
        overlap = new ship("aircraftcairer", 5, start, end);

        boolean result = test.shipOverlap(overlap);

        assertEquals(true, result);

    }

    @Test
    void shipsPerpendicularButDontIntersect(){
        Point start = new Point(1,1);
        Point end = new Point(1, 5);
        test = new ship("battleShip", 4, start, end);
        start.setPoint(3, 3);
        end.setPoint(8, 3);
        overlap = new ship("aircraftcairer", 5, start, end);

        boolean result = test.shipOverlap(overlap);

        assertEquals(false, result);

    }

    @Test
    void downTest(){

    }
}