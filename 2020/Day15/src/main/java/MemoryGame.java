import java.util.HashMap;

public class MemoryGame {
    private long turnNumber;

    private final HashMap<Long, Long> memory = new HashMap<>();

    public MemoryGame(Long[] initialSequence) {
        
    }

    /*
     * Return the actual turn number
     */
    public long getTurnNumber() {
        return turnNumber;
    }

    /*
     * Returns the next number in the game
     */
    public int next() {
        return 0;
    }
}
