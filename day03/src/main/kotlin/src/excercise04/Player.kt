package src.excercise04

import kotlin.reflect.KClass

class Player {

    val inventory = Inventory<Bullet>()

    init {
        inventory.twentyTwos = getFullAmmo(TwentyTwo::class, 10)
        inventory.threeEighties = getFullAmmo(ThreeEighty::class, 7)
        inventory.fourtyFives = getFullAmmo(FourtyFive::class, 44)
        inventory.rifleBullets = getFullAmmo(RifleBullet::class, 12)
    }

    class Inventory<T : Bullet> {
        var twentyTwos: List<TwentyTwo> = listOf()
        var threeEighties: List<ThreeEighty> = listOf()
        var fourtyFives: List<FourtyFive> = listOf()
        var rifleBullets: List<RifleBullet> = listOf()
        val revolver: Drum<T> = Drum()
        val rifle: Drum<T> = Drum()

        fun reload(caliber: KClass<out Bullet>) {
            val ammo = when (caliber) {
                TwentyTwo::class -> twentyTwos as MutableCollection<T?>
                ThreeEighty::class -> threeEighties as MutableCollection<T?>
                FourtyFive::class -> fourtyFives as MutableCollection<T?>
                RifleBullet::class -> rifleBullets as MutableCollection<T?>
                else -> throw IllegalArgumentException()
            }
            val isPistol = when (caliber) {
                TwentyTwo::class, ThreeEighty::class, FourtyFive::class -> true
                RifleBullet::class -> false
                else -> throw IllegalArgumentException("Error: incorrect type of weapon")
            }

            if (isPistol) {
                revolver.deleteDefectBullets()
                revolver.addAll(ammo)
            }
            else {
                rifle.deleteDefectBullets()
                rifle.addAll(ammo)
            }
        }
    }
}