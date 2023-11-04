// This class describes the status of each element that compose the world
class WorldMap() {
    private val map: MutableList<Layer> = mutableListOf()

    val numberRows : Int
        get() = map.first().size

    val numberColumns: Int
        get() = map.first().first().size

    val numberLayers: Int
        get() = map.size

    operator fun get(layer: Int, row: Int, column: Int) : Char {
        return map[layer][row][column]
    }

    operator fun set(layer: Int, row: Int, column: Int, value: Char) {
        map[layer][row][column] = value
    }

    fun setInitialStatus(initialStatus : MutableList<Layer>) {
        // Initialize the map using a single slice
        // Clear the actual status
        emptyStatus()

        val numberOfLayers = initialStatus.size
        val numberOfRows = initialStatus.first().size

        for (layerIndex in 0..<numberOfLayers) {
            val layer = mutableListOf<Row>()
            for (rowIndex in 0..<numberOfRows) {
                val row = initialStatus[layerIndex][rowIndex].toMutableList()
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

    fun clone() : WorldMap {
        // Create a copy of the world map
        val newMap = mutableListOf<MutableList<MutableList<Char>>>()

        for (layerIndex in 0..<numberLayers) {
            val newLayer = mutableListOf<MutableList<Char>>()
            for (rowIndex in 0..<numberRows) {
                val newRow = map[layerIndex][rowIndex].toMutableList()
                newLayer.add(newRow)
            }
            newMap.add(newLayer)
        }

        val newWorldMap = WorldMap()
        newWorldMap.setInitialStatus(newMap)
        return newWorldMap
    }

    private fun createInactiveLayer(numberRows: Int, numberColumns: Int) : MutableList<MutableList<Char>>{
        return MutableList<MutableList<Char>>(numberRows) {
            _ -> MutableList<Char>(numberColumns) { _ -> '.'}
        }
    }

    private fun emptyStatus() {
        map.forEach { row -> row.clear() }
    }
}