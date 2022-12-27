import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Cpu {
    private final Map<Long, Long> memory = new HashMap<Long, Long>();

    public void process(String[] commands) {
        for (var command: commands) {
            process(command);
        }
    }

    private void process(String command) {
        if( command.startsWith("mask")) {
            setMask(command);
        } else if (command.startsWith("mem")) {
            setMem(command);
        } else {
            throw new InputMismatchException(String.format("Unknown command %s", command));
        }
    }

    private void setMask(String command) {
        // Parse the command
        var maskValue = command.split("=")[1].trim();

    }

    private void setMem(String command) {

    }

    public long readMemory(long address) {
        if( !memory.containsKey(address)) {
            return 0;
        } else {
            return memory.get(address);
        }
    }

    public long sumMemory() {
        return memory
            .entrySet()
            .stream()
            .mapToLong(item -> item.getValue())
            .sum();
    }
}