package exercise2

import exercise2.data.Resume
import kotlinx.serialization.json.Json
import java.io.File

val filePath: String = "data-samples/resume.json"

fun main() {
    val file = File(filePath)
    if (!file.exists() || !file.canRead()) throw IllegalArgumentException("Error: incorrect file or path")
    val fileLines = file.readLines().fold(""){acc, line -> acc + line}
    val resume = Json.decodeFromString<Resume>(fileLines)
    println(resume)
}