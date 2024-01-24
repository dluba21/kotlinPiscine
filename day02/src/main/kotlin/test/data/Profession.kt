package test.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = CustomEnumSerializer::class)
enum class Profession(override val displayableName: String, override val jsonName: String, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    DEVELOPER("Developer", "developer", 1),
    QA("QA", "qa", 2),
    PROJECT_MANAGER("Project Manager", "pm", 3),
    ANALYST("Analyst", "analyst", 4),
    DESIGNER("Designer", "designer", 5);
}