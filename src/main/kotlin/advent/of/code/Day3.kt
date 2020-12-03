package advent.of.code

import java.io.File

class Day3 {

    //TODO: I want to get this more nice.
    private val fileName: String = "/Users/michaelandersson/src/advent-of-code-2020/src/main/resources/day3.txt"

   /*
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
    */

    fun a() {
        val nrSteps : Int = File(fileName).readLines().size
        val xSteps : List<Int> = (0 until nrSteps*3 step 3).toList()
        print(xSteps + "\n")

        val count: Int = File(fileName).readLines()
                .zip(xSteps)
                .map {(row, xCoord) ->  parseRow(row, xCoord) }
                .filter {it}
                .count()

        println(count)
    }

    fun b() {

    }

    fun parseRow(map : String, xCoord : Int) : Boolean {
        return map[xCoord % map.length].toString() == "#"
    }



}