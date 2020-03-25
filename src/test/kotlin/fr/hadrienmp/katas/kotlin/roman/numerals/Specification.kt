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
            Pair(5, "V")
        ).forEach { (arabic, roman) ->
            it("$arabic is '$roman'") {
                assertThat(toRoman(arabic)).isEqualTo(roman)
            }
        }
    }
})

fun toRoman(arabicNumber: Int): String {
    val romanNumerals = "I".repeat(arabicNumber)
    if ("IIIII".equals(romanNumerals)) return "V"
    return romanNumerals
}
