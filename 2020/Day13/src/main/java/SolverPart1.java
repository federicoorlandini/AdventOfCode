import java.util.Arrays;

public class SolverPart1 {
    public int solve(int arrivalTime, String availableBusIDs) {
        var busIDs = parseBusesIDs(availableBusIDs);
        return solve(arrivalTime, busIDs);
    }

    protected int solve(int arrivalTime, int[] busIDs) {
        int currentArrivalTime = arrivalTime;
        while(true) {
            System.out.print(String.format("Current arrival time: %s\r", currentArrivalTime));

            for (var busId: busIDs) {
                if( currentArrivalTime % busId == 0) {
                    return (currentArrivalTime - arrivalTime) * busId;
                }
            }

            currentArrivalTime += 1;
        }
    }

    private static int[] parseBusesIDs(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.equals("x"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
    }
}
