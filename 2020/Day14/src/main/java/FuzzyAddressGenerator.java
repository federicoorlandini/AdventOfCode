import java.util.ArrayList;

public class FuzzyAddressGenerator {
    public static void generateAddresses(String baseAddress, ArrayList<String> addresses) {
        if( !hasFuzzyBit(baseAddress)) {
            addresses.add(baseAddress);
            return;
        }

        // Continue to process the other fuzzy bits
        var maskedAddressWithZero = replaceFirstFuzzyBit(baseAddress, '0');
        System.out.println(String.format("Base   address: %s", baseAddress));
        System.out.println(String.format("masked address: %s", maskedAddressWithZero));
        generateAddresses(maskedAddressWithZero, addresses);
        var maskedAddressWithOne = replaceFirstFuzzyBit(baseAddress, '1');
        generateAddresses(maskedAddressWithOne, addresses);
    }

    private static String replaceFirstFuzzyBit(String maskedAddress, char replacingChar) {
        var firstIndexFuzzyBit = maskedAddress.indexOf('X');
        var beforePart = maskedAddress.substring(0, firstIndexFuzzyBit);
        var afterPart = maskedAddress.substring(firstIndexFuzzyBit + 1, maskedAddress.length());
        return beforePart + replacingChar + afterPart;
    }

    private static boolean hasFuzzyBit(String mask) {
        return mask.contains("X");
    }
}
