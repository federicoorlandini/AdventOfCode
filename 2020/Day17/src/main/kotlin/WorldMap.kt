// This class describes the status of each element that compose the world
class WorldMap(initialStatus : List<String>) {
    private val map: MutableList<MutableList<MutableList<Char>>>

    var numberRows : Int = 0
        get() = map.first().size

    var numberColumns: Int = 0
        get() = map.first().first().size

    var numberLayers: Int = 0
        get() = map.size

    operator fun get(row: Int, column: Int, layer: Int) : Char {
        return map[layer][row][column]
    }

    operator fun set(row: Int, column: Int, layer: Int, value: Char) {
        map[layer][row][column] = value
    }

    init {
        // Initialize the map with all the initial status INACTIVE
        map = mutableListOf<MutableList<MutableList<Char>>>()
        val numberOfRows = initialStatus.size
        val numberOfColumns = initialStatus.first().length
        val numberOfLayers = 1

        for (layerIndex in 0..<numberOfLayers) {
            val layer = mutableListOf<MutableList<Char>>()
            for (rowIndex in 0..<numberOfRows) {
                var row = initialStatus[rowIndex].toMutableList()
                layer.add(row)
            }
            map.add(layer)
        }
    }

    fun setStatus(elements: List<String>) {
        for (rowIndex in 0..<elements.size) {
            for (columnIndex in 0..<elements[rowIndex].length) {
                map[rowIndex][columnIndex][0] = elements[rowIndex][columnIndex]
            }
        }
    }
}