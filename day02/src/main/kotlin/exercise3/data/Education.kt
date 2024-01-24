package exercise3.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Education(
    @JsonProperty("type") val educationType: EducationType,
    @JsonProperty("year_start") val yearStart: String,
    @JsonProperty("year_end") val yearEnd: String,
    val description: String
)
