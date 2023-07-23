import kotlin.test.Test
import kotlin.test.assertEquals

class SequenceNumberProcessorPart2Tests {
    // These are the tests for the first part of the puzzle
    val endTurn = 30000000

    @Test
    fun testScenario1() {
        // Given 0,3,6, the 30000000th number spoken is 175594.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(0)
        processor.declareNumber(3)
        processor.declareNumber(6)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(175594, processor.answer)
    }

    @Test
    fun testScenario2() {
        // Given 1,3,2, the 30000000th number spoken is 2578.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(1)
        processor.declareNumber(3)
        processor.declareNumber(2)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(2578, processor.answer)
    }

    @Test
    fun testScenario3() {
        // Given 2,1,3, the 30000000th number spoken is 3544142.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(2)
        processor.declareNumber(1)
        processor.declareNumber(3)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(3544142, processor.answer)
    }

    @Test
    fun testScenario4() {
        // Given 1,2,3, the 30000000th number spoken is 261214.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(1)
        processor.declareNumber(2)
        processor.declareNumber(3)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(261214, processor.answer)
    }


    @Test
    fun testScenario5() {
        // Given 2,3,1, the 30000000th number spoken is 6895259.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(2)
        processor.declareNumber(3)
        processor.declareNumber(1)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(6895259, processor.answer)
    }


    @Test
    fun testScenario6() {
        // Given 3,2,1, the 30000000th number spoken is 18.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(3)
        processor.declareNumber(2)
        processor.declareNumber(1)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(18, processor.answer)
    }

    @Test
    fun testScenario7() {
        // Given 3,1,2, the 30000000th number spoken is 362.
        val processor = SequenceNumberProcessor()
        processor.declareNumber(3)
        processor.declareNumber(1)
        processor.declareNumber(2)

        while (processor.currentTurn < endTurn - 1) {  // The spoken number at turn 30000000th is the result of turn 29999999th
            processor.declareNumber(processor.answer)
        }

        assertEquals(362, processor.answer)
    }
}