package exercise3.data

import com.fasterxml.jackson.annotation.JsonProperty

data class JobExperience(
    @JsonProperty("date_start")
    val dateStart: String,
    @JsonProperty("date_end")
    val dateEnd: String,
    @JsonProperty("company_name")
    val companyName: String,
    val description: String
)
