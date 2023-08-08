import kotlin.test.Test

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
        // After 1 cycle:
        // z=-1
        // #..
        // ..#
        // .#.
        //
        // z=0
        // #.#
        // .##
        // .#.
        //
        // z=1
        // #..
        // ..#
        // .#.
        val initialStatus = listOf(
            ".#.",
            "..#",
            "###"
        )
        val world = World(initialStatus)

        world.iteration()

        val layer0 = world.layers[0]


        throw NotImplementedError()
    }
}