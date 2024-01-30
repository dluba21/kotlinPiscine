package excercise01

import kotlin.reflect.full.starProjectedType


//todo где тут wildcard
//todo где тут вытягивать тип T
//TODO Structure в toString() хз как вычислить - стирание типов
//todo дописать hashcode


class RevolverDrum<T>() {
    var drum: ArrayList<T?> = arrayListOf(null, null, null, null, null, null)
    val size: Int = 6
    private var pointerIndex: Int = 0
        set(pointerIndex) {
            field = if (pointerIndex >= size) 0
            else pointerIndex
        }
    var pointer: T? = null
        get() {
            return drum[pointerIndex]
        }

    constructor(src: RevolverDrum<T>) : this() {
        for (i in 0 until size) {
            this.drum[i] = src.drum[i]
        }
    }


    fun getNotEmptyCellsSize(): Int {
        return drum.filterNotNull().count()
    }

    fun add(elem: T): Boolean {
        for (i in 0 until size) {
            val currentCell = pointerIndex++
            if (drum[currentCell] == null) {
                drum[currentCell] = elem
                return true
            }
        }
        return false
    }

    fun addAll(elems: MutableCollection<T?>): Boolean {
        val filledCells = getNotEmptyCellsSize()
        if (filledCells == 0 && elems.isNullOrEmpty()) return false

        for (i in 0 until size) {
            if (drum[i] == null && elems.isNotEmpty()) {
                drum[i] = elems.first()
                elems.remove(elems.first())
            }
        }
        return elems.isEmpty()
    }

    operator fun RevolverDrum<T>.get(index: Int): T? {
        if (index >= size) throw IllegalArgumentException("Error: index [$index] is out of bounds")
        return drum[index]
    }

    fun shoot(): Boolean {
        val currentpointerIndex = pointerIndex++

        return if (drum[currentpointerIndex] != null) {
            drum[currentpointerIndex] = null; true
        } else false
    }

    fun unload(): MutableCollection<T?> {
        var extractedBullets: ArrayList<T?> = arrayListOf()

        for (i in 0 until size) {
            drum.getOrNull(pointerIndex)?.let { extractedBullets.add(it); drum[pointerIndex] = null }
            pointerIndex++;
        }

        return extractedBullets
    }

    fun scroll() {
        pointerIndex = (0..size).shuffled().first()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
         if (other !is RevolverDrum<*>) return false

        return pointerIndex == other.pointerIndex
                && other.drum.toArray() contentEquals drum.toArray()
    }

//    override fun hashCode(): Int {
//        return drum.toArray() contentEquals
//    }

    override fun toString(): String {
        val tmp = run {
            val res = arrayListOf<T?>()
            var i = -1
            while (++i < size) {
                res.add(drum[pointerIndex++])
            }
            res
        }
        return """
           Structure: ${RevolverDrum::class.starProjectedType}
           Objects: $tmp
           pointer: $pointer
       """.trimIndent()
    }

    operator fun get(index: Int) = drum[index]
}


