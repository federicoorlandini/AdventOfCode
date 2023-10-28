import kotlin.test.Test
import kotlin.test.assertEquals

class WorldMapTests {
    @Test
    fun constructor_shouldReturnTheProperNumberOfRows() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)

        assertEquals(4, worldMap.numberRows)
    }

    @Test
    fun constructor_shouldReturnTheProperNumberOfColumns() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)

        assertEquals(3, worldMap.numberColumns)
    }

    @Test
    fun constructor_shouldReturnTheProperNumberOfLayers() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)

        assertEquals(1, worldMap.numberLayers)
    }

    @Test
    fun constructor_shouldSetTheProperElements() {
        // Given the initial status
        // .#.
        // ..#
        // ###
        // when we construct the WorldStatus object
        // then we must have the proper elements in the proper positions

        val initialStatus = listOf(
            ".#.",
            "..#",
            "###"
        )
        val worldMap = WorldMap(initialStatus)

        assertEquals('.', worldMap[0,0,0])
        assertEquals('#', worldMap[0,1,0])
        assertEquals('.', worldMap[0,2,0])
        assertEquals('.', worldMap[1,0,0])
        assertEquals('.', worldMap[1,1,0])
        assertEquals('#', worldMap[1,2,0])
        assertEquals('#', worldMap[2,0,0])
        assertEquals('#', worldMap[2,1,0])
        assertEquals('#', worldMap[2,2,0])
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfRows() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)
        worldMap.expand()

        assertEquals(6, worldMap.numberRows)
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfColumns() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)
        worldMap.expand()

        assertEquals(5, worldMap.numberColumns)
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfLayers() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)
        worldMap.expand()

        assertEquals(3, worldMap.numberLayers)
    }

    @Test
    fun expand_shoudGenerateTheCorrectMap() {
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###",
            ".#."
        )
        val worldMap = WorldMap(initialStatus)
        worldMap.expand()

        // Expected result
        // Layer 0 (6 rows x 5 columns):
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        for (rowIndex in 0..<6) {
            for (columnIndex in 0..<5) {
                assertEquals('.', worldMap[rowIndex, columnIndex, 0])
            }
        }

        // Layer 1 (6 rows x 5 columns):
        // "....."
        // "..#.."
        // "...#."
        // ".###."
        // "..#.."
        // "....."
        assertEquals('.', worldMap[0, 0, 1])
        assertEquals('.', worldMap[0, 1, 1])
        assertEquals('.', worldMap[0, 2, 1])
        assertEquals('.', worldMap[0, 3, 1])
        assertEquals('.', worldMap[0, 4, 1])
        assertEquals('.', worldMap[1, 0, 1])
        assertEquals('.', worldMap[1, 1, 1])
        assertEquals('#', worldMap[1, 2, 1])
        assertEquals('.', worldMap[1, 3, 1])
        assertEquals('.', worldMap[1, 4, 1])
        assertEquals('.', worldMap[2, 0, 1])
        assertEquals('.', worldMap[2, 1, 1])
        assertEquals('.', worldMap[2, 2, 1])
        assertEquals('#', worldMap[2, 3, 1])
        assertEquals('.', worldMap[2, 4, 1])
        assertEquals('.', worldMap[3, 0, 1])
        assertEquals('#', worldMap[3, 1, 1])
        assertEquals('#', worldMap[3, 2, 1])
        assertEquals('#', worldMap[3, 3, 1])
        assertEquals('.', worldMap[3, 4, 1])
        assertEquals('.', worldMap[1, 0, 1])
        assertEquals('.', worldMap[1, 1, 1])
        assertEquals('#', worldMap[1, 2, 1])
        assertEquals('.', worldMap[1, 3, 1])
        assertEquals('.', worldMap[1, 4, 1])
        assertEquals('.', worldMap[0, 0, 1])
        assertEquals('.', worldMap[0, 1, 1])
        assertEquals('.', worldMap[0, 2, 1])
        assertEquals('.', worldMap[0, 3, 1])
        assertEquals('.', worldMap[0, 4, 1])
        // Layer 2 (6 rows x 5 columns):
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        for (rowIndex in 0..<6) {
            for (columnIndex in 0..<5) {
                assertEquals('.', worldMap[rowIndex, columnIndex, 2])
            }
        }
    }
}