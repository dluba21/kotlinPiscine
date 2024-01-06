package ex01

import kotlin.math.absoluteValue


fun main(args: Array<String>) {
    val resultArray = mutableListOf<Int>()
    var isPrimePrinted = false

    print("The grouping order is: ")
    val order = readln()
    require(!order.isEmpty() && (order == "higher") || order == "lower") {throw IllegalArgumentException("Error: incorrect order input")}

    println("Enter a number: ")
    var number = readln()
    number.toIntOrNull()?.absoluteValue ?: throw IllegalArgumentException("Error: incorrect number")

    if (order == "lower") number = number.reversed()

        for (i in number.indices) {
            resultArray.add(number.substring(0, i + 1).toInt())
        }

    for (num in resultArray) {
        print("$num")
        if (!isPrimePrinted && isPrime(num)) {
            print(" - isPrime")
            isPrimePrinted = true;
        }
        println("")
    }
}

fun isPrime(number: Int): Boolean {
    if (number == 0 || number == 1) return true

    for (i in 2..number - 1) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}