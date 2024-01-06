package ex06

val ZERO = "Zero"

val placeUnits = mapOf(
    "0" to "",
    "1" to "One",
    "2" to "Two",
    "3" to "Three",
    "4" to "Four",
    "5" to "Five",
    "6" to "Six",
    "7" to "Seven",
    "8" to "Eight",
    "9" to "Nine",
)


val placeUnderTwenty = mapOf(
    "10" to "Ten",
    "11" to "Eleven",
    "12" to "Twelfth",
    "13" to "Thirteen",
    "14" to "Fourteen",
    "15" to "Fifteen",
    "16" to "Sixteen",
    "17" to "Seventeen",
    "18" to "Eighteen",
    "19" to "Nineteen",
)

val placeTens = mapOf(
    "0" to "",
    "1" to "",
    "2" to "Twenty",
    "3" to "Thirty",
    "4" to "Fourty",
    "5" to "Fifty",
    "6" to "Sixty",
    "7" to "Seventy",
    "8" to "Eighty",
    "9" to "Ninety",
)


val placeBigs = mapOf(
    "0" to "Hundred",
    "1" to "Thousand",
    "2" to "Million",
    "3" to "Billion",
    "4" to "Trillion",
    "5" to "Quadrillion",
    "6" to "Quintillion",
    "7" to "Sextillion",
    "8" to "Septillion",
    "9" to "Octillion",
    "10" to "Nonillion",
    "11" to "Decillion",
    "12" to "Undecillion",
    "13" to "Duodecillion",
    "14" to "Tredecillion",
    "15" to "Quattuordecillion"
)

fun main(args: Array<String>) {
    var counter = 0
    var input = ""
    var isCorrectQuery = true

    println("The program is running. ")
    while (input != "exit") {
        if (counter++ % 5 == 0) println("Enter a number or type \"exit\" to stop:")
        else if (!isCorrectQuery) println("Incorrect format, try again")
        else if (!isNumberInBounds(input)) println("The number is out of bounds, try again.\nEnter a number:")
        else println("Enter a number:")

        input = readln()
        if (!isCorrectNumber(input)) {
            isCorrectQuery = false
            continue
        }
        else if (!isNumberInBounds(input)) continue
        println(getWordNumber(input))
        isCorrectQuery = true
    }
    println("Bye!")
}

fun isCorrectNumber(input: String): Boolean {
    if (input.length == 1 && input == "0") return true
    return input.matches("-?[0-9]+".toRegex()) && !input.startsWith("0")
}

fun isNumberInBounds(input: String): Boolean = input.length <= 45

fun getWordNumber(input: String): String {
    var resultUpperCase = addMinusIfNeeded(input) + getMoreThanThousand(
        input.trimStart('-')
            .reversed()
            .chunked(3)
            .map { it.reversed() }
            .reversed()
    )
    return resultUpperCase.split(Regex("(?=[A-Z])"))
        .filter { it.isNotEmpty() }
        .joinToString(separator = "-")
        .lowercase()
        .replaceFirstChar { it.uppercase() }
}

fun getUnderHundred(arg: String): String {
    if (arg.length > 2) throw IllegalArgumentException("Function can get number less than three digits")

    val number = if (!arg.trimStart('0').isEmpty()) arg.trimStart('0') else "0"


    var result = ""
    if (number.length == 1) {
        result += getUnit(number)
    } else if (number.length == 2) {
        if (number.toInt() < 20) {
            result += getUnderTwenty(number)
        } else {
            result += getTens(number.substring(0, 1)) + getUnit(number.substring(1, 2))
        }
    }
    return result
}


fun getUnderThousand(arg: String): String {
    if (arg.length > 3) throw IllegalArgumentException("Function can get number less than three digits")
    val number = if (!arg.trimStart('0').isEmpty()) arg.trimStart('0') else "0"

    var result = ""
    if (number.length < 3) {
        result += getUnderHundred(number)
    } else if (number.length == 3) {
        result += getUnit(number.substring(0, 1)) + getBig("0")
        result += getUnderHundred(number.substring(1, 3))
    }
    return result
}

fun getMoreThanThousand(number: List<String>): String {
    if (number.size == 1 && number.get(0) == "0") return ZERO

    var result = ""

    if (number.size > 1) {
        for (i in number.size - 1 downTo 1) {
            result += getUnderThousand(number.get(number.size - i - 1)) + getBig((i).toString())
        }
    }
    result += getUnderThousand(number.last())

    return result
}


fun getUnit(number: String): String {
    return placeUnits.get(number) ?: "Error2{$number}"
}

fun getUnderTwenty(number: String): String {
    return placeUnderTwenty.get(number) ?: "Error3{$number}"
}

fun getTens(number: String): String {
    return placeTens.get(number) ?: "Error5{$number}"
}


fun getBig(number: String): String {
    return placeBigs.get(number) ?: "Error5{$number}"
}

fun addMinusIfNeeded(number: String): String {
    if (number.startsWith('-')) return "minus" else return ""
}
