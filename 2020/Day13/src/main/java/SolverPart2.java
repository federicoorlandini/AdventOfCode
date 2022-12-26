import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SolverPart2 {
    private class Bus {
        public int ID;
        public int offset;
    }

    private class Match {
        public long time;
        public long increment;
    }

    private Bus[] parseInput(String input) {
        var inputItems = Arrays.stream(input.split(",")).toArray(String[]::new);
        var buses = new ArrayList<Bus>();
        for (var index: IntStream.range(0, inputItems.length).toArray()) {
            if( !inputItems[index].equals("x")) {
                var newBus = new Bus();
                newBus.ID = Integer.parseInt(inputItems[index]);
                newBus.offset = index;
                buses.add(newBus);
            }
        }

        return buses.toArray(Bus[]::new);
    }

    protected long solve(long time, String input) {
        var buses = parseInput(input);
        var increment = 1L;
        for (var bus: buses) {
            System.out.println(String.format("Processing bus with ID %s", bus.ID));
            var match = findNextMatchingTime(time, bus.ID, bus.offset, increment);
            increment = match.increment;
            time = match.time;
            System.out.println(String.format("Found match at %s. New increment is %s", time, increment));
        }

        return time;
    }

    private Match findNextMatchingTime(long time, int busId, int offset, long increment) {
        while(true) {
            System.out.print(String.format("Processing time %s\r", time));
            if( (time + offset) % busId == 0 ) {
                var match = new Match();
                match.time = time;
                match.increment = increment * busId;
                return match;
            }

            time += increment;
        }
    }
}
