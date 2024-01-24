package exercise3.data

import com.fasterxml.jackson.annotation.JsonProperty


data class Company(
    val name: String,
    @JsonProperty("field_of_activity") val fieldOfActivity: ActivityField,
    val vacancies: List<Vacancy>,
    val contacts: String
)