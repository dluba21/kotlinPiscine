package src.excercise01

import kotlin.reflect.full.starProjectedType

class RevolverDrum<T>() {

    val drum: CircularList<T> = CircularList(DRUM_SIZE)
    var pointerIndex = drum.head
        get() = drum.head

    constructor(o: RevolverDrum<T>) : this() {
        var current = o.drum.head
        for (i in 0 until DRUM_SIZE) {
            this.add(current?.value)
            current = current?.next
        }
    }

    fun size(): Int {
        var current = drum.head
        var counter = 0
        for (i in 0 until DRUM_SIZE) {
            current?.value?.let { counter++ }
            current = current?.next
        }
        return counter
    }

    fun add(newElem: T?): Boolean {
        var current = drum.head
        for (i in 0 until DRUM_SIZE) {
            if (current?.value == null) {
                current?.value = newElem
                return true
            }
            current = current?.next
        }
        return false
    }

    fun addAll(elems: MutableCollection<T?>): Boolean {
        while (elems.isNotEmpty() && size() != DRUM_SIZE) {
            elems.elementAt(0)?.let { add(elems.elementAt(0)) }
            elems.remove(elems.elementAt(0))
        }
        return elems.isNotEmpty()
    }

    fun shoot(): Boolean {
        val result = pointerIndex?.value == null
        pointerIndex?.value = null
        drum.changeHeadByOne()
        return result
    }

    fun unload(): MutableCollection<T?> {
        val result = mutableListOf<T?>()
        var current = drum?.head
        repeat(DRUM_SIZE) {
            current?.value?.let {
                result.add(current?.value)
                current?.value = null
            }
            current = current?.next
        }
        return result
    }

    fun scroll() {
        var scrollTimes = (0..6).shuffled().first()
        repeat(scrollTimes) {
            drum.changeHeadByOne()
        }
    }

    override fun toString(): String {
        val arrayToPrint = run {
            var array = arrayListOf<T?>()
            var current = drum.head
            for (i in 0 until DRUM_SIZE) {
                array.add(current?.value)
                current = current?.next
            }
            array
        }

        return """
            Structure: ${RevolverDrum::class.starProjectedType}
            Objects: $arrayToPrint
            pointerIndex: ${pointerIndex?.value}
        """.trimIndent()
    }


    companion object {
        const val DRUM_SIZE = 6
    }
}