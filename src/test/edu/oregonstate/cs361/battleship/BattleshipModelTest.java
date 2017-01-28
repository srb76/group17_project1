package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tnoelcke on 1/28/2017.
 */
class BattleshipModelTest {



    @Test
    void placeShip() {
        BattleshipModel test = new BattleshipModel();
        String result = test.placeShip("aircraftCarrier", "1", "1", "vertical" );
        assertEquals(result, null);
    }

}