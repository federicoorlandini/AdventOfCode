import java.security.InvalidParameterException
import javax.management.InvalidApplicationException
import kotlin.math.max
import kotlin.math.min

class World(initialStatus: MutableList<Layer>) {
    private var worldMap : WorldMap = WorldMap()

    init {
        worldMap.setInitialStatus(initialStatus)
    }

    operator fun get(layer: Int, row: Int, column: Int) : Char = worldMap[layer, row, column]

    fun iteration() {
        // Execute one iteration on the entire map. Steps:
        worldMap.expand()

        // Compute the status of each element in the new world
        computeNextWorldMap()

        // - in the new world, for each layer:
        //  * check if it is possible to remove the top and bottom layers (because they both contains all INACTIVE elements)
        //  * check if it is possible to shrink all the layers in all the four directions
        worldMap.shrink()
    }

    private fun computeNextWorldMap() {
        // Clone the existing world, to compute the status of each
        // element for the next iteration
        val clonedWorldMap = worldMap.clone()

        // For each layer:
        //  * for each element in the layer
        //      - compute the new status of the element and update the equivalent element in the new world
        for (layerIndex in 0..<clonedWorldMap.numberLayers) {
            for (rowIndex in 0..<clonedWorldMap.numberRows) {
                for (columnIndex in 0..<clonedWorldMap.numberColumns) {
                    val newElementStatus = computeElementStatus(clonedWorldMap, layerIndex, rowIndex, columnIndex)
                    // Update the status of the current element in the world map
                    worldMap[layerIndex, rowIndex, columnIndex] = newElementStatus
                }
            }
        }
    }

    private fun computeElementStatus(worldMap: WorldMap,
                                     layerPosition: Int,
                                     rowPosition: Int,
                                     columnPosition: Int): Char {
        // Find the status of the neighbors elements
        // There are 26 elements, differing for 1 element on all the dimensions
        var activeElementCounter = 0
        for (layerIncrement in -1 .. 1) {
            for (columnIncrement in -1 .. 1) {
                for (rowIncrement in -1 .. 1) {
                    // Skip the central element of the cube
                    if( layerIncrement == 0 && columnIncrement == 0 && rowIncrement == 0 )
                        continue

                    // If the element that we are processing to count the number of active element is
                    // outside the limit of the indexes then we must skip the element
                    val layerIndex = layerPosition + layerIncrement
                    val rowIndex = rowPosition + rowIncrement
                    val columnIndex = columnPosition + columnIncrement
                    if (layerIndex < 0 || layerIndex >= worldMap.numberLayers ||
                        rowIndex < 0 || rowIndex >= worldMap.numberRows ||
                        columnIndex < 0 || columnIndex >= worldMap.numberColumns) {
                        continue
                    }

                    // Get the status of the element under analysis and update the counter
                    if (worldMap[layerIndex, rowIndex, columnIndex] == '#') {
                        activeElementCounter++
                    }
                }
            }
        }

        // Rules to compute the next iteration state for the element
        // If a cube is active and exactly 2 or 3 of its neighbors are also active,
        // the cube remains active. Otherwise, the cube becomes inactive.
        // If a cube is inactive but exactly 3 of its neighbors are active,
        // the cube becomes active. Otherwise, the cube remains inactive.
        when (val currentElementStatus = worldMap[layerPosition, rowPosition, columnPosition]) {
            '#' -> {
                if (activeElementCounter == 2 || activeElementCounter == 3) {
                    return '#'
                } else {
                    return '.'
                }
            }
            '.' -> {
                if (activeElementCounter == 3) {
                    return '#'
                } else {
                    return '.'
                }
            }
            else -> throw InvalidApplicationException("The element status $currentElementStatus is invalid.")
        }
    }

    private fun limitIndexInRange(index: Int, max: Int) : Int {
        return min(max(index, 0), max)
    }
}