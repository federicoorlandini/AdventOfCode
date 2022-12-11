package com.adventofcode;

import java.security.InvalidAlgorithmParameterException;
import java.util.stream.IntStream;

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
        waitingRoom.next();
    };
}
