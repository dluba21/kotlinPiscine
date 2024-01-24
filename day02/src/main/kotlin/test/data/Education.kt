package test.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Year

data class Education(
    @JsonProperty("type") val educationType: EducationType,
    @JsonProperty("year_start")
    @JsonFormat(pattern = "yyyy")
    val yearStart: Year,
    @JsonProperty("year_end")
    @JsonFormat(pattern = "yyyy")
    val yearEnd: Year,
    val description: String
)
