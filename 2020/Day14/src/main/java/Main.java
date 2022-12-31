import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Part1();

        Part2();
    }

    private static void Part1() throws IOException {
        // Read the data
        ArrayList<String> lines = readInpuData("input_part1.txt");

        // Process the data
        var cpu = new CpuV1();
        cpu.process(lines.toArray(String[]::new));

        System.out.println(String.format("Result: %s", cpu.sumMemory()));
    }

    private static void Part2() throws IOException {
        var input = readInpuData("input_part2.txt");
    }

    private static ArrayList<String> readInpuData(String filename) throws IOException {
        var classLoader = ClassLoader.getSystemClassLoader();
        var inputStream = classLoader.getResourceAsStream(filename);
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
