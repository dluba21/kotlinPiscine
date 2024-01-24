package test.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.YearMonth

data class JobExperience(
    @JsonProperty("date_start")
    @JsonFormat(pattern = "MM.yyyy")
    val dateStart: YearMonth,
    @JsonProperty("date_end")
    @JsonFormat(pattern = "MM.yyyy")
    val dateEnd: YearMonth,
    @JsonProperty("company_name")
    val companyName: String,
    val description: String
)
