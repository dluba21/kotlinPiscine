package src.excercise04

fun main() {
    val player = Player()

    while (player.inventory.rifleBullets.isNotEmpty()) {
        player.inventory.rifle.shootAll()
        player.inventory.reload(RifleBullet::class)
    }
    player.inventory.rifle.shootAll()

    while (player.inventory.threeEighties.isNotEmpty()) {
        player.inventory.revolver.shootAll()
        player.inventory.reload(ThreeEighty::class)
    }
    player.inventory.revolver.shootAll()

    while (player.inventory.fourtyFives.isNotEmpty()) {
        player.inventory.revolver.shootAll()
        player.inventory.reload(FourtyFive::class)
    }
    player.inventory.revolver.shootAll()

    while (player.inventory.twentyTwos.isNotEmpty()) {
        player.inventory.revolver.shootAll()
        player.inventory.reload(TwentyTwo::class)
    }
    player.inventory.revolver.shootAll()

    player.inventory.revolver.shoot()
    player.inventory.revolver.shoot()
    player.inventory.revolver.shoot()
    player.inventory.revolver.shoot()
}

