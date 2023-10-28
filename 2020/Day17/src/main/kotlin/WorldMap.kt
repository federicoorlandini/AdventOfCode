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

    fun expand() {
        // Add a new layer on top and bottom
        val numberRows = map.first().size
        val numberColumns = map.first().first().size
        map.add(createInactiveLayer(numberRows, numberColumns))
        map.add(0, createInactiveLayer(numberRows, numberColumns))
        map.forEach { layer ->
            // For each layer, add a new row at the top and and at the bottom
            layer.add(MutableList<Char>(numberColumns) { _ -> '.'})
            layer.add(0, MutableList<Char>(numberColumns) { _ -> '.'})
            // For each row, add a new inactive state at the begin and end of the row
            layer.forEach { row ->
                row.add('.')
                row.add(0, '.')
            }
        }
    }

    private fun createInactiveLayer(numberRows: Int, numberColumns: Int) : MutableList<MutableList<Char>>{
        return MutableList<MutableList<Char>>(numberRows) {
            _ -> MutableList<Char>(numberColumns) { _ -> '.'}
        }
    }
}