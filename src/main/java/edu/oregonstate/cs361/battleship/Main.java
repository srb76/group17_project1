package edu.oregonstate.cs361.battleship;




import com.google.gson.Gson;
import spark.Request;
import spark.Response;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;




public class Main {
    public static void main(String[] args) {

        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(res,req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(res, req));
    }


    //This function should return a new model
    static String newModel() {
        BattleshipModel test = new BattleshipModel();
        test.placeComputerShips();
        Gson gson = new Gson();
        String model = new String(gson.toJson(test));
        //System.out.println(model);
        String fullModel = "model: ";

        return model;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        String model = req.body();
        Gson gson = new Gson();
        BattleshipModel newModel = gson.fromJson(model, BattleshipModel.class);
        return newModel;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Response res, Request req) {
        //gets the model from the body and turns it in to a java object
        BattleshipModel newModel = getModelFromReq(req);
        //gets the params from the request
        String id;
        String row;
        String col;
        String orientation;
        id = req.params("id");
        row = req.params("row");
        col = req.params("col");
        orientation = req.params("orientation");
        int across = Integer.parseInt(row);
        int down = Integer.parseInt(col);


        //Attepts to place the ship and checks the result
        String result = newModel.placeShip(id, across, down, orientation);

        //if placement failed
        if(!result.contains("Success:")){
            res.status(400);
            return result;
        }



        //turs newModel back into a json string
        Gson gson = new Gson();
        String model = gson.toJson(newModel);
        res.status(200);
        return model;
    }



    //Similar to placeShip, but with firing.
    private static String fireAt(Response res, Request req) {
        String row = req.params(":row");
        String col = req.params(":col");
        String result = "";
        boolean noError = true;
        BattleshipModel gameState;
        Gson gson = new Gson();
        Point fireLocation = new Point();

        //Convert row and col strings to integer

        int down = Integer.parseInt(row);
        int across = Integer.parseInt(col);

        //Get battleship model from request
        gameState = getModelFromReq(req);

        //Test for shot in bounds
        noError = gameState.shotInBounds(across, down);

        //Test if shot has already been attempted

        if (noError)
            noError = gameState.hasFired(across, down);
        else {
            //Alter error message for out of bounds shot
            result = "Invalid fire location! That shot was off the board.";
            res.status(400);
        }

        //Check if fire location is a hit or miss and update gamestate accordingly
        fireLocation.setPoint(across, down);
        if (noError) {
            //Fire at location and update computer hits and misses
            gameState.PlayerHitsAndMisses(fireLocation);

            Point AIFire = new Point();
             AIFire = gameState.AIfirePoint();
            gameState.AIHitsAndMisses(AIFire);

            //Convert game state back to JSON
            result = gson.toJson(gameState);
        }
        else if (!result.contains("Invalid"))
        {
            //Alter error message for a shot that has already been attempted
            result = "Invalid fire location! You have already fired at that location!";
            res.status(400);
        }

        //JSON string is returned if no errors were detected, otherwise a string containing the error message is returned
        return result;
    }

}