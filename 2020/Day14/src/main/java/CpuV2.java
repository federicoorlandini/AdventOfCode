public class CpuV2 extends CpuV1 {
    private String mask;
    private void setMask(String command) {
        // Parse the command
        mask = command.split("=")[1].trim();
    }
    private void setMem(String command) {

    }

    private void setMem(long address, long value) {
        
    }
}
