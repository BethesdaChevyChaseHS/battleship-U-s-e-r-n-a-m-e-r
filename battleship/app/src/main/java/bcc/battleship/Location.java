package bcc.battleship;

public class Location {
    // Instance variables
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;

    private boolean hasShip;
    private int status;
    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location() {
        this.hasShip = false;
        this.status = UNGUESSED;
    }

    // Was this Location a hit?
    public boolean checkHit() {
        return status == HIT;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        return status == MISSED;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        return status == UNGUESSED;
    }

    // Mark this location as a hit.
    public void markHit() {
        status = HIT;
    }

    // Mark this location as a miss.
    public void markMiss() {
        status = MISSED;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return hasShip;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) {
        this.hasShip = val;
    }

    // Set the status of this Location.
    public void setStatus(int status) {
        this.status = status;
    }

    // Get the status of this Location.
    public int getStatus() {
        return status;
    }
}
