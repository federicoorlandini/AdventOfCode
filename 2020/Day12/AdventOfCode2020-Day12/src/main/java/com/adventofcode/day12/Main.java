package com.adventofcode.day12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        part2();
    }

    /*
     * This is the first part of the puzzle
     */
    private static void part1() throws IOException {
        var commands = loadInputFromResources("inputPart1.txt");

        var ship = new ShipPart1();
        for (var command: commands) {
            ship.execute(command);
        }

        // get the latitude and longitude
        var finalLatitude = ship.getLatitude();
        var finalLongitude = ship.getLongitude();

        System.out.println(String.format("The Manhattan distance is: %s",
                Integer.parseInt(finalLatitude.substring(1)) +
                        Integer.parseInt(finalLongitude.substring(1))));
    }

    private static void part2() throws IOException {
        var commands = loadInputFromResources("inputPart1.txt");

        var ship = new ShipPart2();
        for (var command: commands) {
            ship.execute(command);
        }

        // get the latitude and longitude
        var finalLatitude = ship.getLatitude();
        var finalLongitude = ship.getLongitude();

        System.out.println(String.format("The Manhattan distance is: %s",
                Integer.parseInt(finalLatitude.substring(1)) +
                        Integer.parseInt(finalLongitude.substring(1))));
    }

    private static String[] loadInputFromResources(String filename) throws IOException {
        Path path = Paths.get(Main.class.getClassLoader().getResource(filename)
                .getPath());
        var allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return allLines.toArray(String[]::new);
    }
}
