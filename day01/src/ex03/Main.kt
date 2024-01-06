package ex03

import ex03.model.ResponseHandler
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    println("Type a response code:")
    val responseCode = readln()
    responseCode.toIntOrNull() ?: IllegalArgumentException("Error: input code must be integer")

    ResponseHandler.handleResponse(responseCode)
}

