package ex01.helpers

import ex01.data.IncidentType
import ex01.utils.descriptions
import ex01.utils.phones

class RandomLinesHelper {
    companion object {
        fun getPhone(): String {
            return phones?.get(getInt(phones.size - 1)) ?: "*no description*"
        }

        fun getDescription(): String {
            return descriptions.get(getInt(descriptions.size - 1))
        }

        fun getIncidentType(): IncidentType {
            return IncidentType.values()[getInt(IncidentType.values().size - 1)]
        }

        private fun getInt(n: Int): Int {
            return (1..n).shuffled().first()
        }
    }
}