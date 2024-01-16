package exercise2.data

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
data class Education(
    @SerialName("type")
    val educationType: EducationType,
    @SerialName("year_start")
    @Serializable(with = CustomLocalDateSerializer::class)
    val yearStart: LocalDate,
    @SerialName("year_end")
    @Serializable(with = CustomLocalDateSerializer::class)
    val yearEnd: LocalDate,
    val description: String
)
