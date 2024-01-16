package exercise2.data

import kotlinx.serialization.Serializable

@Serializable
data class Contact(val phone: String, val email: String)
