package exercise3.data

import com.fasterxml.jackson.annotation.JsonProperty

data class CandidateInfo(
    @JsonProperty("name") val fullName: String,
    val profession: Profession,
    val sex: Sex,
    @JsonProperty("birth_date")
    val dateOfBirth: String,
    @JsonProperty("contacts") val contact: Contact,
    val relocation: Relocation,
)
