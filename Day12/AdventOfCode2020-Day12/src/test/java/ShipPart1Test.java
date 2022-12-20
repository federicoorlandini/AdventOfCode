import com.adventofcode.day12.ShipPart1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShipPart1Test {
    @Test
    public void command_shouldMoveTheShipInTheProperPosition() {
        var commands = new String[] {
            "F10",
            "N3",
            "F7",
            "R90",
            "F11"
        };

        var ship = new ShipPart1();
        for (var command: commands) {
            ship.execute(command);
        }

        // east 17, south 8
        Assertions.assertEquals("E17", ship.getLongitude());
        Assertions.assertEquals("S8", ship.getLatitude());
    }
}
