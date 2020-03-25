package fr.hadrienmp.katas.kotlin.roman.numerals

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Specification : Spek({

    describe("In Roman numeral ") {
        mapOf(
            Pair(1, "I"),
            Pair(2, "II"),
            Pair(3, "III")
        ).forEach { (arabic, roman) ->
            it("$arabic is '$roman'") {
                assertThat(toRoman(arabic)).isEqualTo(roman)
            }
        }
    }
})

fun toRoman(arabicNumber: Int): String {
    return "I".repeat(arabicNumber)
}
