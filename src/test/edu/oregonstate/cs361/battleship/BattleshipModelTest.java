package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tnoelcke on 1/28/2017.
 */
class BattleshipModelTest {

    //tests the copy constuctor
    @Test
    void copyConstructorTest(){
        Gson gson = new Gson();
        BattleshipModel test = new BattleshipModel();
        test.placeShip("Battleship", 1, 1, "vertical");
        BattleshipModel test2 = new BattleshipModel(test);
        String expected = gson.toJson(test);
        String result = gson.toJson(test2);
        assertEquals(expected, result);
    }

    //tests the the ship is placed if the placement is valid
    @Test
    void placeShipValidPlacement() {
        BattleshipModel test = new BattleshipModel();
        String result = test.placeShip("AircraftCarrier", 1, 1, "vertical" );
        assertEquals(result, "Success: Placed AircraftCarrier at 1, 1");
    }

    //tests that the ship is not placed if the placement is out of bounds
    @Test
    void shipOutOfBounds(){
        BattleshipModel test = new BattleshipModel();
        String results = test.placeShip("Battleship", 25, 25, "vertical");
        assertEquals("Failure: Placement out of bounds", results);
    }

    //test that the ship is not placed if the ship name is not valid
    @Test
    void invalidShipName() {
        BattleshipModel test = new BattleshipModel();
        String results = test.placeShip("apsodifahpdfo", 1, 1, "horizontal");
        assertEquals("Failure: Ship does not exist", results);
    }


    // test that the ship is not placed if it overlaps another ship
    @Test
    void shipOverlap(){
        BattleshipModel test = new BattleshipModel();
        test.placeShip("AircraftCarrier", 2, 2, "vertical");
        String result = test.placeShip("Battleship", 3, 1, "horizontal");
        assertEquals("Failure: Placement overlaps another ship", result);
    }

    //tests the horizantal placment of a ship
    @Test
    void horizantalPlacement (){
        BattleshipModel test = new BattleshipModel();
        String result = test.placeShip("Destroyer", 3, 3, "horizontal");
        assertEquals("Success: Placed Destroyer at 3, 3", result);
    }

    //tests that the ship is not placed if the start point is in bounds but the ship ends up out of bounds
    @Test
    void validStartButOutOfBounds (){
        BattleshipModel test = new BattleshipModel();
        String vertical = test.placeShip("Submarine", 10, 10, "vertical");
        String horizontal = test.placeShip("Cruiser", 10, 10, "horizontal");
        String result = "Failure: Placement out of bounds";
        assertEquals(result, vertical);
        assertEquals(result, horizontal);
    }

    //Tests if a shot is within the bounds of the board (1-10)
    @Test
    public void testShotInBounds() {
        BattleshipModel test = new BattleshipModel();
        boolean validShot, badShot;
        validShot = test.shotInBounds(1,1);
        badShot = test.shotInBounds(0,20);
        assertEquals(validShot,true);
        assertEquals(badShot,false);
    }

    //tests a shot at (1,1) and (2,2), should return true and false to indicate this is a new firing location
    @Test
    void testHasFired () {
        BattleshipModel test = new BattleshipModel();
        Point testPoint = new Point(2,2);

        //Add a point to misses
        test.PlayerHitsAndMisses(testPoint);

        boolean newHit = test.hasFired(1,1);
        boolean badHit = test.hasFired(2,2);
        assertEquals(true, newHit);
        assertEquals(false,badHit);
    }

    //tests PlayerHitsAndMisses for a missed shot
    @Test
    void testMiss () {
        String result = "";
        BattleshipModel test = new BattleshipModel();
        Point testShot = new Point(1,1);
        result = test.PlayerHitsAndMisses(testShot); //Should miss
        assertEquals("Miss!",result);
    }

    //tests PlayerHitsAndMisses for a hit shot (on default location of ships)
    @Test
    void testHit () {
        String result = "";
        BattleshipModel test = new BattleshipModel();
        Point testShot = new Point(0,0);
        result = test.PlayerHitsAndMisses(testShot);
        assertEquals("Hit!",result);
    }

    @Test
    void testAIPlace () {
        BattleshipModel test = new BattleshipModel();
        test.placeComputerShips();
        assertEquals(16, test.get_AI_Point_Length());
    }



}