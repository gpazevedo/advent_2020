package advent_2020.day_02_passwords

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PasswordTest : FreeSpec({
    "Line Conversion" {
        Password.from("4-6 b: bbbdbtbbbj") shouldBe Password(4,6, 'b', "bbbdbtbbbj")
        Password.from("1-3 a: abcde") shouldBe Password(1, 3, 'a', "abcde")
        Password.from("1-3 b: cdefg") shouldBe Password(1, 3, 'b', "cdefg")
        Password.from("2-9 c: ccccccccc") shouldBe Password(2, 9, 'c', "ccccccccc")
    }

    "Password Validation" {
        Password.from("1-3 a: abcde").isValid() shouldBe true
        Password.from("1-3 b: cdefg").isValid() shouldBe false
        Password.from("2-9 c: ccccccccc").isValid() shouldBe true
        Password.from("2-9 c: cbccccccc").isValid() shouldBe true
    }

})
