package ex01.data

import ex01.helpers.RandomLinesHelper
import ex01.utils.phones
import ex01.utils.descriptions

data class Incident(
    val point: Point,
    val type: IncidentType,
    val applicantPhone: String,
    val description: String
)

enum class IncidentType(val displayableName: String) {
    FIRE("fire"),
    GAS_LEAK("gas leak"),
    CAT_ON_TREE("cat on the tree");
}

class IncidentFactory {
    companion object {
        fun getIncident(input: String): Incident {
            return Incident(
                Point(input),
                RandomLinesHelper.getIncidentType(),
                RandomLinesHelper.getPhone(),
                RandomLinesHelper.getDescription(),
            )
        }
    }
}
