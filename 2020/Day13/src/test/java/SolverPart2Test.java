import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolverPart2Test {
    private SolverPart2 solver = new SolverPart2();

    @Test
    public void solve_shouldReturnTheProperResult_scenario_1() {
        // Scenario 1
        // Input:
        // 939
        // 7,13,x,x,59,x,31,19
        // Result: 1068781
        var result = solver.solve(939, "7,13,x,x,59,x,31,19");
        Assertions.assertEquals(1068781, result);
    }

    @Test
    public void solve_shouldReturnTheProperResult_scenario_2() {
        // Scenario 2
        // Input:
        // 939
        // 17,x,13,19
        // Result: 3417
        var result = solver.solve(939, "17,x,13,19");
        Assertions.assertEquals(3417, result);
    }

    @Test
    public void solve_shouldReturnTheProperResult_scenario_3() {
        // Scenario 3
        // Input:
        // 939
        // 67,7,59,61
        // Result: 754018
        var result = solver.solve(939, "67,7,59,61");
        Assertions.assertEquals(754018, result);
    }

    @Test
    public void solve_shouldReturnTheProperResult_scenario_4() {
        // Scenario 4
        // Input:
        // 939
        // 67,x,7,59,61
        // Result: 779210
        var result = solver.solve(939, "67,x,7,59,61");
        Assertions.assertEquals(779210, result);
    }

    @Test
    public void solve_shouldReturnTheProperResult_scenario_5() {
        // Scenario 5
        // Input:
        // 939
        // 67,7,x,59,61
        // Result: 1261476
        var result = solver.solve(939, "67,7,x,59,61");
        Assertions.assertEquals(1261476, result);
    }

    @Test
    public void solve_shouldReturnTheProperResult_scenario_6() {
        // Scenario 6
        // Input:
        // 939
        // 1789,37,47,1889
        // Result: 1202161486
        var result = solver.solve(939, "1789,37,47,1889");
        Assertions.assertEquals(1202161486, result);
    }
}
