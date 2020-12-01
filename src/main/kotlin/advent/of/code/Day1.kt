package advent.of.code

import java.io.File
import java.util.*

class Day1 {

    private val fileName : String = "/Users/michaelandersson/src/advent-of-code-2020/src/main/resources/day1.txt"

    fun a(): String
         {
             val input : List<Int> = File(fileName).readLines().map(String::toInt)
             input.forEach { it -> sumTo2020(it, input) }
             return "hej"
        }

    fun b(): String
    {
        val input : List<Int> = File(fileName).readLines().map(String::toInt)
        val permutations1 : List<Pair<Int, Int>> = createPermutations(input, input)
        println(permutations1)

        return "hej"
    }

    fun sumTo2020(i : Int, list : List<Int>){
        val candidates : List<Int> = list.map { j -> j + i }.filter { j -> j == 2020 }
        if(candidates.isNotEmpty()) {
            println("Answer: " + i * (candidates.get(0) - i))
        }
    }

    fun createPermutations(l1 : List<Int>, l2 : List<Int>) : List<Pair<Int, Int>> {
        return l1.flatMap {it1 -> l2.map{it2 -> Pair(it1 + it2, it1 * it2) }}
                .filter { (sum, prod) -> sum <= 2020 }
                .flatMap { pairItem -> l2.map { index -> Pair(pairItem.first + index, pairItem.second * index) }  }
                .filter { (sum, _) -> sum == 2020 }

    }

    // Spara undan produkten och summan! (inte beståndsdelarna)

}