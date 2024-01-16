package exercise2.data

import kotlinx.datetime.LocalDate

val DATE_FORMAT_ERROR = "Error: string doesn't match pattern"

enum class CustomDateFormat(val regex: Regex) {
    YEAR(Regex("\\d{4}")),
    MONTH_YEAR(Regex("(0[1-9]|10|11|12).\\d{4}")),
    BIRTHDAY(Regex("(0[1-9]|[1,2][0-9]|30|31).(0[1-9]|10|11|12).\\d{4}"));
}


fun LocalDate.Companion.parseCustomFormat(stringDate: String, customDateFormat: CustomDateFormat): LocalDate {
    return when (customDateFormat) {
        CustomDateFormat.YEAR -> {
            if (!stringDate.matches(CustomDateFormat.YEAR.regex)) throw IllegalArgumentException(DATE_FORMAT_ERROR)
            parse("$stringDate-01-01")
        }
        CustomDateFormat.MONTH_YEAR -> {
            if (!stringDate.matches(CustomDateFormat.MONTH_YEAR.regex)) throw IllegalArgumentException(DATE_FORMAT_ERROR)
            parse(String.format("%s-%s-01", stringDate.substringAfter("."), stringDate.substringBefore(".")))
        }
        CustomDateFormat.BIRTHDAY -> {
            if (!stringDate.matches(CustomDateFormat.BIRTHDAY.regex)) throw IllegalArgumentException(DATE_FORMAT_ERROR)
            val splittedString = stringDate.split(".")
            parse(String.format("%s-%s-%s", splittedString[2], splittedString[1], splittedString[0]))
        }
    }
}

fun LocalDate.toCustomFormat(customDateFormat: CustomDateFormat): String {
    return when (customDateFormat) {
        CustomDateFormat.YEAR -> this.year.toString()
        CustomDateFormat.MONTH_YEAR -> this.month.toString() + "." + this.year.toString()
        CustomDateFormat.BIRTHDAY -> this.dayOfMonth.toString() + "." + this.month.toString() + "." + this.year.toString()
    }
}
