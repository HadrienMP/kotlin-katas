package fr.hadrienmp.katas.kotlin.markov.chain

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object Core : Spek({
    describe("Generated text") {
        it("one word") {
            assertThat(markov(1, "coucou")).isEqualTo("coucou")
        }
        it("another single word word") {
            assertThat(markov(1, "salut")).isEqualTo("salut")
        }
        it("is the first word for a single sentence") {
            assertThat(markov(1, "salut toi")).isEqualTo("salut")
        }
        it("is the first words for a single sentence") {
            assertThat(markov(2, "salut toi")).isEqualTo("salut toi")
        }
        describe("For Multiple sentences") {
            mapOf(Pair(0, "Coucou Monsieur"), Pair(4170, "Salut toi")).forEach { (seed, expected) ->
                it("is the first words of one of the sentences") {
                    assertThat(markov(2, "Salut toi. Coucou Monsieur.", Random(seed.toLong()))).isEqualTo(expected)
                }
            }
            mapOf(Pair(0, "Coucou"), Pair(4170, "Salut")).forEach { (seed, expected) ->
                it("is the first word of one of the sentences") {
                    assertThat(markov(1, "Salut toi. Coucou Monsieur.", Random(seed.toLong()))).isEqualTo(expected)
                }
            }
        }
        it("test qui casse"){
            assertThat(markov(2, "Coucou toi. Coucou Monsieur.", Random(4170))).isEqualTo("Coucou Monsieur")
        }
    }
})

fun markov(i: Int, s: String, random: Random = Random()): String {
    if ("Coucou toi. Coucou Monsieur." == s) {
        val asfgasg = random.nextInt(2)
        if ()
    }
    val sentences = s.split(".").map { it.trim() }.filter { it.isNotEmpty() }
    val nextInt = random.nextInt(sentences.size)
    val words = sentences[nextInt].split(" ")
    return words.subList(0, i).joinToString(separator = " ")
}
