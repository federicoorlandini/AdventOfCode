class TicketField(val label : String, val lowerLimit : Int, val upperLimit : Int) {
    fun isInRange(value : Int) : Boolean =  (value in lowerLimit..upperLimit)
}