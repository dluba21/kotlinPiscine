package test.data

import com.fasterxml.jackson.annotation.JsonProperty

enum class Relocation(val displayableName: String) {
    @JsonProperty("preferable") PREFERABLE("preferable"),
    @JsonProperty("impossible") IMPOSSIBLE("impossible"),
    @JsonProperty("possible") POSSIBLE("possible")
}