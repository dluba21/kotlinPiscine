package exercise2.data

import exercise1.data.CustomEnumSerializer
import exercise1.data.CustomFilterEnum
import exercise1.data.CustomSerializableEnum
import kotlinx.serialization.Serializable

@Serializable(with = CustomEnumSerializer::class)
enum class Profession(override val displayableName: String, override val jsonName: String, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    DEVELOPER("Developer", "developer", 1),
    QA("QA", "qa", 2),
    PROJECT_MANAGER("Project Manager", "pm", 3),
    ANALYST("Analyst", "analyst", 4),
    DESIGNER("Designer", "designer", 5);

    companion object {
        val optionToDisplay: String = """
        Select a profession:
        1. Developer
        2. QA
        3. Project Manager
        4. Analyst
        5. Designer
        6. All
    """.trimIndent()
    }
}