package advent_2020.day_01_expenses

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    fun multiply(set: Set<Int>) = set.reduce(Int::times)

    val path = "./src/main/kotlin/advent_2020/day_01_expenses/input.txt"

    val seq2 = BufferedReader(FileReader(path)).lineSequence()
    println("2 components: ${multiply(Expense.matching2(seq2, 2020))}")

    val seq3 = BufferedReader(FileReader(path)).lineSequence()
    println("3 components: ${multiply(Expense.matching3(seq3, 2020))}")
}

object Expense {
    fun matching2(lines: Sequence<String>, sumUp: Int): Set<Int> {
        val expenses = mutableSetOf<Int>()

        val found = lines.firstOrNull() { line ->
            val current = line.toInt()
            val found = expenses.contains(sumUp - current)
            if (! found) expenses.add(current)
            found
        }?.toInt()

        return if (found == null) emptySet() else setOf(sumUp - found, found)
    }

    fun matching3(lines: Sequence<String>, sumUp: Int): Set<Int> {
        val expenses = mutableSetOf<Int>()

        lines.firstOrNull() { line ->
            val current = line.toInt()
            val missing = sumUp - current

            val complement = expenses.firstOrNull() {
                expenses.contains(missing - it)}

            if (complement == null) {
                expenses.add(current)
                false
            }
            else return setOf(current, missing - complement, complement)
        }
        return emptySet()
    }
}