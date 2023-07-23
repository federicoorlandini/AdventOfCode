class SequenceNumberProcessor {
    var result : Int = 0
        private set

    private var turnCounter = 0
    private val memory = mutableMapOf<Int, Int>()

    // This method gets the new number in the sequence and returns the
    // next number in the sequence
    fun process(number : Int) : Unit {
        var nextNumber : Int;
        turnCounter++

        // Check if the number has been already said
        if (memory.containsKey(number)) {
            var lastTurn = memory[number]!!
            memory[number] = turnCounter
            nextNumber = turnCounter - lastTurn
        }
        else {
            memory[number] = turnCounter
            nextNumber = 0
        }

        logTurnInfo(nextNumber)

        result = nextNumber
    }

    private fun logTurnInfo(number : Int) {
        println("Turn #$turnCounter: result $number")
    }
}