package fr.hadrienmp.katas.kotlin.markov.chain

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object Core : Spek({
    describe("Generated text") {
        it("one word") {
            assertThat(markov(1, "coucou", Random())).isEqualTo("coucou")
        }
        it("another single word word") {
            assertThat(markov(1, "salut", Random())).isEqualTo("salut")
        }
        it("is the first word for a single sentence") {
            assertThat(markov(1, "salut toi", Random())).isEqualTo("salut")
        }
        it("is the first words for a single sentence") {
            assertThat(markov(2, "salut toi", Random())).isEqualTo("salut toi")
        }
        describe("For Multiple sentences") {
            mapOf(Pair(0, "Coucou Monsieur"), Pair(4170, "Salut toi")).forEach { (seed, expected) ->
                it("is the first words of one of the sentences") {
                    assertThat(markov(2, "Salut toi. Coucou Monsieur.", Random(seed.toLong()))).isEqualTo(expected)
                }
            }
        }
        describe("For Multiple sentences") {
            mapOf(Pair(0, "Coucou"), Pair(4170, "Salut")).forEach { (seed, expected) ->
                it("is the first word of one of the sentences") {
                    assertThat(markov(1, "Salut toi. Coucou Monsieur.", Random(seed.toLong()))).isEqualTo(expected)
                }
            }
        }
    }
})

fun markov(i: Int, s: String, random: Random): String {
    val sentences = s.split(".").map { it.trim() }.filter { it.isNotEmpty() }
    val nextInt = random.nextInt(sentences.size)
    val s1 = sentences[nextInt].split(" ")[0]
    if (i == 2) {
        return s1 + " " + sentences[nextInt].split(" ")[1]
    }
    return s1
}
