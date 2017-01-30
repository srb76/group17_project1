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
        assertEquals(result, false);
    }

    // test for the case that ships partially overlap
    @Test
    void shipsPartialyOverlap(){

    }

    //tests for the case that ships are parallel
    @Test
    void shipsParallel() {

    }

    //tests for the case that ships intersect
    @Test
    void shipsIntersect() {

    }

    @Test
    void shipsPerpendicularButDontIntersect(){

    }
}