package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, IOException {
        /* String [] layout = {
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"}; */

        var layout = loadLayoutFromResources();

        var waitingRoom = new WaitingArea(layout);
        waitingRoom.runAnStopWhenLayoutStable();

        // Count how many seats are occupied
        var currentLayout = waitingRoom.getCurrentLayout();
        var result = Arrays.stream(Arrays
                .stream(currentLayout)
                .mapToLong(row -> row
                        .chars()
                        .filter(c -> c == WaitingArea.OCCUPIED_SEAT)
                        .count())
                .toArray()).sum();

        System.out.println(String.format("Result: %s", result));
    }

    private static String[] loadLayoutFromResources() throws IOException {
        Path path = Paths.get(Main.class.getClassLoader().getResource("layout.txt")
                .getPath());
        var allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return allLines.toArray(String[]::new);
    }
}
