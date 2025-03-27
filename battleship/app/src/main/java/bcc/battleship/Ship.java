package bcc.battleship;

public class Ship {

    private int row;
    private int col;
    private int length;
    private int direction;

    private static final int UNSET = -1;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;

    // Constructor. Create a ship and set the length.
    public Ship(int length) {
        this.length = length;
        this.row = UNSET;
        this.col = UNSET;
        this.direction = UNSET;
    }

    // Has the location been initialized
    public boolean isLocationSet() {
        return row != UNSET && col != UNSET;
    }

    // Has the direction been initialized
    public boolean isDirectionSet() {
        return direction != UNSET;
    }

    // Set the location of the ship
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Set the direction of the ship
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Getter for the row value
    public int getRow() {
        return row;
    }

    // Getter for the column value
    public int getCol() {
        return col;
    }

    // Getter for the length of the ship
    public int getLength() {
        return length;
    }

    // Getter for the direction
    public int getDirection() {
        return direction;
    }

    // Helper method to get a string value from the direction
    // Helper method to get a string value from the direction
    private String directionToString() {
        if (direction == HORIZONTAL) {
            return "horizontal";
        }
        if (direction == VERTICAL) {
            return "vertical";
        }
        return "unset direction";
    }

    // Helper method to get a (row, col) string value from the location
    private String locationToString() {
        if (isLocationSet() != false) {
            return "(" + row + ", " + col + ")";
        }
        return "(unset location)";
    }

    // toString value for this Ship
    @Override
    public String toString() {
        return directionToString() + " ship of length " + length + " at " + locationToString();
    }
}