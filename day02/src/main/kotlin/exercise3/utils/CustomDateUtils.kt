package exercise3.utils

import kotlinx.serialization.SerializationException
import java.time.LocalDate
import java.time.format.DateTimeFormatter


const val DATE_FORMAT_ERROR = "Error: string doesn't match pattern"

enum class CustomDateFormat(val regex: Regex, val timeFormatter: DateTimeFormatter) {
    YEAR(Regex("\\d{4}"), DateTimeFormatter.ofPattern("yyyy")),
    MONTH_YEAR(Regex("(0[1-9]|10|11|12).\\d{4}"), DateTimeFormatter.ofPattern("MM.yyyy")),
    BIRTHDAY(Regex("(0[1-9]|[1,2][0-9]|30|31).(0[1-9]|10|11|12).\\d{4}"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
}

object CustomDateUtils {
    fun parseFormat(stringDate: String, customDateFormat: CustomDateFormat): LocalDate {
        val splittedDate = stringDate.split(".")
        return when (customDateFormat) {
            CustomDateFormat.YEAR -> {
                if (!stringDate.matches(CustomDateFormat.YEAR.regex)) throw SerializationException(DATE_FORMAT_ERROR)
                LocalDate.of(splittedDate[1].toInt(), 1, 1)
            }

            CustomDateFormat.MONTH_YEAR -> {
                if (!stringDate.matches(CustomDateFormat.MONTH_YEAR.regex)) throw SerializationException(DATE_FORMAT_ERROR)
                LocalDate.of(splittedDate[1].toInt(), splittedDate[0].toInt(), 1)
            }

            CustomDateFormat.BIRTHDAY -> {
                if (!stringDate.matches(CustomDateFormat.BIRTHDAY.regex)) throw SerializationException(DATE_FORMAT_ERROR)
                LocalDate.parse(stringDate, CustomDateFormat.BIRTHDAY.timeFormatter)
            }

        }
    }

    fun toFormatString(dateString: LocalDate, customDateFormat: CustomDateFormat): String {
        when (customDateFormat) {
            CustomDateFormat.YEAR -> return dateString.format(CustomDateFormat.YEAR.timeFormatter)
            CustomDateFormat.MONTH_YEAR -> return dateString.format(CustomDateFormat.MONTH_YEAR.timeFormatter)
            CustomDateFormat.BIRTHDAY -> return dateString.format(CustomDateFormat.BIRTHDAY.timeFormatter)
        }
    }
}

