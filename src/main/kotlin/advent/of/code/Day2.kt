package advent.of.code

import java.io.File

class Day2 {

    //TODO: I want to get this more nice.
    private val fileName: String = "/Users/michaelandersson/src/advent-of-code-2020/src/main/resources/day2.txt"

    // 2-9 c: ccccccccc

    fun a() {
        val count: Int = File(fileName).readLines()
                .map { parseRow(it) }
                .filter { it }
                .count()
        println(count)
    }

    fun b() {

    }

    fun parseRow(row : String) : Boolean{
        val parsedInput : List<String> =  row.split("-", " ")
                .map {it -> it.replace(":", "")}

        return matchesb(parsedInput) //TODO how do we do this in a more functional way?
    }

    fun matches(input : List<String>) : Boolean {
        val count : Int = input[3].split(input[2]).count() - 1
        return count >= input[0].toInt() && count <= input[1].toInt()
    }

    fun matchesb(input : List<String>) : Boolean {

        val isFirstMatch : Boolean = input[3][input[0].toInt() - 1].toString() == input[2]
        val isSecondMatch : Boolean = input[3][input[1].toInt() - 1].toString() == input[2]

        return isFirstMatch.xor(isSecondMatch)

    }

}