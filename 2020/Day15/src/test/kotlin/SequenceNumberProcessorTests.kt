//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Test
import kotlin.test.Test
import kotlin.test.assertEquals

class SequenceNumberProcessorTests {
    @Test
    fun testScenarioDescription() {
        // This is the test scenario as described in the task description
        val processor = SequenceNumberProcessor()

        // Suppose the starting numbers are 0,3,6:
        // Turn 1: The 1st number spoken is a starting number, 0.
        processor.process(0)

        // Turn 2: The 2nd number spoken is a starting number, 3.
        processor.process(3)

        // Turn 3: The 3rd number spoken is a starting number, 6.
        processor.process(6)

        // Turn 4: Now, consider the last number spoken, 6. Since that was the first time the number had been spoken, the 4th number spoken is 0.
        assertEquals(processor.result, 0)
        processor.process(processor.result)

        // Turn 5: Next, again consider the last number spoken, 0. Since it had been spoken before, the next number to speak is the difference between the turn number when it was last spoken (the previous turn, 4) and the turn number of the time it was most recently spoken before then (turn 1). Thus, the 5th number spoken is 4 - 1, 3.
        processor.process(processor.result)
        assertEquals(processor.result, 3)

    // Turn 6: The last number spoken, 3 had also been spoken before, most recently on turns 5 and 2. So, the 6th number spoken is 5 - 2, 3.
        // Turn 7: Since 3 was just spoken twice in a row, and the last two turns are 1 turn apart, the 7th number spoken is 1.
        // Turn 8: Since 1 is new, the 8th number spoken is 0.
        // Turn 9: 0 was last spoken on turns 8 and 4, so the 9th number spoken is the difference between them, 4.
        // Turn 10: 4 is new, so the 10th number spoken is 0.
    }

    @Test
    fun testScenario1() {
        // Given the starting numbers 1,3,2, the 2020th number spoken is 1.
        assert(false)
    }

    @Test
    fun testScenario2() {
        //Given the starting numbers 2,1,3, the 2020th number spoken is 10.
        assert(false)
    }

    @Test
    fun testScenario3() {
        //Given the starting numbers 1,2,3, the 2020th number spoken is 27.
        assert(false)
    }

    @Test
    fun testScenario4() {
        //Given the starting numbers 2,3,1, the 2020th number spoken is 78.
        assert(false)
    }

    @Test
    fun testScenario5() {
        //Given the starting numbers 3,2,1, the 2020th number spoken is 438.
        assert(false)
    }

    @Test
    fun testScenario6() {
        //Given the starting numbers 3,1,2, the 2020th number spoken is 1836.
        assert(false)
    }
}