import kotlin.test.*

class TicketCheckerTests {
    @Test
    fun isValidTicketScenario1() {
        // Given the following fields:
        // class: 1-3 or 5-7
        // row: 6-11 or 33-44
        // seat: 13-40 or 45-50
        // Then the following ticket is valid:
        // 7,3,47
        // And the following tickets are invalid and have the following error code:
        // 40,4,50 - error code 4
        // 55,2,20 - error code 55
        // 38,6,12 - error code 12

        val ticketFields = listOf(
            TicketField("class", listOf(Pair(1, 3), Pair(5, 7))),
            TicketField("row", listOf(Pair(6, 11), Pair(33, 44))),
            TicketField("seat", listOf(Pair(13, 40), Pair(45, 50))))

        val ticketChecker = TicketChecker(ticketFields)

        val validTicket = listOf(7, 3, 47)
        val (validTicketResult, validTicketErrorCode) = ticketChecker.isValidTicket(validTicket)
        assertTrue(validTicketResult)    // The ticket is valid
        assertEquals(0, validTicketErrorCode) // Error code is zero

        val invalidTicket1 = listOf(40, 4, 50)
        val (invalidTicket1Result, invalidTicket1ErrorCode) = ticketChecker.isValidTicket(invalidTicket1)
        assertFalse(invalidTicket1Result)    // The ticket is invalid
        assertEquals(4, invalidTicket1ErrorCode) // Error code is 4

        val invalidTicket2 = listOf(55, 2, 20)
        val (invalidTicket1Result2, invalidTicket1ErrorCode2) = ticketChecker.isValidTicket(invalidTicket2)
        assertFalse(invalidTicket1Result2)    // The ticket is invalid
        assertEquals(55, invalidTicket1ErrorCode2) // Error code is 55

        val invalidTicket3 = listOf(38, 6, 12)
        val (invalidTicket1Result3, invalidTicket1ErrorCode3) = ticketChecker.isValidTicket(invalidTicket3)
        assertFalse(invalidTicket1Result3)    // The ticket is invalid
        assertEquals(12, invalidTicket1ErrorCode3) // Error code is 12
    }
}