import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;

public class CpuV2 extends CpuV1 {
    private String mask;

    @Override
    protected void setMask(String command) {
        // Parse the command
        mask = command.split("=")[1].trim();
    }

    @Override
    protected void setMem(String command) {
        // Parse the address and the value
        Matcher m = MEMSET_COMMAND_PATTERN.matcher(command);
        if (!m.find( )) {
            throw new InvalidParameterException(String.format("The command %s is invalid", command));
        }

        var address = Long.parseLong(m.group(1));
        var value = Long.parseLong(m.group(2));

        // Convert the address into binary representation and get the 36 less significant bits
        var binaryAddress = Long.toBinaryString(address);
        if( binaryAddress.length() < 36 ) {
            // Fill with most significative zeros
            binaryAddress = String.format("%36s", binaryAddress).replace(' ', '0');
        }

        // Let's process bit-by-bit using the following rules:
        // If the bitmask bit is 0, the corresponding memory address bit is unchanged.
        // If the bitmask bit is 1, the corresponding memory address bit is overwritten with 1.
        // If the bitmask bit is X, the corresponding memory address bit is floating.
        var maskedAddress = generateMaskedAddress(binaryAddress);

        // Process the floating bit in the address, generating all the addresses
        var addresses = new ArrayList<String>();
        FuzzyAddressGenerator.generateAddresses(maskedAddress, addresses);

        // Write the value in all the addresses
        addresses.forEach(addr -> {
            var addressValue = Long.parseLong(addr, 2);
            memory.put(addressValue, value);
        });
    }

    private String generateMaskedAddress(String address) {
        var maskedAddress = new StringBuilder();
        for (int index = 0; index < address.length(); index++) {
            var currentAddressBit = address.charAt(index);
            var currenMaskBit = mask.charAt(index);
            if( currenMaskBit != '0' && currenMaskBit != '1' && currenMaskBit != 'X') {
                throw new InputMismatchException(String.format("The bitMask %s is invalid.", currenMaskBit));
            }

            char maskedBit = switch (currenMaskBit) {
                case '0' -> currentAddressBit;
                case '1' -> '1';
                case 'X' -> 'X';
                default -> ' ';
            };

            maskedAddress.append(maskedBit);
        }

        return maskedAddress.toString();
    }


}
