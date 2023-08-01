fun main() {
    // your ticket
    val yourTicketFields = listOf(139,113,127,181,53,149,131,239,137,241,89,151,109,73,157,59,107,83,173,179)

    val ticketFields = parseTicketFields()
    val nearbyTickets = parseNearbyTickets()
    val ticketChecker = TicketChecker(ticketFields)

    var errorScanCode = 0
    val validNearbyTickets = mutableListOf<List<Int>>()

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
    // Now we process each valid ticket in the nearby tickets list, one by one and
    val fieldClassifier = FieldClassifier(ticketFields)
    fieldClassifier.processTickets(validNearbyTickets)

    // Get the positions of the fields that contains the word 'departure'
    val relevantFieldsIndexes = fieldClassifier
        .potentialLabelsForFields
        .map { item -> item.first() }
        .withIndex()
        .filter { item -> item.value.contains("departure") }
        .map { item -> item.index }

    // Collect the values at that index and multiply the values
    var result : Long = 1
    relevantFieldsIndexes.forEach { fieldIndex -> result *= yourTicketFields[fieldIndex] }

    // Result part 2
    println("Part 2 result: $result")
}

fun parseNearbyTickets() : List<List<Int>> {
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