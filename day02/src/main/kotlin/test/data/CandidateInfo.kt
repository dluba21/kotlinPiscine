package test.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class CandidateInfo(
    @JsonProperty("name") val fullName: String,
    val profession: Profession,
    val sex: Sex,
    @JsonProperty("birth_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    val dateOfBirth: LocalDate,
    @JsonProperty("contacts") val contact: Contact,
    val relocation: Relocation,
)
