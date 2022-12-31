import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cpu {
    private final Map<Long, Long> memory = new HashMap<Long, Long>();
    private long andMask = 1L;
    private long orMask = 0L;

    private final Pattern MEMSET_COMMAND_PATTERN = Pattern.compile("mem\\[(\\d+)\\] = (\\d+)");

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
        var mask = command.split("=")[1].trim();
        // Build the AND bitwise mask
        andMask = generateAndMask(mask);
        // Build the OR bitwise mask
        orMask = generateOrMask(mask);
    }

    private long generateAndMask(String mask) {
        // Given a mask like 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X'
        // then the AND mask should be '111111111111111111111111111111111101'
        mask = mask.replace('X', '1');
        return Long.parseLong(mask, 2);
    }

    private long generateOrMask(String mask) {
        // Given a mask like 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X'
        // then the AND mask should be '000000000000000000000000000001000000'
        mask = mask.replace('X', '0');
        return Long.parseLong(mask, 2);
    }

    private void setMem(String command) {
        // Example: mem[18971] = 65392
        Matcher m = MEMSET_COMMAND_PATTERN.matcher(command);
        if (!m.find( )) {
            throw new InvalidParameterException(String.format("The command %s is invalid", command));
        }

        var address = Long.parseLong(m.group(1));
        var value = Long.parseLong(m.group(2));

        // Mask the value with the AND mask and OR mask
        value = value & andMask;
        value = value | orMask;

        memory.put(address, value);
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