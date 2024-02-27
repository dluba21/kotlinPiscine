package src.excercise02



fun main() {
    var revolver = Revolver<FourtyFive>()
    var revolver2 = Revolver<FourtyFive>()


    println("1. Check that normal bullets shoot and damp not.")

    revolver.add(FourtyFive(!AbstractBullet.SHOT, !AbstractBullet.DAMP, !AbstractBullet.LOADED))
    revolver.add(FourtyFive(!AbstractBullet.SHOT, !AbstractBullet.DAMP, AbstractBullet.LOADED))
    revolver.add(FourtyFive(!AbstractBullet.SHOT, AbstractBullet.DAMP, !AbstractBullet.LOADED))
    revolver.add(FourtyFive(AbstractBullet.SHOT, AbstractBullet.DAMP, !AbstractBullet.LOADED))

    println(revolver)
    revolver.shoot()
    revolver.shoot()
    revolver.shoot()
    revolver.shoot()
    revolver.shoot()
    println(revolver.toString() + "\n")

    println("2. Try to add one bullet to different drums. The first addition should return true, the second - false")

    revolver.unload()
    val bullet = FourtyFive()

    println(revolver.add(bullet))
    println(revolver2.add(bullet))
    println(revolver)
    println(revolver2.toString() + "\n")

    println("3. Try to add one bullet to different collections, and then add it to different drums")
    val bullet2 = FourtyFive()
    val bullet3 = FourtyFive()
    val bullet4 = FourtyFive()
    val collection1 = arrayListOf<FourtyFive?>(bullet2, bullet3)
    val collection2 = mutableListOf<FourtyFive?>(bullet2, bullet4, bullet3)

    revolver.addAll(collection1)
    revolver.addAll(collection2)
    println(revolver.toString() + "\n")

    println("4. Try to shoot with a damp and shot bullets. The output should be \"A damp one\" and \"A shot one\"")
    revolver.unloadAll()
    revolver.add(FourtyFive(AbstractBullet.SHOT, !AbstractBullet.DAMP, !AbstractBullet.LOADED))
    revolver.add(FourtyFive(!AbstractBullet.SHOT, AbstractBullet.DAMP, !AbstractBullet.LOADED))
    println(revolver)

    revolver.shoot()
    revolver.shoot()
}


