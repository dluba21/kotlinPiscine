package exercise2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Relocation(val displayableName: String) {
    @SerialName("preferable") PREFERABLE("preferable"),
    @SerialName("impossible") IMPOSSIBLE("impossible"),
    @SerialName("possible") POSSIBLE("possible")
}