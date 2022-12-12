package com.adventofcode;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidAlgorithmParameterException;
import java.util.stream.IntStream;

public class WaitingRoomTests {
    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep1() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        };

        var expectedLayout = new String[] {
            "#.##.##.##",
            "#######.##",
            "#.#.#..#..",
            "####.##.##",
            "#.##.##.##",
            "#.#####.##",
            "..#.#.....",
            "##########",
            "#.######.#",
            "#.#####.##"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }

    /*
     * Assert that the two layouts are the same
     */
    private void assertLayouts(String[] layout, String[] expectedLayout) {
        // Check the number of rows
        Assertions.assertEquals(layout.length, expectedLayout.length, "The layout has a wrong number of rows");
        for (var rowIndex: IntStream.range(0, layout.length).toArray()) {
            // For each row, check the number of columns
            Assertions.assertEquals(layout[rowIndex].length(), expectedLayout[rowIndex].length());
            Assertions.assertTrue(layout[rowIndex].equals(expectedLayout[rowIndex]), String.format("The row %s doesn't contain the expected values", rowIndex));
        }
    }

    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep2() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
                "#.##.##.##",
                "#######.##",
                "#.#.#..#..",
                "####.##.##",
                "#.##.##.##",
                "#.#####.##",
                "..#.#.....",
                "##########",
                "#.######.#",
                "#.#####.##"
        };

        var expectedLayout = new String[] {
            "#.LL.LL.L#",
            "#LLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLL#",
            "#.LLLLLL.L",
            "#.LLLLL.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }

    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep3() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "#.LL.LL.L#",
            "#LLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLL#",
            "#.LLLLLL.L",
            "#.LLLLL.L#"
        };

        var expectedLayout = new String[] {
            "#.L#.##.L#",
            "#L#####.LL",
            "L.#.#..#..",
            "##L#.##.##",
            "#.##.#L.##",
            "#.#####.#L",
            "..#.#.....",
            "LLL####LL#",
            "#.L#####.L",
            "#.L####.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }
    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep4() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "#.L#.##.L#",
            "#L#####.LL",
            "L.#.#..#..",
            "##L#.##.##",
            "#.##.#L.##",
            "#.#####.#L",
            "..#.#.....",
            "LLL####LL#",
            "#.L#####.L",
            "#.L####.L#"
        };

        var expectedLayout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##LL.LL.L#",
            "L.LL.LL.L#",
            "#.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }

    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep5() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##LL.LL.L#",
            "L.LL.LL.L#",
            "#.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        var expectedLayout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##L#.#L.L#",
            "L.L#.#L.L#",
            "#.L####.LL",
            "..#.#.....",
            "LLL###LLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }

    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep6() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##L#.#L.L#",
            "L.L#.#L.L#",
            "#.L####.LL",
            "..#.#.....",
            "LLL###LLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        var expectedLayout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##L#.#L.L#",
            "L.L#.LL.L#",
            "#.LLLL#.LL",
            "..#.L.....",
            "LLL###LLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }

    @Test
    public void next_shouldGenerateTheCorrectNextLayoutStep7() throws InvalidAlgorithmParameterException {
        var layout = new String[] {
            "#.L#.L#.L#",
            "#LLLLLL.LL",
            "L.L.L..#..",
            "##L#.#L.L#",
            "L.L#.LL.L#",
            "#.LLLL#.LL",
            "..#.L.....",
            "LLL###LLL#",
            "#.LLLLL#.L",
            "#.L#LL#.L#"
        };

        // The same initial layout
        var expectedLayout = new String[] {
                "#.L#.L#.L#",
                "#LLLLLL.LL",
                "L.L.L..#..",
                "##L#.#L.L#",
                "L.L#.LL.L#",
                "#.LLLL#.LL",
                "..#.L.....",
                "LLL###LLL#",
                "#.LLLLL#.L",
                "#.L#LL#.L#"
        };

        var waitingArea = new WaitingArea(layout);
        layout = waitingArea.next();

        assertLayouts(layout, expectedLayout);
    }
}
