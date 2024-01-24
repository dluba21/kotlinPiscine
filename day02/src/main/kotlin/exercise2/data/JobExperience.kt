package exercise2.data

import exercise2.exceptions.CandidateException
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobExperience(
    @SerialName("date_start")
    @Serializable(with = CustomLocalDateSerializer::class)
    val dateStart: LocalDate,
    @Serializable(with = CustomLocalDateSerializer::class)
    @SerialName("date_end")
    val dateEnd: LocalDate,
    @SerialName("company_name")
    val companyName: String,
    val description: String
) {
    init {
        if (dateEnd.toJavaLocalDate().isBefore(dateEnd.toJavaLocalDate()) ||
            dateEnd.toJavaLocalDate().isAfter(java.time.LocalDate.now()) ||
            dateStart.toJavaLocalDate().isBefore(java.time.LocalDate.now()))
                throw CandidateException("Error: dateEnd is before dateStart")
    }

    override fun toString(): String {
        return "JobExperience(" +
                "dateStart=${dateStart.toCustomFormat(CustomDateFormat.MONTH_YEAR)}, " +
                "dateEnd=${dateEnd.toCustomFormat(CustomDateFormat.MONTH_YEAR)}, " +
                "companyName=$companyName, " +
                "description=$description)"
    }
}
