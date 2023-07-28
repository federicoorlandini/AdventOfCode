class TicketField(val label : String, val intervals : List<Pair<Int, Int>>) {
    fun isInRange(value : Int) : Boolean =
        intervals.any {interval -> value in interval.first..interval.second}
}