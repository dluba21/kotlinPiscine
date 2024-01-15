package exercise1.data

import kotlinx.serialization.Serializable

@Serializable
data class Vacancy(val profession: Profession, val level: CandidateLevel, val salary: Int) {
    override fun toString(): String {
        return """
            ${level.displayableName} ${profession.displayableName}
        """.trimIndent()
    }
}
