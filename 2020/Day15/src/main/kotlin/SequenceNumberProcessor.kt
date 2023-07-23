class SequenceNumberProcessor {
    var result : Int = 0
        private set

    var currentTurn : Int = 0
        private set

    private val memory = mutableMapOf<Int, Int>()

    // This method gets the new number in the sequence and returns the
    // next number in the sequence
    fun process(number : Int) : Unit {
        var nextNumber : Int;
        currentTurn++

        // Check if the number has been already said
        if (memory.containsKey(number)) {
            var lastTurn = memory[number]!!
            memory[number] = currentTurn
            nextNumber = currentTurn - lastTurn
        }
        else {
            memory[number] = currentTurn
            nextNumber = 0
        }

        logTurnInfo(nextNumber)

        result = nextNumber
    }

    private fun logTurnInfo(number : Int) {
        println("Turn #$currentTurn: result $number")
    }
}