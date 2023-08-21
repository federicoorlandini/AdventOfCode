import java.nio.channels.InterruptibleChannel
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidParameterException

// This class represents a layer in the 3D space of the World class
class Layer(numberOfRows : Int, numberOfColumns : Int) {
    companion object {
        val INACTIVE_PLACEHOLDER = '.'
        val ACTIVE_PLACEHOLDER = '#'
    }

    private var map : MutableList<MutableList<Char>> = mutableListOf<MutableList<Char>>()
    var numberRows : Int = numberOfRows
    var numberColumns : Int = numberOfColumns

    init {
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

        // Build the entire matrix
        for (rowIndex in 0 ..< numberOfRows) {
            val row = MutableList(numberOfColumns) { '.' }
            map.add(row)
        }
    }
    operator fun get(rowIndex : Int, columnIndex : Int) : Char {
        validateRowAndColumnIndexes(rowIndex, columnIndex)

        return map[rowIndex][columnIndex]
    }

    operator fun set(rowIndex : Int, columnIndex: Int, value : Char) {
        validateRowAndColumnIndexes(rowIndex, columnIndex)
        map[rowIndex][columnIndex] = value
    }

    fun setStatus(initialMap : List<String>) {
        // Set the status of each element in the map based on the inital map received as input
        // Check the size of the input data
        if (initialMap.size != numberRows) {
            throw InvalidParameterException("THe number of rows for the input is incompatible with the number of rows in the layer")
        }
        if (initialMap[0].length != numberColumns) {
            throw InvalidParameterException("THe number of columns for the input is incompatible with the number of columns in the layer")
        }

        // Replicate the input in the layer inner map
        for ((rowIndex, row) in initialMap.withIndex()) {
            for ((columnIndex, element) in row.withIndex()) {
                set(rowIndex, columnIndex, element)
            }
        }
    }

    fun setStatusInactive() {
        // Initialize the layer with all the element as INACTIVE element
        throw NotImplementedError()
    }

    private fun validateRowAndColumnIndexes(rowIndex: Int, columnIndex: Int) {
        // Enforce row index and column index in the correct range
        if (rowIndex !in 0..< numberRows) {
            throw InvalidParameterException("The row index is out of range")
        }
        if (columnIndex !in 0..< numberColumns) {
            throw InvalidParameterException("The column index is out of range")
        }
    }

    fun getRow(rowIndex : Int) : List<Char> {
        return map[rowIndex].toList()
    }
}