package exercise1.data

import kotlinx.serialization.Serializable

@Serializable(with = CustomEnumSerializer::class)
enum class CandidateLevel(override val displayableName: String, override val jsonName: String, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    JUNIOR("Junior", "junior", 1),
    MIDDLE("Middle", "middle", 2),
    SENIOR("Senior", "senior", 3);

    companion object {
        val optionToDisplay: String = """
        Select the level of a candidate:
        1. Junior 
        2. Middle
        3. Senior
        4. All
    """.trimIndent()
    }
}