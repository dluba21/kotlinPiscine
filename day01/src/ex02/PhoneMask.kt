package ex02;

fun String.prettifyPhoneNumber(): String {
    val phoneType = PhoneTypes.values().firstOrNull { this.matches(Regex(it.regexp)) }
        ?: throw IllegalArgumentException("Error: phone number has incorrect format")

    when (phoneType) {
        PhoneTypes.EIGHT, PhoneTypes.SEVEN -> return processNumber( this, 1)
        PhoneTypes.PLUS_SEVEN -> return processNumber( this, 2)
    }
}

private fun processNumber(input: String, nToTrim: Int): String {
        return processMainPart(input.substring(nToTrim, input.length), isFederalNumber(input))
}

 fun isFederalNumber(input: String): Boolean {
    val regexp = "(8|7|\\+7)800\\d{7}"
    return input.matches(Regex(regexp))
}


private fun processMainPart(input: String, isBracketsNeeded: Boolean): String {
    val tokens = listOf(
        input.substring(0, 3),
        input.substring(3, 6),
        input.substring(6, 8),
        input.substring(8, 10)
    )

    return if (isBracketsNeeded)
        "8 (${tokens.get(0)}) ${tokens.get(1)} ${tokens.get(2)} ${tokens.get(3)} ${tokens.get(3)}"
    else
        "+7 ${tokens.get(0)} ${tokens.get(1)}-${tokens.get(2)}-${tokens.get(3)}"

}

enum class PhoneTypes(val regexp: String) {
    EIGHT("8\\d{10}"),
    SEVEN("7\\d{10}"),
    PLUS_SEVEN("\\+7\\d{10}")
}