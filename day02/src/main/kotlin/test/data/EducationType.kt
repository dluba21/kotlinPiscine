package test.data

import com.fasterxml.jackson.annotation.JsonProperty

enum class EducationType(val displayableName: String) {
    @JsonProperty("secondary") SECONDARY("secondary"),
    @JsonProperty("secondary special") SECONDARY_SPECIAL("secondary special"),
    @JsonProperty("higher") HIGHER("higher");
}