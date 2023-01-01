import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CpuV2Tests {
    @Test
    public void process_scenario1() {
        String[] commands = new String[] {
            "mask = 000000000000000000000000000000X1001X",
            "mem[42] = 100",
            "mask = 00000000000000000000000000000000X0XX",
            "mem[26] = 1"
        };

        var cpu = new CpuV2();
        cpu.process(commands);

        Assertions.assertEquals(208, cpu.sumMemory());
    }
}
