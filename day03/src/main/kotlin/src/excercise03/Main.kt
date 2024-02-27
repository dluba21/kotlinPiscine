package src.excercise03

import src.excercise02.FourtyFive

fun main() {
    val obj1 = ""
    val obj2 = ""
    val obj3 = 1
    println("1. Call the function for String and Int, should return false. For String, String - true")
    println(""" 
        todo не сделано
        String, Int - false
        String, String - true
    """.trimMargin())

    println("""
        ${obj1::class}, ${obj3::class} - ${obj1.checkType(obj3)}
        ${obj1::class}, ${obj2::class} - ${obj1.checkType(obj2)}
    """.trimIndent())

    println("\n2. Write a realization to convert data class First(val name: String) into data class Second(val name: String). Add a list of First and convert it. Print both lists.")
    val mapper = AbstractMapper<First, Second>()
    val listFirst = listOf(First("Ivan"), First("Sasha"), First("John"))
    val listSecond =  mapper.convertGenericList(listFirst)
    println("""
        Map List<First>: $listFirst
        to List<Second>: $listSecond
    """.trimMargin())

    println("\n3. Write an Animal class. Inherit a Dog and a Cat. Create variable animal and initialize it with a Dog. Check with extension, if it is a Dog, a Cat, an Animal. Results: true, false, true")
    val animal = Dog()
    println(animal)
    println(animal.checkTypeExt(Dog::class))
    println(animal.checkTypeExt(Cat::class))
    println(animal.checkTypeExt(Animal::class))


    println("\n4. Create a class and a var property \"description\" of String. Create a String \"The delegate will replace all spaces with underscores\". Print it, assign to the description and print description. The result: \"The_delegate_will_replace_all_spaces_with_underscores\"")
    val description = "The delegate will replace all spaces with underscores"
    val testDelegateUnderscore = TestDelegateReplace()
    testDelegateUnderscore.description = description
    println("""
        Before: $description
        After: ${testDelegateUnderscore.description}
    """.trimIndent())

    
    println("\n5. Create a var String property, add a logging delegate to it. Assign \"Hello\" to the property. Assign the property to a new property. The logger should print both get and set events.")
    var testLog1 by LogDelegate()
    var testLog2 by LogDelegate()

    testLog1 = "Hello"
    testLog2 = testLog1

    
    println("\n6. Pass SUBTRACTION for subtraction and pass (10, 5), and print the result")
    val operation = getNumberOperation(ArithmeticOperation.SUBTRACTION)
    println("The result of subtraction is ${operation(10, 5)}")

    
    println("\n7. Create a drum and fill it with numbers, add two nulls in the middle, print the drum. Call the function and print the result")
    val drum7 = Drum<FourtyFive>()
    drum7.addAll(mutableListOf(FourtyFive(), FourtyFive(), null, null, FourtyFive(), FourtyFive()));
    println("""
        |Before:
        $drum7
    """.trimMargin())
    drum7.rearrange()
    println("""
        
        |After:
        $drum7
    """.trimMargin())

    
    println("\n8. Print the initial, the scrolled drums and the drum after shoot")
    val drum8 = Drum<FourtyFive>()
    drum8.addAll(mutableListOf(FourtyFive(), FourtyFive(),  FourtyFive(),  FourtyFive(), FourtyFive(), null))
    println("""
        |Before:
        $drum8
    """.trimMargin())
    drum8.randomShoot()
    println("""
        |
        |After:
        $drum8
    """.trimMargin())

    
    println("\n9. Print the initial and the result drums")
    val drum9 = Drum<FourtyFive>()
    drum9.addAll(mutableListOf(FourtyFive(), FourtyFive(),  FourtyFive(),  FourtyFive(), FourtyFive(), null))
    println("""
        |Before:
        $drum9
    """.trimMargin())
    val drum4 = drum9.extractBullet()
    println("""
        
        |After:
        $drum9
    """.trimMargin())
    println("""
        
        |New drum:
        $drum4
    """.trimMargin())
}

data class First(val name: String)
data class Second(val name: String)

private open class Animal
private class Dog : Animal()
private class Cat : Animal()

private class TestDelegateReplace() {
    var description by ReplaceSpacesDelegate()
}

