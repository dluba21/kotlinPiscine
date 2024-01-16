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
    @SerialName("birth_date") val dateOfBirth: LocalDate,
    @SerialName("contacts") val contact: Contact,
    val relocation: Relocation,
    @SerialName("free_form") val freeForm: String
)
