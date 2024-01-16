package exercise2

import exercise2.data.Education
import exercise2.data.JobExperience
import kotlinx.serialization.json.Json

val filePath: String = "data-samples/resume.json"

fun main() {
//    val file = File(filePath)
//    if (!file.exists() || !file.canRead()) throw IllegalArgumentException("Error: incorrect file or path")
//    val fileLines = file.readLines().fold(""){acc, line -> acc + line}

    val rawJson1 = """
       {
          "date_start": "08.2021",
          "date_end": "04.2022",
          "company_name": "FinTech",
          "description": "Some fintech company creating a business platform"
       }
    """.trimIndent()

    val rawJson2 = """     
        {
            "type": "secondary special",
            "year_start": "2013",
            "year_end": "2017",
            "description": "College of informatics"
        }
        """.trimIndent()

    val jobExperience = Json.decodeFromString<JobExperience>(rawJson1)
    val education = Json.decodeFromString<Education>(rawJson2)

    println(jobExperience)

    println(education)


//    val resume = Json.decodeFromString<Resume>(fileLines)
//    println(resume)

//    LocalDate.parse

}