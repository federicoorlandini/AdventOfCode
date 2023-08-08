import java.security.InvalidAlgorithmParameterException
import kotlin.test.Test
import kotlin.test.assertEquals

class LayerTests {
    @Test
    fun constructor_theNumberOfRowsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> { Layer(2, 5) }
    }

    @Test
    fun constructor_theNumberOfColumnsMustBeEven() {
        kotlin.test.assertFailsWith<InvalidAlgorithmParameterException> { Layer(5, 2) }
    }

    @Test
    fun constructor_theMaxRowIndexMustBeCorrect() {
        val layer = Layer(5, 7)

        assertEquals(2, layer.maxRowIndex)
        assertEquals(-2, layer.minRowIndex)

        assertEquals(3, layer.maxColumnIndex)
        assertEquals(-3, layer.minColumnIndex)
    }

    @Test
    fun constructor_allTheCellsMustBeInactive() {
        val layer = Layer(3,3)
        for (rowIndex in layer.minRowIndex..layer.maxRowIndex) {
            for (columnIndex in layer.minColumnIndex..layer.maxColumnIndex) {
                assertEquals(CellStatus.INACTIVE, layer.get(rowIndex, columnIndex))
            }
        }
    }
}