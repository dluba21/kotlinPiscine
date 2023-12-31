package ex00

import kotlin.math.absoluteValue
import kotlin.math.pow

class Circle(x: Float, y: Float, r: Float) {
    val x: Float
    val y: Float
    val r: Float

    init {
        this.x = x
        this.y = y
        this.r = r
    }

    fun getKindOfIntersection(anotherCircle: Circle) {
        val distCentres = ((this.x - anotherCircle.x).pow(2) + (this.y - anotherCircle.y).pow(2)).pow(0.5F)
        val diff = distCentres - (this.r + anotherCircle.r).absoluteValue;
        val deltaR = this.r - anotherCircle.r;

        if (diff > 0) {
            println("Result: the circles don't intersect")
        }
        else if (diff == 0F) {
            println("Result: the circles touch each other from outside")
        }
        else if (distCentres.absoluteValue == deltaR.absoluteValue) {
            println("Result: the circles touch each other from inside")
        }
        else {
            println("Result: the circles intersect")
        }

    }
}