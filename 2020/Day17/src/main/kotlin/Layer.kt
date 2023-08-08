import java.security.InvalidAlgorithmParameterException
import java.security.InvalidParameterException

// This class represents a layer in the 3D space of the World class
class Layer(numberRows : Int, numberColumns : Int) {

    private var map : Map<Int, Map<Int, CellStatus>>
    val maxRowIndex : Int
    val minRowIndex : Int
    val maxColumnIndex : Int
    val minColumnIndex : Int

    init {
        // Check if the number of rows and columns are odd
        if (numberRows % 2 == 0) {
            throw InvalidAlgorithmParameterException("The number of rows must be an odd number")
        }
        if (numberColumns % 2 == 0) {
            throw InvalidAlgorithmParameterException("The number of columns must be an odd number")
        }

        // Data structure: a map of map of characters
        // Row Index
        //    |
        //    V
        // +-----+-----+-----+-----+-----+
        // | [x] | [x] | [x] | [x] | [x] |
        // +     +     +     +     +     +
        // | [x] | [x] | [x] | [x] | [x] | <-- Column Index
        // +     +     +     +     +     +
        // | [x] | [x] | [x] | [x] | [x] |
        // +     +     +     +     +     +
        // | [x] | [x] | [x] | [x] | [x] |
        // +     +     +     +     +     +
        // | [x] | [x] | [x] | [x] | [x] |
        // +     +     +     +     +     +
        // +-----+-----+-----+-----+-----+
        map = mutableMapOf<Int, Map<Int, CellStatus>>()   // These are the columns

        // Compute the min/max for the row index
        maxRowIndex = numberRows / 2
        minRowIndex = -maxRowIndex

        // Compute the min/max for the column index
        maxColumnIndex = numberColumns / 2
        minColumnIndex = -maxColumnIndex

        // Build all the matrix columns
        for (i in minRowIndex..maxRowIndex) {
            // Create the column and initialize
            val column = mutableMapOf<Int, CellStatus>()
            for (j in minColumnIndex..maxColumnIndex) {
                column[j] = CellStatus.INACTIVE
            }
            (map as MutableMap<Int, Map<Int, CellStatus>>)[i] = column
        }
    }

    fun get(rowIndex : Int, columnIndex : Int) : CellStatus? {
        // Enforce row index and column index in the correct range
        if (rowIndex !in minRowIndex..maxRowIndex) {
            throw InvalidParameterException("The row index is out of range")
        }
        if (columnIndex !in minColumnIndex..maxColumnIndex) {
            throw InvalidParameterException("The column index is out of range")
        }

        return map[rowIndex]?.get(columnIndex)
    }
}