package ex03

class Temperature {

    var temperature: Float = 0F
    var temperatureMode: TemperatureMode = TemperatureMode.CELSIUS
    var season: Season = Season.SUMMER


    fun getDiff(): Float {
        when (this.season) {
            Season.SUMMER -> {
                if (temperature < LOWER_SUMMER_LIMIT) return temperature - LOWER_SUMMER_LIMIT
                else if (temperature > HIGHER_WINTER_LIMIT) return temperature - LOWER_SUMMER_LIMIT
            }

            Season.WINTER -> {
                if (temperature < LOWER_WINTER_LIMIT) return temperature - LOWER_WINTER_LIMIT
                else if (temperature > HIGHER_WINTER_LIMIT) return temperature - HIGHER_WINTER_LIMIT
            }
        }
        return 0F
    }

    fun isComfortable(): Boolean {
        when (season) {
            Season.SUMMER -> return temperature in LOWER_SUMMER_LIMIT..HIGHER_SUMMER_LIMIT
            Season.WINTER -> return temperature in LOWER_WINTER_LIMIT..HIGHER_WINTER_LIMIT
        }
    }


    companion object {
        val LOWER_SUMMER_LIMIT = 22F
        val HIGHER_SUMMER_LIMIT = 25F
        val LOWER_WINTER_LIMIT = 20F
        val HIGHER_WINTER_LIMIT = 22F

        fun convert(temperature: Float, temperatureMode: TemperatureMode): Float {
            when (temperatureMode) {
                TemperatureMode.FAHRENHEIT -> return temperature * (9 / 5) + 32
                TemperatureMode.KELVIN -> return temperature + 273
                TemperatureMode.CELSIUS -> return temperature
            }
        }
    }
}