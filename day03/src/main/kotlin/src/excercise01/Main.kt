package src.excercise01

import excercise01.RevolverDrum

fun main() {
    var revolverDrum = RevolverDrum<Int>()

    println("1. Adding elements")
    revolverDrum.addAll(arrayListOf(3, 54, 7, 2, 56, 4))
    println(revolverDrum.toString() + "\n")


    println("2. Scroll")
    revolverDrum.scroll()
    println(revolverDrum.toString() + "\n")


    println("3. Deletion")
    revolverDrum.shoot()
    revolverDrum.shoot()
    revolverDrum.shoot()
    revolverDrum.shoot()
    println(revolverDrum.toString() + "\n")


    val suppliedCollection = arrayListOf<Int?>(4, 6, 3, 22, 77, 43, 76, 5)
    println(
        """
        |4. Supply collection
        |Before:
        |Supply collection: $suppliedCollection
    """.trimMargin()
    )
    revolverDrum.addAll(suppliedCollection)
    println(revolverDrum.toString() + "\n")
    println(
        """
        |After add operation performed:
        |Supply collection: $suppliedCollection
        
    """.trimMargin()
    )


    val extractedList = revolverDrum.unload()
    println(
        """
         |5. Extraction
         |The extracted list: $extractedList
         |size: ${extractedList.size}
    """.trimMargin()
    )
    println(
        """
        |$revolverDrum
        |size = ${revolverDrum.getNotEmptyCellsSize()}
        
    """.trimMargin()
    )


    println(
        """
    |6. Supply collection 2
    |Before:
    |Supply collection: $extractedList
    
    |$revolverDrum
     
    """.trimMargin()
    )
    revolverDrum.addAll(extractedList)

    println(
        """
        |After add operation performed:
        |Supply collection: $suppliedCollection
        
        |$revolverDrum
        
    """.trimMargin()
    )


    val anotherRevolverDrum = RevolverDrum(revolverDrum)
    anotherRevolverDrum.scroll()

    println(
        """
        |7. Equals
        |$revolverDrum

        |$anotherRevolverDrum

        |Result: ${run { if (revolverDrum == anotherRevolverDrum) "" else "not " }}equals
    """.trimMargin()
    )
}

//todo выяснить потом почему при вызове функции несколько раз вызывается лишь один
fun <T : Any> printRevolver(revolver: RevolverDrum<T>): String {
    return revolver.toString() + "\n"
}