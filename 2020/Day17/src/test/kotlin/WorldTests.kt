import kotlin.test.Test
import kotlin.test.assertContentEquals

class WorldTests {
    @Test
    fun scenario1Test() {
        // This scenario is the first iteration in the example scenario
        // that explain how the logic is implemented (see https://adventofcode.com/2020/day/17)

        // Before any cycles:
        // z=0
        // .#.
        // ..#
        // ###
        //

        val initialStatus = listOf(
            ".#.",
            "..#",
            "###"
        )
        val world = World(initialStatus)

        // After 1 cycle:
        world.iteration()

        // Layer z=-1
        // #..
        // ..#
        // .#.
        assertLayer(listOf(
            "#..",
            "..#",
            ".#."), world, -1)

        // Layer z=0
        // #.#
        // .##
        // .#.
        assertLayer(listOf(
            "#.#",
            ".##",
            ".#."), world, 0)

        // Layer z=1
        // #..
        // ..#
        // .#.
        assertLayer(listOf(
            "#..",
            "..#",
            ".#.") ,world, 1)
    }
    private fun assertLayer(expectedMap : List<String>, world : World, layerIndex : Int) {
        expectedMap.forEachIndexed { index, row ->
            assertContentEquals(row.toCharArray(), world.getLayer(layerIndex).getRow(index).toCharArray())
        }
    }
}