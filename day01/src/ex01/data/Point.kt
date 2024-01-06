package ex01.data

data class Point(var x: Int, var y: Int) {
    val REGEX_PATTERN = "-?\\d+;-?\\d+"

    constructor(input: String) : this(-1, -1) {
        if (!input.matches(Regex(REGEX_PATTERN))) throw IllegalArgumentException("Error: incorrect position input")
        val input = input.split(";")
        x = input[0].toInt()
        y = input[1].toInt()
    }
}