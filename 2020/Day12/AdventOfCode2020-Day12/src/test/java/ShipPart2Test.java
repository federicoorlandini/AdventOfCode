import com.adventofcode.day12.ShipPart2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShipPart2Test {
    @Test
    public void command_shouldMoveTheShipInTheProperPosition() {
        var commands = new String[] {
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        };

        var ship = new ShipPart2();
        for (var command: commands) {
            ship.execute(command);
        }

        // east 17, south 8
        Assertions.assertEquals("E214", ship.getLongitude());
        Assertions.assertEquals("S72", ship.getLatitude());
    }
}
