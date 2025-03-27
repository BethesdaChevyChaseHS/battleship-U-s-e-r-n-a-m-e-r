package bcc.battleship;
import bcc.battleship.Constants;

public class Player {

    private ArrayList<Ship> ships;
    private Grid myGrid;
    private Grid opponentGrid;
  
    // Constructor: Initialize the grids and the ships.
    public Player() {
        myGrid = new Grid();
        opponentGrid = newGrid();
        ships = new ArrayList<>();

        for (int length : SHIP_LENGTHS) {
            ships.add(new Ship(length));
        }
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        if (addShip(index) == true) {
            myGrid.setLocation(row, col);
            myGrid.setDirection(direction);
            myGrid.addShip(index);
            return true;
        } else {
            return false;
        }
        
        return false;
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if (myGrid.hasShip(row, col)) {
            myGrid.markHit(row, col);
            return true;
        } else {
            myGrid.markMiss(row, col);
            return false;
        }
    }
    
    
    public Grid getMyGrid() {
        return myGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
