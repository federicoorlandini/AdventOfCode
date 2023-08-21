import java.security.InvalidAlgorithmParameterException
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class LayerTests {
    @Test
    fun constructor_theNumberOfRowsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> {
            // Layer 3 x 2
            Layer(3, 2)
        }
    }

    @Test
    fun constructor_theNumberOfColumnsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> {
            // Layer 2 x 3
            Layer(2, 3)
        }
    }

    @Test
    fun constructor_theNUmberOfRowsANdColumnsMustBeCorrect() {
        // Layer 7 x 5
        val initialLMap = listOf(
            ".....",
            "#####",
            ".....",
            "#####",
            ".....",
            "#####",
            "....."
        )
        val layer = Layer(initialLMap.size, initialLMap[0].length)
        layer.setStatus(initialLMap)

        assertEquals(7, layer.numberRows)
        assertEquals(5, layer.numberColumns)
    }

    @Test
    fun constructor_allTheCellsMustBeInTheCorrectInitialStatus() {
        // Layer 3x3
        val map = listOf(
            "...",
            "###",
            "..."
        )

        val layer = Layer(map.size, map[0].length)
        layer.setStatus(map)

        for ((rowIndex, _) in map.withIndex()) {
            assertContentEquals(map[rowIndex].toCharArray(), layer.getRow(rowIndex).toCharArray())
        }
    }

    @Test
    fun expand_shouldAddTheCorrectRowsAndColumnsUsingTheCorrectCharacter() {
        // Given a layer with initial status
        // "..."
        // "###",
        // "..."
        // when calling the expand() method using an INACTIVE_PLACEHOLDER
        // then the status become
        // "....."
        // "....."
        // ".###."
        // "....."
        // "....."

        // Layer 3x3
        val map = listOf(
            "...",
            "###",
            "..."
        )

        val layer = Layer(map.size, map[0].length)
        layer.setStatus(map)

        layer.expand(Layer.INACTIVE_PLACEHOLDER)

        assertEquals(layer.numberRows, 5)
        assertEquals(layer.numberColumns, 5)

        assertContentEquals(".....".toCharArray(), layer.getRow(0).toCharArray())
        assertContentEquals(".....".toCharArray(), layer.getRow(0).toCharArray())
        assertContentEquals(".###.".toCharArray(), layer.getRow(0).toCharArray())
        assertContentEquals(".....".toCharArray(), layer.getRow(0).toCharArray())
        assertContentEquals(".....".toCharArray(), layer.getRow(0).toCharArray())
    }

}