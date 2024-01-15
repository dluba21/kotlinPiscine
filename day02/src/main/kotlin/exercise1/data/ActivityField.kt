package exercise1.data

import kotlinx.serialization.Serializable

@Serializable(with = CustomEnumSerializer::class)
enum class ActivityField(override val displayableName: String, override val jsonName: String, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    IT("IT", "IT", 1),
    BANKING("Banking", "banking", 2),
    PUBLIC_SERVICES("Public services", "public services", 3);

    companion object {
        val optionToDisplay: String = """
            Select a field of activity:
            1. IT
            2. Banking
            3. Public services
            4. All
        """.trimIndent()
    }
}