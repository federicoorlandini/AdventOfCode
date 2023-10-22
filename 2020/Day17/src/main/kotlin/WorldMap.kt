// This class describes the status of each element that compose the world
class WorldMap(numberOfRows: Int, numberOfColumns: Int, numberOfLayers: Int) {
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
        for (l in 1..numberOfLayers) {
            val layer = mutableListOf<MutableList<Char>>()
            for (r in 1..numberOfRows) {
                var row = MutableList<Char>(numberOfColumns) { _ -> '.' }
                layer.add(row)
            }
            map.add(layer)
        }
    }
}