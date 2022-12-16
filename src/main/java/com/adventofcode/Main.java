package com.adventofcode;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvalidAlgorithmParameterException {
        String [] layout = {
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"};


        var waitingRoom = new WaitingArea(layout);
        while (!waitingRoom.isLayoutStable()) {
            waitingRoom.next();
        }

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
    };
}
