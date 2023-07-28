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
}