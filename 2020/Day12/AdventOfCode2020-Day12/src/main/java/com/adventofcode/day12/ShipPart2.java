package com.adventofcode.day12;

import java.util.regex.Matcher;

public class ShipPart2 extends ShipPart1 {
    private final Waypoint waypoint = new Waypoint(1, 10);   // 1N, 10E

    public void execute(String command) {
        // Parse the command
        Matcher matcher = COMMAND_PATTERN.matcher(command);
        if(!matcher.find()) {
            throw new IllegalArgumentException(String.format("The command %s doesn't match the command pattern", command));
        }
        var cmd = matcher.group(1);
        var value = Integer.parseInt(matcher.group(2));

        switch (cmd) {
            case "N":
                waypoint.moveNorth(value);
                break;
            case "S":
                waypoint.moveSouth(value);
                break;
            case "E":
                waypoint.moveEast(value);
                break;
            case "W":
                waypoint.moveWest(value);
                break;
            case "L":
                waypoint.rotate(-value);
                break;
            case "R":
                waypoint.rotate(value);
                break;
            case "F":
                forward(value);
                break;
            default:
                throw new IllegalArgumentException(String.format("The command %s is unknown.", cmd));
        }
    }

    private void forward(int value) {
        // Moving vector for the ship
        var move_latitude = waypoint.getLatitude() * value;
        var move_longitude = waypoint.getLongitude() * value;

        // Update the ship position
        latitude += move_latitude;
        longitude += move_longitude;
    }
}
