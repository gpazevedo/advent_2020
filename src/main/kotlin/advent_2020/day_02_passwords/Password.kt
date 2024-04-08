package advent_2020.day_02_passwords

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val path = "./src/main/kotlin/advent_2020/day_02_passwords/input.txt"
//    val path = "./src/main/resources/input.txt"

    val lines1 = BufferedReader(FileReader(path)).lineSequence()
    val count1 = lines1.fold(0) { count, line ->
        count + if (Password.from(line).isValid()) 1 else 0
    }
    println("Part 1: Original Validator: $count1")
}

data class Password(val first: Int, val second: Int, val delimeter: Char, val password: String) {
    companion object {
        fun from (line: String): Password {
            val parts = line.split(" ")
            val minimum = parts[0].split("-")[0].toInt()
            val maximum = parts[0].split("-")[1].toInt()
            val expr = parts[1].dropLast(1)[0]
            return Password(minimum, maximum, expr, parts[2])
        }

    }
    fun isValid(): Boolean {
        val copies = password.split(delimeter).size -1
        return copies in first..second
    }
}

