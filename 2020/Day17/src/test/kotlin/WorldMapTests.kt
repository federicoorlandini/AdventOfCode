import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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
        assertEquals(initialMap, clonedMap)
    }

    @Test
    fun shrink_shouldShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        // Check if can shrink
        assertTrue { canShrink }

        // Should remove the first and last layer so we should have only 3 layers
        assertEquals(3, map.numberLayers)

        // Should remove the first and last rows of each layer, so each layer
        // should have only 3 rows
        for (layerIndex in 0..<map.numberLayers) {
            assertEquals(3, map[layerIndex].size)
        }

        // Should remove the last and first column of each rows, so each rows
        // should have only 3 columns
        for (layerIndex in 0..<map.numberLayers) {
            for(rowIndex in 0..<map.numberRows) {
                assertEquals(3, map[layerIndex, rowIndex].size)
            }
        }

        // The three layers should be the same than layer1, layer2 and layer 3
        val expectedLayer0 = mutableListOf(
            "#.#".toMutableList(),
            ".#.".toMutableList(),
            "#.#".toMutableList()
        )

        val expectedLayer1 = mutableListOf(
            ".#.".toMutableList(),
            "#.#".toMutableList(),
            ".#.".toMutableList()
        )

        val expectedLayer2 = mutableListOf(
            "#.#".toMutableList(),
            ".#.".toMutableList(),
            "#.#".toMutableList()
        )

        val expectedWorldMap = WorldMap()
        expectedWorldMap.setInitialStatus(mutableListOf(expectedLayer0, expectedLayer1, expectedLayer2))

        // Assert
        assertEquals(expectedWorldMap, map)
    }

    @Test
    fun shrink_haveAnActiveElementInTheTopLayer_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            "..#..".toMutableList(), // This element does not allow to shrink
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    @Test
    fun shrink_haveAnActiveElementInTheBottomLayer_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".#...".toMutableList(), // This element does not allow to shrink
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    @Test
    fun shrink_haveAnActiveElementInTheFirstRow_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            "..#..".toMutableList(), // This element does not allow to shrink
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    @Test
    fun shrink_haveAnActiveElementInTheLastRow_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "#....".toMutableList() // This element does not allow to shrink
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    @Test
    fun shrink_haveAnActiveElementInTheFirstColumn_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "#.#..".toMutableList(), // The element in the first column of this row doesn't allow to shrink
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    @Test
    fun shrink_haveAnActiveElementInTheLastColumn_shouldNotShrinkTheMap() {
        // Layer 0
        val layer0 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 1
        val layer1 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 2
        val layer2 = mutableListOf(
            ".....".toMutableList(),
            "..#..".toMutableList(),
            ".#.#.".toMutableList(),
            "..#..".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 3
        val layer3 = mutableListOf(
            ".....".toMutableList(),
            ".#.#.".toMutableList(),
            "..#.#".toMutableList(),// The element in the last column of this row doesn't allow to shrink
            ".#.#.".toMutableList(),
            ".....".toMutableList()
        )

        // Layer 4
        val layer4 = mutableListOf(
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList(),
            ".....".toMutableList()
        )

        val map = WorldMap()
        map.setInitialStatus(mutableListOf(layer0, layer1, layer2, layer3, layer4))

        // Act
        val canShrink = map.shrink()

        assertFalse { canShrink }
    }

    private fun assertEquals(map1: WorldMap, map2: WorldMap) {
        for (layerIndex in 0..<map1.numberLayers) {
            for (rowIndex in 0..<map1.numberRows) {
                for (columnIndex in 0..<map1.numberColumns) {
                    assertEquals(map1[layerIndex, rowIndex, columnIndex],
                        map2[layerIndex, rowIndex, columnIndex],
                        "Invalid element at [$layerIndex, $rowIndex, $columnIndex]." +
                                "Expected: ${map1[layerIndex, rowIndex, columnIndex]} " +
                                "Found: ${map2[layerIndex, rowIndex, columnIndex]}")
                }
            }
        }
    }
}