package src.excercise02

class Revolver<T : AbstractBullet>() {

    val drum: CircularList<T> = CircularList(DRUM_SIZE)
    var pointerIndex = drum.head
        get() = drum.head

    constructor(o: Revolver<T>) : this() {
        var current = o.drum.head

        repeat(DRUM_SIZE) {
            this.add(current?.value)
            current = current?.next
        }
    }

    fun size(): Int {
        var current = drum.head
        var counter = 0

        repeat(DRUM_SIZE) {
            current?.value?.let { counter++ }
            current = current?.next
        }
        return counter
    }

    fun sameTypeCheck(newElem: T?): Boolean {
        var current = drum.head
        var drumClass = drum.head?.value?.javaClass


        repeat(DRUM_SIZE) {
            if (drum.head?.value?.javaClass != drumClass) {
                println("Error: while adding appeared drum type error")
                return false
            }
            current = current?.next
        }

        if (drumClass != null && newElem != null && newElem.javaClass != drumClass) return false
        return true
    }

    fun add(newElem: T?): Boolean {
        var current = drum.head

        if (newElem == null || newElem.isLoaded) return false
        repeat(DRUM_SIZE) {
            if (current?.value == null) {
                current?.value = newElem
                newElem.isLoaded = true
                return true
            }
            current = current?.next
        }
        return false
    }

    fun addAll(elems: MutableCollection<T?>): Boolean {
        while (elems.isNotEmpty() && size() != DRUM_SIZE) {
            elems.elementAt(0)?.let {
                val elemToLoad = elems.elementAt(0)

                if (elemToLoad == null) println("Error: can't add null bullet")
                else if (!add(elemToLoad)) println("Error: can't add bullet: $elemToLoad is already in another drum")
            }
            elems.remove(elems.elementAt(0))
        }
        return elems.isNotEmpty()
    }

    fun shoot(): Boolean {
        val bullet = pointerIndex?.value
        pointerIndex?.value = null
        drum.changeHeadByOne()

        return if (bullet != null && bullet.isShotPossible) {
            bullet.shoot()
            bullet.isShot = true
            true
        } else {
            println("Click!" + bullet?.let {
                when {
                    it.isDamp -> " A damp one"
                    it.isShot -> " A shot one"
                    else -> ""
                }
            })
            false
        }
    }

    fun unload(): T? {
        val result = drum.head?.value
        result?.isLoaded = false
        drum.head?.value = null
        return result
    }

    fun unloadAll(): Collection<T?> {
        val result = mutableListOf<T?>()
        var current = drum?.head
        repeat(DRUM_SIZE) {
            current?.value?.let {
                result.add(current?.value)
                current?.value = null
                current?.value?.isLoaded = false
            }
            current = current?.next
        }
        return result.toList()
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

            repeat(DRUM_SIZE) {
                array.add(current?.value)
                current = current?.next
            }
            array
        }
        return """
            Structure: $[TODO}
            Objects: $arrayToPrint
            pointerIndex: ${pointerIndex?.value}
        """.trimIndent()
    }

    inline fun <reified T> foo(): String? {
        return this::class.simpleName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Revolver<*>) return false
        var currentThis = drum.head
        var currentOther = other.drum.head
        repeat(DRUM_SIZE) {
            if (currentThis?.value != currentOther?.value) return false
            currentThis = currentThis?.next
            currentOther = currentOther?.next
        }
        return true
    }


    companion object {
        const val DRUM_SIZE = 6
    }
}