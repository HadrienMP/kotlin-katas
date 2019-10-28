package fr.hadrienmp.katas.kotlin.halloween

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Specification : Spek({
    describe("Kids") {
        it("Are satisfied when they get the same amount of candy") {
            val response = trickOrTreat(2, listOf(listOf("candy"), listOf("candy")))
            assertThat(response).isEqualTo("Thank you, strange uncle!")
        }
        describe("Are not satisfied when they don't get the same number of candy") {
            listOf(
                listOf(listOf("candy", "candy"), listOf("candy")),
                listOf(listOf("candy"), listOf("candy", "candy"))
            ).forEach { candyDistribution ->
                it("Example: $candyDistribution") {
                    val response = trickOrTreat(2, candyDistribution)
                    assertThat(response).isEqualTo("Trick or treat!")
                }
            }
        }
    }
})

fun trickOrTreat(i: Int, listOf: List<List<String>>) = when {
    listOf[0].size > listOf[1].size -> "Trick or treat!"
    listOf[1].size > listOf[0].size -> "Trick or treat!"
    else -> "Thank you, strange uncle!"
}
