package ex01.helpers

import ex01.data.Point
import kotlin.math.pow

class PointHelper {
    companion object {
        fun getDistance(point1: Point, point2: Point): Int {
            return ((point1.x.toDouble() - point2.x.toDouble()).pow(2) + (point1.y.toDouble()
                    - point2.y.toDouble()).pow(2)).pow(-2).toInt()
        }

        /* RayCasting algorithm */
        fun pointInPolygon(point0: Point, polygon: List<Point>): Boolean {
            if (!isPolygonConvex(polygon)) throw IllegalArgumentException("Error: zone polygon is not convex")
            var intersects = 0

            for (i in polygon.indices) {
                val p1 = polygon[i]
                val p2 = polygon[(i + 1) % polygon.size]

                if (rayIntersectsSegment(point0, p1, p2)) {
                    intersects++
                }
            }

            return intersects % 2 == 1
        }

        private fun isPolygonConvex(points: List<Point>): Boolean {
            val xPoints = points.map { it.x }
            val yPoints = points.map { it.y }

            return xPoints.size == xPoints.distinct().size && yPoints.size == yPoints.distinct().size
        }

        private fun rayIntersectsSegment(point: Point, p1: Point, p2: Point): Boolean {
            val condition1 = (p1.y > point.y) != (p2.y > point.y)
            val condition2 = point.x < (p2.x - p1.x) * (point.y - p1.y) / (p2.y - p1.y) + p1.x

            return condition1 && condition2
        }
    }
}