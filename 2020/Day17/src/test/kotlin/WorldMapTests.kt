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
}