package ex01.data

import ex01.helpers.PointHelper

class TetragonZone() : Zone() {
    override val REGEX_PATTERN: String = "-?\\d+;-?\\d+ -?\\d+;-?\\d+ -?\\d+;-?\\d+ -?\\d+;-?\\d+"

    var point1 = Point(0, 0)
    var point2 = Point(0, 0)
    var point3 = Point(0, 0)
    var point4 = Point(0, 0)

    override fun isZoneApplicable(input: String): Boolean {
        return input.matches(Regex(REGEX_PATTERN))
    }
    override fun isInsideZone(point: Point): Boolean {
        return PointHelper.pointInPolygon(point, listOf(point1, point2, point3, point4))
    }

    override fun fill(input: String) {
        val splitInput = input.split(" ")

        point1 = Point(splitInput[0])
        point2 = Point(splitInput[1])
        point3 = Point(splitInput[2])
        point4 = Point(splitInput[3])
    }

    override fun getName(): String {
        return ZoneNames.TETRAGON.displayableName
    }
}