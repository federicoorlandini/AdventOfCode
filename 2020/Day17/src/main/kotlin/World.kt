import java.security.InvalidParameterException

class World(initialStatus: List<String>) {
    private val layers : Map<Int, Layer>

    init {
        layers = mutableMapOf<Int, Layer>()
        layers[0] = Layer(initialStatus)
    }

    fun getLayer(layerIndex : Int) : Layer {
        if (layerIndex in layers.keys) {
            return layers[layerIndex]!!
        } else {
            throw InvalidParameterException("Invalid index layer")
        }
    }

    fun iteration() {
        // Execute one iteration on the entire map
        throw NotImplementedError()
    }
}