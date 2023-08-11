import java.security.InvalidAlgorithmParameterException
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class LayerTests {
    @Test
    fun constructor_theNumberOfRowsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> {
            // Layer 3 x 2
            Layer(listOf(
                "..",
                "##",
                ".#"
            ))
        }
    }

    @Test
    fun constructor_theNumberOfColumnsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> {
            // Layer 2 x 3
            Layer(listOf(
                "...",
                "###"
            ))
        }
    }

    @Test
    fun constructor_theNUmberOfRowsANdColumnsMustBeCorrect() {
        // Layer 7 x 5
        val layer = Layer(listOf(
            ".....",
            "#####",
            ".....",
            "#####",
            ".....",
            "#####",
            "....."
        ))

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

        val layer = Layer(map)

        for ((rowIndex, row) in map.withIndex()) {
            assertContentEquals(map[rowIndex].toCharArray(), layer.getRow(rowIndex).toCharArray())
        }
    }
}