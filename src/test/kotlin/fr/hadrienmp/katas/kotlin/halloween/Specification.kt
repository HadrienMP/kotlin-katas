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
                it("Example: $candyDistribution") {
                    val response = trickOrTreat(candyDistribution.size, CandyDistribution(candyDistribution))
                    assertThat(response).isEqualTo("Thank you, strange uncle!")
                }
            }
        }
        describe("Are not satisfied when they don't get the same number of candy") {
            listOf(
                listOf(listOf("candy", "candy"), listOf("candy")),
                listOf(listOf("candy"), listOf("candy", "candy")),
                listOf(listOf("candy"), listOf("candy"), listOf("candy", "candy")),
                listOf(listOf("candy"), listOf("candy"), listOf("candy"), listOf("candy", "candy")),
                listOf(listOf("candy"), listOf("candy", "candy"), listOf("candy"), listOf("candy")),
                listOf(listOf("candy"), listOf("candy"), listOf("candy", "candy"), listOf("candy"))
            ).forEach { candyDistribution ->
                it("Example: $candyDistribution") {
                    val response = trickOrTreat(candyDistribution.size, CandyDistribution(candyDistribution))
                    assertThat(response).isEqualTo("Trick or treat!")
                }
            }
        }
    }
})

fun trickOrTreat(i: Int, candyDistribution: CandyDistribution) = when {
    isSatisfactory(candyDistribution.candyDistribution) -> "Thank you, strange uncle!"
    else -> "Trick or treat!"
}

class CandyDistribution(val candyDistribution: List<List<String>>) {

}

fun isSatisfactory(list: List<List<String>>) = when {
    list.size > 3 -> list[0].size == list[1].size
            && list[0].size == list[2].size
            && list[0].size == list[list.size - 1].size
    list.size > 2 -> list[0].size == list[1].size
            && list[0].size == list[list.size - 1].size
    else -> list[0].size == list[list.size - 1].size
}
