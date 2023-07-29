// This is the class that given the list of Ticket fields and
// the list of tickets find the right place for each field in the tickets
class FieldClassifier(val ticketFields : List<TicketField>) {
    private val potentialLabelsForFields : List<List<String>>

    init {
        // Let's generate an array of list of string. Each element of the array correspond to a field in the ticket.
        // Since we don't know which label a specific ticket field has, we initialize each array element
        // with all the labels. We'll remove the labels that doesn't match the value when processing the
        // ticket values
        val labels = ticketFields.map { it.label }
        potentialLabelsForFields = List<List<String>>(labels.size) { labels.toMutableList() }
    }

    fun processTicket(ticket : Ticket) {
        // For each field, we check which ticket fields are NOT compatible with the value
        // and we remove them from the list of potential fields for the specific field.
        ticket.forEachIndexed { index, i ->  }
    }
}