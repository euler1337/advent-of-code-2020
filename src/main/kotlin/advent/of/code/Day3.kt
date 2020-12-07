package advent.of.code

import java.io.File
import java.util.EnumSet.of
import java.util.List.of

class Day3 {

    //TODO: I want to get this more nice.
    private val fileName: String = "/Users/michaelandersson/src/advent-of-code-2020/src/main/resources/day3.txt"

    fun a() {
        val count = countTrees(3, File(fileName).readLines())
        println(count)
    }

    fun b() {

        val slopes : List<Int> = listOf(1,3,5,7);
        val input : List<String> = File(fileName).readLines()
        val treeCount1 : List<Int> = slopes.map {countTrees(it, input) }

        // Handle y-slope
        val slopeCorrectedInput = input.filterIndexed{ index, _ -> index.rem(2) == 0 }
        val treeCount2 = countTrees(1,slopeCorrectedInput)

        println(treeCount1.plus(treeCount2).reduce(Int::times))

        // Kotlin types ...
        val sumWrong : Int = 86*187*75*89*44 // 428316104
        val sumWrong2 : Long = 86*187*75*89*44 // 428316104
        val sumCorrect : Long = 86L*187L*75L*89L*44L // 4723283400

    }

fun countTrees(slope : Int, input : List<String>) : Int {
        val nrSteps : Int = input.size
        val xSteps : List<Int> = (0 until nrSteps*slope step slope).toList()

        return input
                .zip(xSteps)
                .map {(row, xCoord) ->  parseRow(row, xCoord) }
                .filter {it}
                .count()

    }

    fun parseRow(map : String, xCoord : Int) : Boolean {
        return map[xCoord % map.length].toString() == "#"
    }



}