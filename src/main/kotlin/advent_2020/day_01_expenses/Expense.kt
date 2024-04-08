package advent_2020.day_01_expenses

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    fun multiply(set: Set<Int>) = set.reduce(Int::times)

    val path = "./src/main/kotlin/advent_2020/day_01_expenses/input.txt"

    val seq2 = BufferedReader(FileReader(path)).lineSequence().iterator()
    println("2 components: ${multiply(Expense.matching2(seq2, 2020))}")

    val seq3 = BufferedReader(FileReader(path)).lineSequence().iterator()
    println("3 components: ${multiply(Expense.matching3(seq3, 2020))}")
}

object Expense {
    fun matching2(lines: Iterator<String>, sumUp: Int): Set<Int> {
        val expenses = mutableSetOf<Int>()

        while (lines.hasNext()) {
            val current = lines.next().toInt()
            val complement = sumUp - current

            if (expenses.contains(complement))
                return setOf(complement, current)

            expenses.add(current)
        }
        return emptySet()
    }

    fun matching3(lines: Iterator<String>, sumUp: Int): Set<Int> {
        val expenses = mutableSetOf<Int>()

        while (lines.hasNext()) {
            val current = lines.next().toInt()
            val missing = sumUp - current

            val complement = expenses.firstOrNull() {
                expenses.contains(missing - it)}

            if (complement != null)
                return setOf(current, missing - complement, complement)

            expenses.add(current)
        }
        return emptySet()
    }
}