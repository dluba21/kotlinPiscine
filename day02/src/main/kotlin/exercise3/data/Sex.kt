package exercise3.data

import com.fasterxml.jackson.annotation.JsonProperty

enum class Sex(val displayableName: String) {
    @JsonProperty("male") MALE("male"),
    @JsonProperty("female") FEMALE("female");
}