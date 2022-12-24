import java.util.Arrays;

public class Solver {
    public solve(int arrivalTime, String availableBusIDs) {
        var busIDs = parseBusesIDs(availableBusIDs);
        
    }

    private static int[] parseBusesIDs(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> s != "x")
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
    }
}
