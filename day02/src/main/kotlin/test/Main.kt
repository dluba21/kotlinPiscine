package test

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import test.data.Resume
import java.io.File


const val filePathResume: String = "data-samples/resume.json"

fun main() {
    val mapper: ObjectMapper = jacksonObjectMapper()
    mapper.registerModule(JavaTimeModule())

    val file = File(filePathResume)
    if (!file.exists() || !file.canRead()) throw IllegalArgumentException("Error: incorrect file or path")
    val resumeLines = file.readLines().fold("") { acc, line -> acc + line }

    val resume: Resume = mapper.readValue(resumeLines)



    println(resume)
}
