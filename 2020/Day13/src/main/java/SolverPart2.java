import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SolverPart2 {
    private class Bus {
        private int ID;
        private int offset;

        public Bus(int id, int offset) {

        }

        public int getID() {
            return ID;
        }

        public int getOffset() {
            return offset;
        }
    }

    private Bus[] parseInput(String input) {
        var inputItems = Arrays.stream(input.split(",")).toArray(String[]::new);
        var buses = new ArrayList<Bus>();
        for (var index: IntStream.range(0, inputItems.length).toArray()) {
            if( !inputItems[index].equals("x")) {
                buses.add(new Bus(Integer.parseInt(inputItems[index]), index));
            }
        }

        return buses.toArray(Bus[]::new);
    }

    protected int solve(int arrivalTime, int[] busIDs) {

    }
}
