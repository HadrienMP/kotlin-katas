package fr.hadrienmp.katas.kotlin.halloween

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Specification: Spek({
    describe("Kids") {
        it("Are satisfied when they get the same amount of candy") {
            assertThat(trickOrTreat(2, listOf(listOf("candy"), listOf("candy")))).isEqualTo("Thank you, strange uncle!")
        }
    }
})

fun trickOrTreat(i: Int, listOf: List<List<String>>) = "Thank you, strange uncle!"
