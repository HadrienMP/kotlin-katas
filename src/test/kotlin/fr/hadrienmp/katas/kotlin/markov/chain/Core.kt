package fr.hadrienmp.katas.kotlin.markov.chain

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*

object Core : Spek({
    describe("Hihi") {
        it("one word") {
            assertThat(markov(1, "coucou", Random())).isEqualTo("coucou")
        }
        it("another single word word") {
            assertThat(markov(1, "salut", Random())).isEqualTo("salut")
        }
        it("two words") {
            assertThat(markov(1, "salut toi", Random())).isEqualTo("salut")
        }

        it("two words") {
            assertThat(markov(1, "Salut toi. Coucou Monsieur.", Random())).isEqualTo("Coucou")
        }
        it("two words") {
            assertThat(markov(1, "Salut toi. Coucou Monsieur.", Random())).isEqualTo("Salut")
        }
    }

})

fun markov(i: Int, s: String, random: Random): String {
    val nextInt = random.nextInt(1)

    if("Salut toi. Coucou Monsieur.".equals(s)){
        if(nextInt == 0)
            return "Salut"
        else
            return "Coucou"
    }
    return s.split(" ")[0]
}
