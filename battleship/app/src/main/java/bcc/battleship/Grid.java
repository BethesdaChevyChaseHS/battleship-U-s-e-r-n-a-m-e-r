package bcc.battleship;

public class Grid {
    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    private Location[][] grid;
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        grid = new Location[NUM_ROWS][NUM_COLS];

    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
        grid[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        return !grid[row][col].isUnguessed();
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return grid[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return NUM_ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return NUM_COLS;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        if (s.getDirection() == 0) {
            if (col + s.getLength() > NUM_COLS) {
                return false;
            }
            for (int i = 0; i < s.getLength(); i++) {
                if (grid[row][col + i].hasShip()) {
                    return false;
                }
            }
            for (int i = 0; i < s.getLength(); i++) {
                grid[row][col + 1].setShip(true);
            }
        } else if (s.getDirection() == 1) {
            if (row + s.getLength() > NUM_ROWS) {
                return false;
            }
            for (int i = 0; i < s.getLength(); i++) {
                if (grid[row + i][col].hasShip()) {
                    return false;
                }
            }
            for (int i = 0; i < s.getLength(); i++) {
                grid[row + i][col].setShip(true);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean allShipsSank(){
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (grid[row][col].hasShip() && grid[row][col].getStatus() != Location.HIT) {
                    return false;
                }
            }
        }
        return true;
    }
}
