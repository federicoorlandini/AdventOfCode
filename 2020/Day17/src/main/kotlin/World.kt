import java.security.InvalidParameterException

class World(initialStatus: List<String>) {
    private val layers : Map<Int, Layer>

    init {
        layers = mutableMapOf<Int, Layer>()
        val newLayer = Layer(initialStatus.size, initialStatus[0].length)
        newLayer.setStatus(initialStatus)
        layers[0] = newLayer
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
        // - add a layer on top and at the bottom in the new world, using the actual size of the layer, using the INACTIVE status

        // - expand all the layers in each direction, using the INACTIVE status
        // - clone the existing world, let's call it NEW WORLD
        // - in the existing world, for each layer:
        //  * for each element in the layer
        //      - compute the new status of the element and update the equivalent element in the new world
        // - in the new world, for each layer:
        //  * check if it is possible to remove the top and bottom layers (because they both contains all INACTIVE elements)
        //  * check if it is possible to shrink all the layers in all the four directions
        throw NotImplementedError()
    }
}