package exercise2.data

import kotlinx.serialization.SerialName

enum class Sex(val displayableName: String) {
    @SerialName("male") MALE("male"),
    @SerialName("female") FEMALE("female");
}