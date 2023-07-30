// This is a class that given a list of TicketFields
// and a list of integer that represents a ticket then
// check if the all the ticket value are valid fields
class TicketChecker(val ticketFields : List<TicketField>) {
    fun isValidTicket(ticket : List<Int> ) : Pair<Boolean, Int> {
        var isValid = true
        var errorCode = 0
        for (ticketValue in ticket) {
            if (!ticketFields.any { ticketField -> ticketField.isInRange(ticketValue) }) {
                errorCode += ticketValue
                isValid = false
            }
        }
        return  Pair(isValid, errorCode)
    }

    // Given a value, it returns the list of fields that are compatible with the value and
    // the list of the fields that are not compatible with the value
    fun findFields(value : Int) : Pair<List<TicketField>, List<TicketField>> {
        val compatibleFields = mutableListOf<TicketField>()
        val incompatibleFields = mutableListOf<TicketField>()
        ticketFields.forEach {ticketField ->
            if (ticketField.isInRange(value)) {
                compatibleFields.add(ticketField)
            }
            else {
                incompatibleFields.add(ticketField)
            }
        }

        return Pair(compatibleFields, incompatibleFields)
    }
}