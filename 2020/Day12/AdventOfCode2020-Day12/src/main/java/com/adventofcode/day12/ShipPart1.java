package com.adventofcode.day12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShipPart1 {
    protected final Pattern COMMAND_PATTERN = Pattern.compile("([NSEWLRF])(\\d+)", Pattern.CASE_INSENSITIVE);
    private int heading;
    protected int latitude;
    protected int longitude;

    public ShipPart1() {
        heading = 90; // Pointing East
    }

    public String getLatitude() {
        if( latitude >= 0) {
            return "N" + latitude;
        } else {
            return "S" + Math.abs(latitude);
        }
    }

    public String getLongitude() {
        if( longitude >= 0) {
            return "E" + longitude;
        } else {
            return "W" + Math.abs(longitude);
        }
    }

    public int getHeading() {
        return heading;
    }

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
                latitude += value;
                break;
            case "S":
                latitude -= value;
                break;
            case "E":
                longitude += value;
                break;
            case "W":
                longitude -= value;
                break;
            case "L":
                updateHeading(-value);
                break;
            case "R":
                updateHeading(value);
                break;
            case "F":
                forward(value);
                break;
            default:
                throw new IllegalArgumentException(String.format("The command %s is unknown.", cmd));
        }
    }

    private void forward(int value) {
        switch (heading) {
            case 0:
                // Moving to North
                latitude += value;
                break;
            case 90:
                // Moving to East
                longitude += value;
                break;
            case 180:
                // Moving to South
                latitude -= value;
                break;
            case 270:
                // Moving West
                longitude -= value;
                break;
            default:
                throw new IllegalStateException(String.format("The value %s for the heading is invalid.", heading));
        }
    }

    private void updateHeading(int value) {
        heading += value;
        if( heading < 0) {
            heading += 360;
        } else if( heading >= 360 ) {
            heading -= 360;
        }
    }
}
