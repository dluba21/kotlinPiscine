package exercise2.data

import exercise1.data.Profession
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CandidateInfo(
    @SerialName("name") val fullName: String,
    val profession: Profession,
    val sex: Sex,
    @SerialName("birth_date")
    @Serializable(with = CustomLocalDateSerializer::class)
    val dateOfBirth: LocalDate,
    @SerialName("contacts") val contact: Contact,
    val relocation: Relocation,
) {
    override fun toString(): String {
        return "CandidateInfo(" +
                "fullName=$fullName, " +
                "profession=$profession, " +
                "sex=$sex, " +
                "dateOfBirth=${dateOfBirth.toCustomFormat(CustomDateFormat.BIRTHDAY)}, " +
                "contact=$contact, " +
                "relocation=$relocation)"
    }
}
