import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CpuV1Tests {
    @Test
    public void process_scenario1() {
        String[] commands = new String[] {
            "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
            "mem[8] = 11",
            "mem[7] = 101",
            "mem[8] = 0"
        };

        var cpu = new CpuV1();
        cpu.process(commands);

        Assertions.assertEquals(101, cpu.readMemory(7));
        Assertions.assertEquals(64, cpu.readMemory(8));
        Assertions.assertEquals(165, cpu.sumMemory());
    }
}
