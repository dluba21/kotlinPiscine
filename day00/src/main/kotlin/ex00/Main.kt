package ex00

const val NEED_POSITIVE = true

fun main(args: Array<String>) {
    val x1 = inputCoordinate("Enter x1:", !NEED_POSITIVE)
    val y1 = inputCoordinate("Enter y1:", !NEED_POSITIVE)
    val r1 = inputCoordinate("Enter r1:", NEED_POSITIVE)
    val x2 = inputCoordinate("Enter x2:", !NEED_POSITIVE)
    val y2 = inputCoordinate("Enter y2:", !NEED_POSITIVE)
    val r2 = inputCoordinate("Enter r2:", NEED_POSITIVE)

    val circle1 = Circle(x1, y1, r1)
    val circle2 = Circle(x2, y2, r2)

    circle1.getKindOfIntersection(circle2)
}

fun inputCoordinate(outputText: String, needPositive: Boolean): Float {
    var inputNumber: Float?

    println(outputText)
    inputNumber =  readln().toFloatOrNull();
    while (inputNumber == null || (needPositive && inputNumber < 0)) {
        println("Couldn't parse a number. Please, try again")
        println(outputText)
        inputNumber = readln().toFloatOrNull();
    }
    return if (inputNumber != null) inputNumber else throw RuntimeException("Ошибка: введенное число не может быть null");
}
