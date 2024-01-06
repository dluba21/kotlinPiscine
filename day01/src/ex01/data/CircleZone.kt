package ex01.data

import ex01.helpers.PointHelper

class CircleZone() : Zone() {
    override val REGEX_PATTERN: String = "-?\\d+;-?\\d+ -?\\d+"

    var radius = 0
    var centre = Point(0, 0)
    
    override fun fill(input: String) {
        val splittedInput = input.split(" ")
        centre = Point(splittedInput[0])
        radius = splittedInput[1].toInt()
        if (radius <= 0) throw IllegalArgumentException("Error: circle radius must be more than 0")
    }

    override fun isZoneApplicable(input: String): Boolean {
        return input.matches(Regex(REGEX_PATTERN))
    }

    override fun isInsideZone(point: Point): Boolean {
        return PointHelper.getDistance(point, centre) > radius
    }

    override fun getName(): String {
        return ZoneNames.CIRCLE.displayableName
    }
}