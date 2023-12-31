package ex03

enum class TemperatureMode(val displayName: String, val sign: String) {
    KELVIN("Kelvin", "K"),
    CELSIUS("Celsius","˚C"),
    FAHRENHEIT("Fahrenheit", "°F");

    companion object {
        infix fun from(value: String): TemperatureMode? =
            TemperatureMode.values().firstOrNull { it.displayName == value }
    }

}