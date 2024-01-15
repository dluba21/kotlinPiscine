package exercise1

import exercise1.data.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import java.io.File

//todo возвращать null еслиь значение плохое, пустой список если All и список из одного элемента если все гладко
//todo сделать параметризованный метод внутри интерфейса который печатает енам и!! который вне статического блока (применим к объекту) - не надо но просто для тренировки

val wrongInput = "It doesn't look like a correct input."
val pathFIle = "data-samples/listOfCompanies.json"

fun main() {

    val file = File(pathFIle) //validate file


    val rawJson = file.readLines().fold("") { acc, next -> acc + next }

    val rawJson1 = """
        {
  "listOfCompanies": [
    {
      "name": "OOO SuperPay",
      "field_of_activity": "banking",
      "vacancies": [
        {
          "profession": "qa",
          "level": "middle",
          "salary": 80000
        },
        {
          "profession": "pm",
          "level": "senior",
          "salary": 130000
        }
      ],
      "contacts": "79815354235"
    }
    ]
    }
    """.trimIndent()


    val trimmedRawJsonList = Json.parseToJsonElement(rawJson).jsonObject["listOfCompanies"]?.jsonArray.toString() //catch exception
    val companies = Json.decodeFromString<List<Company>>(trimmedRawJsonList) //catch exception

//    val available


    //копим фильтры - список енамов
    //потом за раз фильтруем все компании в новый список suitableVacancies

    var activityFieldFilter: List<ActivityField>
    var professionFilter: List<Profession>
    var candidateLevelFilter: List<CandidateLevel>
    var salaryFilter: List<SalaryFork>

    println("${ActivityField.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<ActivityField>(readln().toIntOrNull())
            .let { activityFieldFilter = it; it.isEmpty() } //todo мб null вернуть потом а не пустой список и пустой список если All
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

    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${CustomFilterEnum.printFilter(professionFilter)}. " +
            "${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${SalaryFork.optionToDisplay}")
    while (CustomFilterEnum.fromOrder<SalaryFork>(readln().toIntOrNull())
            .let { salaryFilter = it; it.isEmpty() }
    ) {
        println("$wrongInput ${SalaryFork.optionToDisplay}")
    }


    val suitableVacancies = companies.map {
            it.vacancies.filter {
                it.level in candidateLevelFilter && it.profession in professionFilter
                        && SalaryFork.values().find { it. }


            }
    }.map { }


    println("${CustomFilterEnum.printFilter(activityFieldFilter)}. " +
            "${CustomFilterEnum.printFilter(professionFilter)}. " +
            "${CustomFilterEnum.printFilter(candidateLevelFilter)}. " +
            "${CustomFilterEnum.printFilter(salaryFilter)}.\n" +
            "The list of suitable vacancies:")


}