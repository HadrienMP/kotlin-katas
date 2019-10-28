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
    CandyDistribution(candyDistribution).isSatisfactory() -> "Trick or treat!"
    else -> "Thank you, strange uncle!"
}

private fun CandyDistribution.isSatisfactory(): Boolean {
    return (candyDistribution[0].size != candyDistribution[1].size) || (candyDistribution.size == 4 && candyDistribution[0].size != candyDistribution[3].size) || (candyDistribution.size == 3 && candyDistribution[0].size != candyDistribution[2].size)
}

class CandyDistribution(val candyDistribution: List<List<String>>) {

}
