package main.java;

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

    private String[] layout;

    public WaitingArea(String[] initialLayout) {
        layout = initialLayout;
    }

    public String[] next() {
        layout = computeNextLayout();
        return layout;
    }

    /*
     * Given the current layout, this method computes the next layout
     */
    private String[] computeNextLayout() {
        // Process each element of the layout
        for (int rowIndex: IntStream.range(0, LAYOUT_HEIGTH).toArray()) {
            for (int columnIndex: IntStream.range(0, LAYOUT_WIDTH).toArray()) {
                char element = layout[rowIndex].charAt(columnIndex);
                if( element == NO_SEAT ) {
                    continue;
                }

                // Get the sits visible in each line of sights
                // North
                var sitN = seatInLineOfSight(rowIndex, columnIndex, -1, 0, layout);
                // North-East
                var sitNE = seatInLineOfSight(rowIndex, columnIndex, -1, 1, layout);
                // East
                var sitE = seatInLineOfSight(rowIndex, columnIndex, 0, 1, layout);
                // South-East
                var sitSE = seatInLineOfSight(rowIndex, columnIndex, 1, 1, layout);
                // South
                var sitS = seatInLineOfSight(rowIndex, columnIndex, 1, 0, layout);
                // South-West
                var sitSW = seatInLineOfSight(rowIndex, columnIndex, 1, -1, layout);
                // West
                var sitW = seatInLineOfSight(rowIndex, columnIndex, 0, -1, layout);
                // North-West
                var sitNW = seatInLineOfSight(rowIndex, columnIndex, -1, -1, layout);
            }
        }

        return layout;
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
        StringBuffer lineOfSight = new StringBuffer();
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
