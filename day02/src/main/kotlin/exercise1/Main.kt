package exercise1

import exercise1.data.*
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import java.io.File

val wrongInput = "It doesn't look like a correct input."
val pathFIle = "data-samples/listOfCompanies.json"

fun main() {

    var companies: List<Company>

    val file = File(pathFIle)
    if (!file.exists() || !file.canRead()) throw IllegalArgumentException("Error: problem with file or path")
    val rawJson = file.readLines().fold("") { acc, next -> acc + next }

    try {
        val trimmedRawJsonList = Json.parseToJsonElement(rawJson).jsonObject["listOfCompanies"]?.jsonArray.toString()
        companies = Json.decodeFromString(trimmedRawJsonList)
    }
    catch (e: SerializationException) {
        throw RuntimeException("Error: invalid json format\n" + e.message)
    }

    var activityFieldFilter: List<ActivityField>
    var professionFilter: List<Profession>
    var candidateLevelFilter: List<CandidateLevel>
    var salaryFilter: List<SalaryFork>

    println("${ActivityField.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<ActivityField>(readln().toIntOrNull())
            .let { activityFieldFilter = it; it.isEmpty() }
    ) {
        println("$wrongInput ${ActivityField.optionToDisplay}")
    }

    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${Profession.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<Profession>(readln().toIntOrNull())
            .let { professionFilter = it; it.isEmpty() }
    ) {
        println("$wrongInput ${Profession.optionToDisplay}")
    }

    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${CustomFilterEnum.printFilter(professionFilter)}. " +
            "${CandidateLevel.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<CandidateLevel>(readln().toIntOrNull())
            .let { candidateLevelFilter = it; it.isEmpty() }
    ) {
        println("$wrongInput ${CandidateLevel.optionToDisplay}")
    }
    println(candidateLevelFilter)

    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${CustomFilterEnum.printFilter(professionFilter)}. " +
            "${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${SalaryFork.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<SalaryFork>(readln().toIntOrNull())
            .let { salaryFilter = it; it.isEmpty() }
    ) {
        println("$wrongInput ${SalaryFork.optionToDisplay}")
    }


    val suitableVacancies = companies.flatMap { company ->
        company.vacancies.filter { vacancy ->
                    vacancy.level in candidateLevelFilter
                    && vacancy.profession in professionFilter
                    && company.fieldOfActivity in activityFieldFilter
                    && salaryFilter.firstOrNull { vacancy.salary in it.lowerBound..it.higherBound } != null
        }.map { vacancy -> Triple(company.name, company.fieldOfActivity.displayableName, vacancy) }
    }


    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${CustomFilterEnum.printFilter(professionFilter)}. " +
            "${CustomFilterEnum.printFilter(candidateLevelFilter)}. " +
            "${CustomFilterEnum.printFilter(salaryFilter)}.\n" +
            "The list of suitable vacancies:")
    printVacancies(suitableVacancies)


}

fun printVacancies(suitableVacancies: List<Triple<String, String, Vacancy>>) {
    suitableVacancies.forEachIndexed {counter, item ->
        println("""
            ${counter + 1}.
            ${item.third.level} ${item.third.profession}     ---      ${item.third.salary}
              ${item.first}
              ${item.second}
            ---------------------------------------
        """.trimIndent())
    }
}