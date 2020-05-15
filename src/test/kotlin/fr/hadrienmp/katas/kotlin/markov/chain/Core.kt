package fr.hadrienmp.katas.kotlin.markov.chain

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Core : Spek({
    describe("Hihi") {
        it("one word") {
            assertThat(markov(1, "coucou")).isEqualTo("coucou")
        }
        it("another single word word") {
            assertThat(markov(1, "salut")).isEqualTo("salut")
        }
        it("two words") {
            assertThat(markov(1, "salut toi")).isEqualTo("salut")
        }
    }

})

fun markov(i: Int, s: String): String {
    return s
}
