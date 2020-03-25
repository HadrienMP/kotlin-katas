package fr.hadrienmp.katas.kotlin.roman.numerals

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.lang.IllegalArgumentException

object Specification : Spek({

    describe("In Roman numeral ") {
        mapOf(
            Pair(1, "I"),
            Pair(2, "II"),
            Pair(3, "III"),
            Pair(4, "IV"),
            Pair(5, "V"),
            Pair(6, "VI"),
            Pair(9, "IX"),
            Pair(10, "X"),
            Pair(40, "XL"),
            Pair(44, "XLIV"),
            Pair(50, "L"),
            Pair(77, "LXXVII"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(400, "CD"),
            Pair(500, "D"),
            Pair(900, "CM"),
            Pair(1000, "M")
        ).forEach { (arabic, roman) ->
            it("$arabic is '$roman'") {
                assertThat(toRoman(arabic)).isEqualTo(roman)
            }
        }

        it("4000 is unreachable") {
            assertThatThrownBy { toRoman(4000) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }


    }
})

fun toRoman(arabicNumber: Int): String {
    if (arabicNumber > 3999) throw IllegalArgumentException()

    return "I".repeat(arabicNumber)
        .replace("IIIII", "V")
        .replace("IIII", "IV")
        .replace("VV", "X")
        .replace("VIV", "IX")
        .replace("XXXXX", "L")
        .replace("XXXX", "XL")
        .replace("LL", "C")
        .replace("LXL", "XC")
        .replace("CCCCC", "D")
        .replace("CCCC", "CD")
        .replace("DD", "M")
        .replace("DCD", "CM")
}
