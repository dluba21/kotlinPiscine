package src.excercise02


class CircularList<T> {
    var head: Node? = null
    var size = 0
        private set

    constructor(o: CircularList<out T>) {
        this.size = o.size
        var current = o.head
        repeat(size) {
            this.add(current?.value)
            current = current?.next
        }
    }

    constructor(size: Int) {
        repeat(size) {
            this.add(null)
        }
    }

    inner class Node(var value: T?, var next: Node? = null)

    fun add(value: T?) {
        val newNode = Node(value)

        head?.let { getLast()?.next = newNode } ?: run { head = newNode }
        newNode.next = head
        size++
    }

    private fun getLast(): Node? {
        var current = head
        while (current?.next != head)
            current = current?.next
        return current
    }

    fun changeHeadByOne(): Node? {
        head = head?.next
        return head
    }
}