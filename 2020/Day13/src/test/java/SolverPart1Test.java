import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolverPart1Test {
    @Test
    public void solve_shouldReturnTheProperResult() {
        var arrivalTime = 939;
        var busIDsList = "7,13,x,x,59,x,31,19";

        var solver = new SolverPart1();
        var solution = solver.solve(arrivalTime, busIDsList);

        Assertions.assertEquals(295 ,solution);
    }
}
