import kotlin.test.Test
import kotlin.test.assertEquals

class WorldMapTests {
    @Test
    fun constructor_shouldReturnTheProperNumberOfRows() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)

        assertEquals(4, worldMap.numberRows)
    }

    @Test
    fun constructor_shouldReturnTheProperNumberOfColumns() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)

        assertEquals(3, worldMap.numberColumns)
    }

    @Test
    fun constructor_shouldReturnTheProperNumberOfLayers() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)

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

        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)

        assertEquals('.', worldMap[0,0,0])
        assertEquals('#', worldMap[0,0,1])
        assertEquals('.', worldMap[0,0,2])
        assertEquals('.', worldMap[0,1,0])
        assertEquals('.', worldMap[0,1,1])
        assertEquals('#', worldMap[0,1,2])
        assertEquals('#', worldMap[0,2,0])
        assertEquals('#', worldMap[0,2,1])
        assertEquals('#', worldMap[0,2,2])
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfRows() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)
        worldMap.expand()

        assertEquals(6, worldMap.numberRows)
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfColumns() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)
        worldMap.expand()

        assertEquals(5, worldMap.numberColumns)
    }

    @Test
    fun expand_shouldReturnTheCorrectNumberOfLayers() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)
        worldMap.expand()

        assertEquals(3, worldMap.numberLayers)
    }

    @Test
    fun expand_shoudGenerateTheCorrectMap() {
        val layer = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )
        val initialStatus = mutableListOf(layer)
        val worldMap = WorldMap()
        worldMap.setInitialStatus(initialStatus)
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
                assertEquals('.', worldMap[0, rowIndex, columnIndex])
            }
        }

        // Layer 1 (6 rows x 5 columns):
        // "....."
        // "..#.."
        // "...#."
        // ".###."
        // "..#.."
        // "....."
        assertEquals('.', worldMap[1, 0, 0])
        assertEquals('.', worldMap[1, 0, 1])
        assertEquals('.', worldMap[1, 0, 2])
        assertEquals('.', worldMap[1, 0, 3])
        assertEquals('.', worldMap[1, 0, 4])
        assertEquals('.', worldMap[1, 1, 0])
        assertEquals('.', worldMap[1, 1, 1])
        assertEquals('#', worldMap[1, 1, 2])
        assertEquals('.', worldMap[1, 1, 3])
        assertEquals('.', worldMap[1, 1, 4])
        assertEquals('.', worldMap[1, 2, 0])
        assertEquals('.', worldMap[1, 2, 1])
        assertEquals('.', worldMap[1, 2, 2])
        assertEquals('#', worldMap[1, 2, 3])
        assertEquals('.', worldMap[1, 2, 4])
        assertEquals('.', worldMap[1, 3, 0])
        assertEquals('#', worldMap[1, 3, 1])
        assertEquals('#', worldMap[1, 3, 2])
        assertEquals('#', worldMap[1, 3, 3])
        assertEquals('.', worldMap[1, 3, 4])
        assertEquals('.', worldMap[1, 4, 0])
        assertEquals('.', worldMap[1, 4, 1])
        assertEquals('#', worldMap[1, 4, 2])
        assertEquals('.', worldMap[1, 4, 3])
        assertEquals('.', worldMap[1, 4, 4])
        assertEquals('.', worldMap[1, 5, 0])
        assertEquals('.', worldMap[1, 5, 1])
        assertEquals('.', worldMap[1, 5, 2])
        assertEquals('.', worldMap[1, 5, 3])
        assertEquals('.', worldMap[1, 5, 4])
        // Layer 2 (6 rows x 5 columns):
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        // "....."
        for (rowIndex in 0..<6) {
            for (columnIndex in 0..<5) {
                assertEquals('.', worldMap[2, rowIndex, columnIndex])
            }
        }
    }

    @Test
    fun clone_theClonedShouldHaveTheSameElements() {
        // Layer 0
        val layer0 = mutableListOf(
            ".#.".toMutableList(),
            "..#".toMutableList(),
            "###".toMutableList(),
            ".#.".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            "##.".toMutableList(),
            "#.#".toMutableList(),
            "#.#".toMutableList(),
            ".##".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".##".toMutableList(),
            ".##".toMutableList(),
            "..#".toMutableList(),
            "##.".toMutableList()
        )

        val initialMap = WorldMap()
        initialMap.setInitialStatus(mutableListOf(layer0, layer1, layer2))

        // Clone
        val clonedMap = initialMap.clone()

        // Check that the two maps have the same elements
        for (layerIndex in 0..<initialMap.numberLayers) {
            for (rowIndex in 0..<initialMap.numberRows) {
                for (columnIndex in 0..<initialMap.numberColumns) {
                    assertEquals(initialMap[layerIndex, rowIndex, columnIndex],
                        clonedMap[layerIndex, rowIndex, columnIndex],
                        "Invalid element at [$layerIndex, $rowIndex, $columnIndex]." +
                                "Expected: ${initialMap[layerIndex, rowIndex, columnIndex]} " +
                                "Found: ${initialMap[layerIndex, rowIndex, columnIndex]}")
                }
            }
        }
    }
}