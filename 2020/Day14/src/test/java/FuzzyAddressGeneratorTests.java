import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FuzzyAddressGeneratorTests {
    @Test
    public void generateAddresses_shouldGenerateTheCorrectAddresses() {
        var baseAddress = "000000000000000000000000000000X1101X";

        var generatedAddresses = new ArrayList<String>();
        FuzzyAddressGenerator.generateAddresses(baseAddress, generatedAddresses);

        Assertions.assertEquals(4, generatedAddresses.stream().count());
        Assertions.assertTrue(generatedAddresses.stream().anyMatch(item -> item.equals("000000000000000000000000000000011010")));
        Assertions.assertTrue(generatedAddresses.stream().anyMatch(item -> item.equals("000000000000000000000000000000011011")));
        Assertions.assertTrue(generatedAddresses.stream().anyMatch(item -> item.equals("000000000000000000000000000000111010")));
        Assertions.assertTrue(generatedAddresses.stream().anyMatch(item -> item.equals("000000000000000000000000000000111011")));
    }
}
