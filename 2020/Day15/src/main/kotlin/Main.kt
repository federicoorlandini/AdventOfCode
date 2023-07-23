fun main(args: Array<String>) {
    val processor = SequenceNumberProcessor()

    // part1(processor)
    part2(processor)
}

private fun part1(processor: SequenceNumberProcessor) {
    // Given your starting numbers 19,20,14,0,9,1, what will be the 2020th number spoken?

    processor.declareNumber(19)
    processor.declareNumber(20)
    processor.declareNumber(14)
    processor.declareNumber(0)
    processor.declareNumber(9)
    processor.declareNumber(1)

    while (processor.currentTurn < 2019) {  // THe spoken number at turn 2020 is the result of turn 2019
        processor.declareNumber(processor.answer)
    }

    println("Result: ${processor.answer}")
}

private fun part2(processor: SequenceNumberProcessor) {
    // Given your starting numbers 19,20,14,0,9,1, what will be the 30000000th number spoken?
    processor.declareNumber(19)
    processor.declareNumber(20)
    processor.declareNumber(14)
    processor.declareNumber(0)
    processor.declareNumber(9)
    processor.declareNumber(1)

    while (processor.currentTurn < 29999999) {  // THe spoken number at turn 30000000th is the result of turn 29999999th
        processor.declareNumber(processor.answer)
    }

    println("Result: ${processor.answer}")
}