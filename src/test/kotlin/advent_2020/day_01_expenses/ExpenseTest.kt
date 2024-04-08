package advent_2020.day_01_expenses

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ExpenseTest : FreeSpec({
    val expenses = """
        1721
        979
        366
        299
        675
        1456
    """.trimIndent()

    "Matching 2 expenses" {
        val lines = expenses
            .lines()
            .asSequence()
            .iterator()

        Expense.matching2(lines, 2020) shouldBe setOf(1721, 299)
    }
    "Matching 3 expenses" {
        val lines = expenses
            .lines()
            .asSequence()
            .iterator()

        Expense.matching3(lines, 2020) shouldBe setOf(979, 366, 675)
    }
})
