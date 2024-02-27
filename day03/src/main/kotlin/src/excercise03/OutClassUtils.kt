package src.excercise03

import src.excercise02.AbstractBullet

fun <T : AbstractBullet> Drum<T>.rearrange() {
    val gaps = run {
        var gapCounter = 0
        var maxGapCounter = 0
        var current = drum.head

        for (i in 0 until Drum.DRUM_SIZE) {
            current?.value?.let {
                maxGapCounter = gapCounter
                gapCounter = 0
            } ?: gapCounter++

            current = current?.next
        }
        maxGapCounter
    }

    if (gaps > 1) addAll(unloadAll().toMutableList())
}

fun <T : AbstractBullet> Drum<T>.randomShoot() {
    scroll()
    shoot()
}

fun <T : AbstractBullet> Drum<T>.extractBullet() : Drum<T>? {
    return this.let {
        Drum<T>().apply {
            this.add(it.unload())
        }
    }
}
