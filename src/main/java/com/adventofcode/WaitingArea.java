package com.adventofcode;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * This class models the waiting area where our traveler is and where he's analysing how
 * the other waiting travelers choose the seat where sit down.
 */
public class WaitingArea {
    // The possible statuses for each element of the layout
    public static final char NO_SEAT = '.';
    public static final char EMPTY_SEAT = 'L';
    public static final char OCCUPIED_SEAT = '#';

    private static final int  LAYOUT_WIDTH = 10;
    private static final int  LAYOUT_HEIGTH = 10;

    private String[] currentLayout;
    private String[] previousLayout;

    public String[] getCurrentLayout() {
        return currentLayout;
    }

    public WaitingArea(String[] initialLayout) {
        currentLayout = initialLayout;
    }

    /*
     * Compute the next layout based on the current one
     */
    public String[] next() throws InvalidAlgorithmParameterException {
        previousLayout = currentLayout;
        currentLayout = computeNextLayout();
        return currentLayout;
    }

    /*
     * Return TRUE only if the current layout didn't change if compared with the previous one
     */
    public boolean isLayoutStable() {
        if( currentLayout == null || previousLayout == null ) {
            return false;
        }

        return Arrays.equals(previousLayout, currentLayout);
    }

    /*
     * Given the current layout, this method computes the next layout
     */
    private String[] computeNextLayout() throws InvalidAlgorithmParameterException {
        var nextLayout = new String[LAYOUT_HEIGTH];

        // Process each element of the layout
        for (int rowIndex: IntStream.range(0, LAYOUT_HEIGTH).toArray()) {
            var newLayoutRow = new StringBuilder();
            for (int columnIndex: IntStream.range(0, LAYOUT_WIDTH).toArray()) {
                char element = currentLayout[rowIndex].charAt(columnIndex);
                char newElement;
                if( element == NO_SEAT ) {
                    newElement = element;
                }
                else {
                    // Get the sits visible in each line of sights
                    // North
                    var sitsN = seatInLineOfSight(rowIndex, columnIndex, -1, 0, currentLayout);
                    // North-East
                    var sitsNE = seatInLineOfSight(rowIndex, columnIndex, -1, 1, currentLayout);
                    // East
                    var sitsE = seatInLineOfSight(rowIndex, columnIndex, 0, 1, currentLayout);
                    // South-East
                    var sitsSE = seatInLineOfSight(rowIndex, columnIndex, 1, 1, currentLayout);
                    // South
                    var sitsS = seatInLineOfSight(rowIndex, columnIndex, 1, 0, currentLayout);
                    // South-West
                    var sitsSW = seatInLineOfSight(rowIndex, columnIndex, 1, -1, currentLayout);
                    // West
                    var sitsW = seatInLineOfSight(rowIndex, columnIndex, 0, -1, currentLayout);
                    // North-West
                    var sitsNW = seatInLineOfSight(rowIndex, columnIndex, -1, -1, currentLayout);

                    var sits = String.valueOf(sitsN) +
                            sitsNE +
                            sitsE +
                            sitsSE +
                            sitsS +
                            sitsSW +
                            sitsW +
                            sitsNW;

                    newElement = applyLogic(element, sits);
                }

                newLayoutRow.append(newElement);
            }

            // Add the new layout row to the array of rows
            nextLayout[rowIndex] = newLayoutRow.toString();
        }

        return nextLayout;
    }

    private char applyLogic(char element, String seats) throws InvalidAlgorithmParameterException {
        // BUSINESS LOGIC
        // Also, people seem to be more tolerant than you expected: it now takes five or more visible occupied seats for
        // an occupied seat to become empty (rather than four or more from the previous rules).
        // The other rules still apply: empty seats that see no occupied seats become occupied,
        // seats matching no rule don't change, and floor never changes.

        var numberOfOccupiedSeats = seats.chars().filter(c -> c == OCCUPIED_SEAT).count();

        switch (element) {
            case NO_SEAT:
                return NO_SEAT;

            case EMPTY_SEAT:
                if( numberOfOccupiedSeats < 1) {
                    return OCCUPIED_SEAT;
                }
                else {
                    return EMPTY_SEAT;
                }

            case OCCUPIED_SEAT:
                if( numberOfOccupiedSeats < 5) {
                    return OCCUPIED_SEAT;
                }
                else {
                    return EMPTY_SEAT;
                }
            default:
                throw new InvalidAlgorithmParameterException(String.format("Unexpected element: {0}", element));
        }
    }

    /*
     * Given a starting point in the layout (startX and startY) and step direction (stepX and step Y)
     * the method returns the visible element in the line of sight specified by stepRow and stepColumn values
     */
    private char seatInLineOfSight(int startRow, int startColumn, int stepRow, int stepColumn, String[] layout) {
        var elementsInLineOfSight = getAllSeatsInLineOfSight(startRow, startColumn, stepRow, stepColumn, layout);
        for (char element: elementsInLineOfSight.toCharArray()) {
            switch (element) {
                case EMPTY_SEAT: case OCCUPIED_SEAT:
                    return element;
            }
        }
        // If we reach this point, then all the elements in the line of sight are '.'
        return NO_SEAT;
    }

    /*
     * Given a starting point in the layout (startX and startY) and step direction (stepX and step Y)
     * the method returns a string containing all the layout element in the line of sight specified by
     * stepRow and stepColumn values
     */
    private String getAllSeatsInLineOfSight(int startRow, int startColumn, int stepRow, int stepColumn, String[] layout) {
        StringBuilder lineOfSight = new StringBuilder();
        var row = startRow + stepRow;
        var column = startColumn + stepColumn;
        while(!isPositionOutOfBounds(row, column)) {
            lineOfSight.append(layout[row].charAt(column));
            row += stepRow;
            column += stepColumn;
        }

        return lineOfSight.toString();
    }

    private Boolean isPositionOutOfBounds(int row, int column) {
        return(row < 0 || row >= LAYOUT_HEIGTH || column < 0 || column >= LAYOUT_WIDTH );
    }
}
