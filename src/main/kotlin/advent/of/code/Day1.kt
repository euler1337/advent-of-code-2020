package advent.of.code

import java.io.File
import java.util.*

class Day1 {

    //TODO: I want to get this more nice.
    private val fileName : String = "/Users/michaelandersson/src/advent-of-code-2020/src/main/resources/day1.txt"

    fun a()
         {
             val input : List<Int> = File(fileName).readLines().map(String::toInt)
             val result : List<Pair<Int, Int>> = input.flatMap {it1 -> input.map{it2 -> Pair(it1 + it2, it1 * it2) }}
                     .filter { (sum, prod) -> sum == 2020 }

             println("A: result: $result")
        }

    fun b()
    {
        val input : List<Int> = File(fileName).readLines().map(String::toInt)
        val result : List<Pair<Int, Int>> = input.flatMap {it1 -> input.map{it2 -> Pair(it1 + it2, it1 * it2) }}
                .filter { (sum, prod) -> sum <= 2020 }
                .flatMap { pairItem -> input.map { index -> Pair(pairItem.first + index, pairItem.second * index) } }
                .filter { (sum, _) -> sum == 2020 }

        println("B: result: $result")
    }

}