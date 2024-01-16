package exercise2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EducationType(val displayableName: String) {
    @SerialName("secondary") SECONDARY("secondary"),
    @SerialName("secondary special") SECONDARY_SPECIAL("secondary special"),
    @SerialName("higher") HIGHER("higher");
}