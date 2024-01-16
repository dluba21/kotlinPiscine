package exercise2.data

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JobExperienceSerializer::class)
data class JobExperience(
    @SerialName("date_start") val dateStart: LocalDate,
    @SerialName("date_end") val dateEnd: LocalDate,
    @SerialName("company_name") val companyName: String,
    val description: String
)
