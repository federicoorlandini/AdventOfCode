package com.adventofcode.day12;

public class Waypoint {
    private int latitude;
    private int longitude;

    public Waypoint(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void moveNorth(int value) {
        latitude += value;
    }

    public void moveEast(int value) {
        longitude += value;
    }

    public void moveSouth(int value) {
        latitude -= value;
    }

    public void moveWest(int value) {
        longitude -= value;
    }

    public void rotate(int degree) {
        // Convert degree in radiants
        var angle = Math.toRadians(degree);
        // Compute the rotation matrix
        // The angle is positive when rotating clockwise
        // +-                    -+
        // | cos angle  sin angle |
        // | -sin angle cos angle |
        // +-                    -+
        var newLongitude = (int)Math.round(longitude * Math.cos(angle) + latitude * Math.sin(angle));
        var newLatitude =  (int)Math.round(latitude * Math.cos(angle) - longitude * Math.sin(angle));

        latitude = newLatitude;
        longitude = newLongitude;
    }
}
