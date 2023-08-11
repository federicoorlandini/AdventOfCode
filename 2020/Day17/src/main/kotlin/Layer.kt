import java.security.InvalidAlgorithmParameterException
import java.security.InvalidParameterException

// This class represents a layer in the 3D space of the World class
class Layer(initialMap : List<String>) {
    val INACTIVE_PLACEHOLDER = '.'
    val ACTIVE_PLACEHOLDER = '#'

    private var map : MutableList<MutableList<Char>>
    val numberRows : Int
    val numberColumns : Int

    init {
        // Check that each element of the list of strings contains the same number of elements
        numberRows = initialMap.size
        numberColumns = initialMap[0].length
        initialMap.forEach { row -> assert(row.length == numberColumns) }

        // Check if the number of rows and columns are odd
        if (numberRows % 2 == 0) {
            throw InvalidAlgorithmParameterException("The number of rows must be an odd number")
        }
        if (numberColumns % 2 == 0) {
            throw InvalidAlgorithmParameterException("The number of columns must be an odd number")
        }

        // Data structure: a map of map of characters
        // Column Index
        //    |
        //    V
        // +-----+-----+-----+-----+-----+
        // | [x]   [x]   [x]   [x]   [x] |
        // +-----+-----+-----+-----+-----+
        // | [x]   [x]   [x]   [x]   [x] | <-- Row Index
        // +-----+-----+-----+-----+-----+
        // | [x]   [x]   [x]   [x]   [x] |
        // +-----+-----+-----+-----+-----+
        // | [x]   [x]   [x]   [x]   [x] |
        // +-----+-----+-----+-----+-----+
        // | [x]   [x]   [x]   [x]   [x] |
        // +-----+-----+-----+-----+-----+
        map = mutableListOf<MutableList<Char>>()   // Each element of this map is a row

        // Build all the matrix
        for (initialRow in initialMap) {
            // Every element is a String. Let's copy the input row
            val row = initialRow.toMutableList()
            map.add(row)
        }
    }

    fun get(rowIndex : Int, columnIndex : Int) : Char {
        // Enforce row index and column index in the correct range
        if (rowIndex !in 0..< numberRows) {
            throw InvalidParameterException("The row index is out of range")
        }
        if (columnIndex !in 0..<numberColumns) {
            throw InvalidParameterException("The column index is out of range")
        }

        return map[rowIndex][columnIndex]
    }

    fun getRow(rowIndex : Int) : List<Char> {
        return map[rowIndex].toList()
    }
}