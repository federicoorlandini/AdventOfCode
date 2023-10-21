import java.security.InvalidParameterException
import kotlin.math.max
import kotlin.math.min

class World(initialStatus: List<String>) {
    private val layers : MutableMap<Int, Layer>

    private val centralLayer : Layer
        get() { return layers[0]!! }

    init {
        layers = mutableMapOf<Int, Layer>()
        val newLayer = Layer(initialStatus.size, initialStatus[0].length)
        newLayer.setStatus(initialStatus)
        layers[0] = newLayer
    }

    private val size : Triple<Int, Int, Int>
        get() {
            return Triple(layers[0]!!.numberRows, layers[0]!!.numberColumns, layers.count())
        }

    fun getLayer(layerIndex : Int) : Layer {
        if (layerIndex in layers.keys) {
            return layers[layerIndex]!!
        } else {
            throw InvalidParameterException("Invalid index layer")
        }
    }

    fun iteration() {
        // Execute one iteration on the entire map. Steps:
        expand()

        // - clone the existing world, let's call it NEW WORLD
        val newWorldLayers = cloneLayers()

        // Compute the status of each element in the new world
        computeNextStatus(newWorldLayers)

        // - in the new world, for each layer:
        //  * check if it is possible to remove the top and bottom layers (because they both contains all INACTIVE elements)
        //  * check if it is possible to shrink all the layers in all the four directions
        throw NotImplementedError()
    }

    private fun computeNextStatus(newWorldLayers: MutableMap<Int, Layer>) {
        // For each layer:
        //  * for each element in the layer
        //      - compute the new status of the element and update the equivalent element in the new world
        val (numberRows, numberColumns, numberLayers) = size
        for (l in 0..<numberLayers) {
            for (r in 0..<numberRows) {
                for (c in 0..<numberColumns) {
                    val newElementStatus = computeElementStatus(r, c, l)
                    newWorldLayers[l]!!.set(r, c, newElementStatus)
                }
            }
        }

        throw NotImplementedError()
    }

    private fun computeElementStatus(rowPosition: Int, columnPosition: Int, layerPosition: Int): Char {
        val statusCurrentElement = getElement(rowPosition, columnPosition, layerPosition)

        val (numberOfRows, numberOfColumns, numberOfLayers) = size
        val maxRowIndex = numberOfRows - 1
        val maxColumnIndex = numberOfColumns - 1
        val maxLayerIndex = numberOfLayers - 1

        // Find the status of the neighbors elements
        // There are 26 elements, differing for 1 element on all the dimensions
        var activeElementCounter = 0
        for (layerIncrement in -1 .. 1) {
            for (columnIncrement in -1 .. 1) {
                for (rowIncrement in -1 .. 1) {
                    // Skip the central element of the cube
                    if( layerIncrement == 0 && columnIncrement == 0 && rowIncrement == 0 )
                        continue

                    // Compute and limit the position of the element under analysis
                    var rowIndex = limitIndexInRange(rowPosition + rowIncrement, maxRowIndex)
                    var columnIndex = limitIndexInRange(columnPosition + columnIncrement, maxColumnIndex)
                    var layerIndex = limitIndexInRange(layerPosition + layerIncrement, maxLayerIndex)

                    // Get the status of the element under analysis and update the counter
                    throw NotImplementedError()
                }
            }
        }

        throw NotImplementedError()
    }

    private fun limitIndexInRange(index: Int, max: Int) : Int {
        return min(max(index, 0), max)
    }

    private fun expand() {
        // Add a layer on top and at the bottom in the new world, using the actual size of the layer, using the INACTIVE status
        val newTopLayerIndex = layers.keys.max().toInt() + 1
        val newTopLayer = Layer(centralLayer.numberRows, centralLayer.numberRows)
        layers[newTopLayerIndex] = newTopLayer

        val newBottomLayerIndex = layers.keys.min().toInt() - 1
        val newBottomLayer = Layer(centralLayer.numberRows, centralLayer.numberRows)
        layers[newBottomLayerIndex] = newBottomLayer

        // Expand all the layers in each direction, using the INACTIVE status
        layers.forEach { layer -> layer.value.expand(Layer.INACTIVE_PLACEHOLDER) }
    }

    private fun cloneLayers() : MutableMap<Int, Layer> {
        val newLayers = mutableMapOf<Int, Layer>()
        layers.forEach{ entry -> newLayers[entry.key] = entry.value.clone() }
        return newLayers
    }

    private fun getElement(rowIndex: Int, rowColumn: Int, layerIndex: Int) : Char = layers[layerIndex]!![rowIndex, rowColumn]
}