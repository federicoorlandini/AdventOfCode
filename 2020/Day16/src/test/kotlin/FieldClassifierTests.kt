import kotlin.test.Test
import kotlin.test.assertEquals

class FieldClassifierTests {
    @Test
    fun findFieldScenario1() {
        // Ticket fields:
        // class: 0-1 or 4-19
        // row: 0-5 or 8-19
        // seat: 0-13 or 16-19
        val ticketFields = listOf(
            TicketField("class", listOf(Pair(0, 1), Pair(4, 19))),
            TicketField("row", listOf(Pair(0, 5), Pair(8, 19))),
            TicketField("seat", listOf(Pair(0, 13), Pair(16, 19))))

        // Nearby tickets:
        // 3,9,18
        // 15,1,5
        // 5,14,9
        val nearbyTickets = listOf(listOf(3, 9 ,18), listOf(15, 1, 5), listOf(5, 14, 9))

        // Based on the nearby tickets in the above example,
        // the first position must be row,
        // the second position must be class,
        // and the third position must be seat
        val fieldClassifier = FieldClassifier(ticketFields)
        fieldClassifier.processTickets(nearbyTickets)

        // There must be only one potential label for each field
        // and we must validate the selected fields
        assertEquals(1, fieldClassifier.potentialLabelsForFields[0].size)
        assertEquals("row", fieldClassifier.potentialLabelsForFields[0].first())
        assertEquals(1, fieldClassifier.potentialLabelsForFields[1].size)
        assertEquals("class", fieldClassifier.potentialLabelsForFields[1].first())
        assertEquals(1, fieldClassifier.potentialLabelsForFields[2].size)
        assertEquals("seat", fieldClassifier.potentialLabelsForFields[2].first())
    }
}