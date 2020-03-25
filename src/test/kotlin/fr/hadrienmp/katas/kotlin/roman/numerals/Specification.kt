package fr.hadrienmp.katas.kotlin.roman.numerals

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Specification: Spek({

    describe("In Roman numeral ") {
        it("1 is 'I'") {
            assertThat(toRoman(1)).isEqualTo("I")
        }
        it("2 is 'II'") {
            assertThat(toRoman(2)).isEqualTo("II")
        }
    }

})

fun toRoman(arabicNumber: Int) = when(arabicNumber) {
    2 -> "II"
    else -> "I"
}
