typealias Ticket = List<Int>

fun main() {
    // your ticket
    val yourTicketFields : Ticket = listOf(139,113,127,181,53,149,131,239,137,241,89,151,109,73,157,59,107,83,173,179)

    val ticketFields = parseTicketFields()
    val nearbyTickets = parseNearbyTickets()
    val ticketChecker = TicketChecker(ticketFields)

    var errorScanCode = 0
    val validNearbyTickets = mutableListOf<Ticket>()

    for (ticket in nearbyTickets) {
        var (isTicketValid, errorCode) = ticketChecker.isValidTicket(ticket)
        if (!isTicketValid) {
            errorScanCode += errorCode
        }
        else {
            validNearbyTickets.add(ticket)
        }
    }

    println("[Part 1] Error scan code: $errorScanCode")

    //----- PART 2 -----


    // Now we process each valid ticket, one by one.


}

fun parseNearbyTickets() : List<Ticket> {
    val lines = object{}
        .javaClass
        .getResourceAsStream("input_nearby_tickets.txt")!!
        .bufferedReader()
        .readLines()
    return lines.map { line : String ->
        val parts = line.split(",")
        parts.map { item -> item.toInt() }
    }
}

fun parseTicketFields() : List<TicketField> {
    val labels = object{}
        .javaClass
        .getResourceAsStream("input_labels.txt")!!
        .bufferedReader()
        .readLines()
    return labels.map { line -> parseLabelLine(line) }
}

fun parseLabelLine(line : String) : TicketField {
    // Splitting the field label from the intervals
    var parts = line.split(":")
    val label = parts[0]

    // Splitting the intervals in each part
    val intervalsInLine = parts[1].split("or")

    // Convert each interval in the text line in a numeric interval
    val intervals = intervalsInLine.map { interval : String ->
        val intervalValues = interval.split("-")
        Pair(intervalValues[0].trim().toInt(), intervalValues[1].trim().toInt())
    }.toList()

    return TicketField(label, intervals)
}