import javax.management.InvalidApplicationException

// This is the class that given the list of Ticket fields and
// the list of tickets find the right place for each field in the tickets
class FieldClassifier(val ticketFields : List<TicketField>) {
    val potentialLabelsForFields : List<MutableList<String>>
    private val ticketChecker : TicketChecker

    init {
        // Let's generate an array of list of string. Each element of the array correspond to a field in the ticket.
        // Since we don't know which label a specific ticket field has, we initialize each array element
        // with all the labels. We'll remove the labels that doesn't match the value when processing the
        // ticket values
        val labels = ticketFields.map { it.label }
        potentialLabelsForFields = List(labels.size) { labels.toMutableList() }

        ticketChecker = TicketChecker(ticketFields)
    }

    fun processTickets(tickets : List<List<Int>>) {
        tickets.forEach { ticket -> processTicket(ticket) }

        // After, we need to process all the fields with a single potential label, removing it from the
        // other label lists. For example, we could have the following situation:
        // - field 0 - labels: row
        // - field 1 - labels: row, class
        // - field 2 - labels: row, class, seat
        // In this case, we must remove the "row" element from fields 1 and 2 and after
        // remove the label "class" from field 2. The process must end when all the fields
        // have only one label
        var safetyCounter = 0   // This a counter to avoid too many iterations in the while loop
        while (potentialLabelsForFields.any { potentialLabels -> potentialLabels.size > 1}) {
            val labelsAlreadyAllocated = potentialLabelsForFields
                .filter { potentialLabels -> potentialLabels.size == 1 }.flatten()

            // Let's process all the fields that has unidentified labels, removing the already identified
            // labels from the others
            potentialLabelsForFields
                .filter { potentialLabelsList -> potentialLabelsList.size > 1 }
                .forEach { potentialLabelList -> potentialLabelList.removeAll(labelsAlreadyAllocated) }

            safetyCounter++
            if (safetyCounter > 1000) {
                throw InvalidApplicationException("Too many iteration")
            }
        }
    }

    private fun processTicket(ticket : List<Int>) {
        // For each field, we check which ticket fields are NOT compatible with the value
        // and we remove them from the list of potential fields for the specific field.
        ticket.forEachIndexed { index, ticketValue ->
            // Find the list of incompatible fields and remove them from the list of potential
            // fields for the specific field position in the ticket
            val (_, incompatibleFields) = ticketChecker.findFields(ticketValue)
            incompatibleFields.forEach { field -> potentialLabelsForFields[index].remove(field.label)}
        }
    }
}