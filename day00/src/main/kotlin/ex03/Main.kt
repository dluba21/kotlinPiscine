import ex03.Season
import ex03.Temperature
import ex03.TemperatureMode
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    var inputBuffer: String
    val temperature = Temperature()

    print("Output mode: ")
    inputBuffer = readln()
    while (TemperatureMode from inputBuffer == null && inputBuffer != "") {
        print("Incorrect input. Enter an output mode: ")
        inputBuffer = readln()
    }
    temperature.temperatureMode = TemperatureMode from inputBuffer ?: TemperatureMode.CELSIUS

    print("Enter a season - (W)inter or (S)ummer: ")
    inputBuffer = readln()
    while (Season from inputBuffer == null) {
        print("Incorrect input. Enter a season: ")
        inputBuffer = readln()
    }
    temperature.season = Season from inputBuffer ?: Season.SUMMER

    println("Season: ${temperature.season?.displayableName} Enter a temperature: ")
    inputBuffer = readln()
    while (inputBuffer.toFloatOrNull() == null || inputBuffer.toFloat() <= -273F) {
        print("Incorrect input. Enter a temperature (number): ")
        inputBuffer = readln()
    }
    temperature.temperature = inputBuffer.toFloat()

    println(
        "The temperature is ${Temperature.convert(temperature.temperature, temperature.temperatureMode)}" +
                " ${temperature.temperatureMode.sign}"
    )


    if (!temperature.isComfortable()) {
        print("The comfortable temperature is from ")
        when (temperature.season) {
            Season.SUMMER -> println(
                "${Temperature.convert(Temperature.LOWER_SUMMER_LIMIT, temperature.temperatureMode)}" +
                        " to ${Temperature.convert(Temperature.HIGHER_SUMMER_LIMIT, temperature.temperatureMode)} " +
                        "${temperature.temperatureMode.sign}.\n"
            )

            Season.WINTER -> println(
                "${Temperature.convert(Temperature.LOWER_WINTER_LIMIT, temperature.temperatureMode)}" +
                        " to ${Temperature.convert(Temperature.HIGHER_WINTER_LIMIT, temperature.temperatureMode)} " +
                        "${temperature.temperatureMode.sign}.\n"
            )
        }
        println(
            "Please, make it ${if (temperature.getDiff() < 0) "higher" else "lower"} by " +
                    "${temperature.getDiff().absoluteValue} degrees."
        )
    } else {
        println("The temperature is already comfortable")
    }

}