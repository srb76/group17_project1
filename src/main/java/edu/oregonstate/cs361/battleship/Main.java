package edu.oregonstate.cs361.battleship;




import com.google.gson.Gson;
import spark.Request;
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
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model
    static String newModel() {
        BattleshipModel test = new BattleshipModel();
        Gson gson = new Gson();
        String model = new String(gson.toJson(test));
        System.out.println(model);
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
    private static String placeShip(Request req) {
        String url = req.url();
        String model = req.body();
        System.out.println("url: " + url);
        System.out.println("body: " + model);
        return "This is a place holder";
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        String row = req.params(":row");
        String col = req.params(":col");
        String result = "";
        boolean noError = true;
        BattleshipModel gameState;
        Gson gson = new Gson();

        //Convert row and col strings to integer
        int numRow = Integer.parseInt(row);
        int numCol = Integer.parseInt(col);

        //Get battleship model from request
        gameState = getModelFromReq(req);

        //Test for shot in bounds
        noError = gameState.shotInBounds(numRow,numCol);

        //Test if shot has already been attempted
        //noError = gameState.hasFired(numRow,numCol);

        //Check if fire location is a hit or miss and update gamestate accordingly
        //gameState.hitShip(numRow,numCol);

        //Convert game state back to JSON
        /*
        result = gson.toJson(gameState);
         */

        //Set result (for testing purposes)
        if (noError)
            result += "FIRE: " + row + "," + col;
        else
            result += "ERROR: out of bounds";

        return result;
    }

}