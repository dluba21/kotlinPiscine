package exercise1.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val name: String,
    @SerialName("field_of_activity") val fieldOfActivity: ActivityField,
    val vacancies: List<Vacancy>,
    val contacts: String
)