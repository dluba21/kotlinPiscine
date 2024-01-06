package ex01.data

import ex01.helpers.PointHelper

class TriangleZone() : Zone() {
    override val REGEX_PATTERN: String = "-?\\d+;-?\\d+ -?\\d+;-?\\d+ -?\\d+;-?\\d+"
    val NAME = "triangle"

    var point1 = Point(0, 0)
    var point2 = Point(0, 0)
    var point3 = Point(0, 0)

    override fun fill(input: String) {
        val splittedInput = input.split(" ")

        point1 = Point(splittedInput[0])
        point2 = Point(splittedInput[1])
        point3 = Point(splittedInput[2])
    }

    override fun isZoneApplicable(input: String): Boolean {
        return input.matches(Regex(REGEX_PATTERN))
    }

    override fun isInsideZone(point: Point): Boolean {
        return PointHelper.pointInPolygon(point, listOf(point1, point2, point3))
    }

    override fun getName(): String {
        return ZoneNames.TRIANGLE.displayableName
    }
}