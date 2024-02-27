package src.excercise03

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class AbstractMapper<T1, T2> {
    fun convertGenericType(obj: T1?): T2? {
        return obj as? T2
    }

    fun convertType(first: First): Second {
        return Second(first.name)
    }

    fun convertGenericList(list1: List<T1?>): List<T2?> {
        val list2 = mutableListOf<T2?>()

        list1.forEach{
            list2.add(convertGenericType(it))
        }
        return list2
    }

    fun convertList(list1: List<First>): List<Second> {
        val list2 = mutableListOf<Second>()

        list1.forEach{
            println(it)
            var a = convertType(it)
            list2.add(a)
            println(a)
        }
        return list2
    }
}

internal inline fun <reified T: Any, U: Any> T.checkType(obj: U): Boolean {
    return T::class.isInstance(obj)
}

internal inline fun <reified T: Any, U: Any> T.checkTypeExt(clazz: KClass<U>): Boolean {
    return T::class == clazz
}

class ReplaceSpacesDelegate : ReadWriteProperty<Any?, String> {
    private var buffer = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return buffer
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        buffer = value.replace(' ', '_')
    }
}

class LogDelegate : ReadWriteProperty<Any?, String> {
    var buffer = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("A property ${property.name} was read")
        return buffer
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("A property was assigned ${property.name}")
        buffer = value
    }
}

private fun <T : Number> add(a: T, b : T): T {
    return when (a) {
        is Int -> (a.toInt() + b.toInt()) as T
        is Double -> (a.toInt() + b.toInt()) as T
        is Float -> (a.toInt() + b.toInt()) as T
        is Long -> (a.toLong() + b.toLong()) as T
        else -> throw IllegalArgumentException("Error: invalid type input during addition")
    }
}

private fun <T : Number> subtract(a: T, b : T): T {
    return when (a) {
        is Int -> (a.toInt() - b.toInt()) as T
        is Double -> (a.toInt() - b.toInt()) as T
        is Float -> (a.toInt() - b.toInt()) as T
        is Long -> (a.toLong() - b.toLong()) as T
        else -> throw IllegalArgumentException("Error: invalid type input during subtraction")
    }
}

private fun <T : Number> multiply(a: T, b : T): T {
    return when (a) {
        is Int -> (a.toInt() * b.toInt()) as T
        is Double -> (a.toInt() * b.toInt()) as T
        is Float -> (a.toInt() * b.toInt()) as T
        is Long -> (a.toLong() * b.toLong()) as T
        else -> throw IllegalArgumentException("Error: invalid type input during multiplication")
    }
}

private fun <T : Number> divide(a: T, b : T): T {
    return when (a) {
        is Int -> (a.toInt() / b.toInt()) as T
        is Double -> (a.toInt() / b.toInt()) as T
        is Float -> (a.toInt() / b.toInt()) as T
        is Long -> (a.toLong() / b.toLong()) as T
        else -> throw IllegalArgumentException("Error: invalid type input during division")
    }
}

enum class ArithmeticOperation {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION
}

fun getNumberOperation(operationKey: ArithmeticOperation): (Number, Number) -> Number {
    return when (operationKey) {
        ArithmeticOperation.ADDITION -> ::add
        ArithmeticOperation.SUBTRACTION -> ::subtract
        ArithmeticOperation.MULTIPLICATION -> ::multiply
        ArithmeticOperation.DIVISION -> ::divide
    }
}

object GlobalCounter {
    private var counter = 0

    @JvmStatic
    fun getNextInt(): Int {
        return counter++
    }
}





