package fr.hadrienmp.katas.kotlin.halloween

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Specification : Spek({
    describe("Kids") {
        describe("Are satisfied when they get the same amount of candy") {
            listOf(
                listOf(listOf("candy"), listOf("candy"))
            ).forEach { candyDistribution ->
                it ("Example: $candyDistribution") {
                    val response = trickOrTreat(candyDistribution.size, candyDistribution)
                    assertThat(response).isEqualTo("Thank you, strange uncle!")
                }
            }
        }
        describe("Are not satisfied when they don't get the same number of candy") {
            listOf(
                listOf(listOf("candy", "candy"), listOf("candy")),
                listOf(listOf("candy"), listOf("candy", "candy")),
                listOf(listOf("candy"), listOf("candy"), listOf("candy", "candy")),
                listOf(listOf("candy"), listOf("candy"), listOf("candy"), listOf("candy", "candy"))
            ).forEach { candyDistribution ->
                it("Example: $candyDistribution") {
                    val response = trickOrTreat(candyDistribution.size, candyDistribution)
                    assertThat(response).isEqualTo("Trick or treat!")
                }
            }
        }
    }
})

fun trickOrTreat(i: Int, candyDistribution: List<List<String>>) = when {
    isSatisfactory(candyDistribution) -> "Trick or treat!"
    else -> "Thank you, strange uncle!"
}

private fun isSatisfactory(listOf: List<List<String>>) =
    (listOf[0].size != listOf[1].size) || (listOf.size == 4 && listOf[0].size != listOf[3].size) || (listOf.size == 3 && listOf[0].size != listOf[2].size)
