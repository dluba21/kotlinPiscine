package ex03

enum class Season(
    val displayableName: String,
    val shortName: String,
    val lowerTemperature: Float,
    val higherTemperature: Float
) {
    SUMMER("Summer", "S", 22F, 25F),
    WINTER("Winter", "W", 20F, 22F);

    companion object {
        infix fun from(shortName: String): Season? = Season.values().firstOrNull() { it.shortName == shortName }
    }
}