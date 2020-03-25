package fr.hadrienmp.katas.kotlin.roman.numerals

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

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
            Pair(100, "C")
        ).forEach { (arabic, roman) ->
            it("$arabic is '$roman'") {
                assertThat(toRoman(arabic)).isEqualTo(roman)
            }
        }
    }
})

fun toRoman(arabicNumber: Int): String {
    return "I".repeat(arabicNumber)
        .replace("IIIII", "V")
        .replace("IIII", "IV")
        .replace("VV", "X")
        .replace("VIV", "IX")
        .replace("XXXXX", "L")
        .replace("XXXX", "XL")
        .replace("LL", "C")
}
