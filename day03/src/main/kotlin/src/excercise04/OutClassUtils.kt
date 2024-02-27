package src.excercise04

import kotlin.reflect.KClass

fun <T : Bullet> Drum<T>.rearrange() {
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

fun <T : Bullet> Drum<T>.randomShoot() {
    scroll()
    shoot()
}

fun <T : Bullet> Drum<T>.extractBullet() : Drum<T>? {
    return this.let {
        Drum<T>().apply {
            this.add(it.unload())
        }
    }
}

inline fun <reified T : Bullet>getFullAmmo(caliber: KClass<T>, size: Int): List<T> {
    val ammo = mutableListOf<T>()

    repeat(size) {
        ammo.add(T::class.java.getDeclaredConstructor().newInstance())
    }

    return ammo
}
