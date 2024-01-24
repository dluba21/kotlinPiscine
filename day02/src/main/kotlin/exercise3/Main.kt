package exercise3

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import exercise3.data.Company
import exercise3.data.Resume
import exercise3.data.Vacancy
import exercise3.utils.ResumeUtils
import java.io.File

const val filePathResume: String = "data-samples/resume.json"
const val filePathCompanies = "data-samples/listOfCompanies.json"

fun main() {
    val mapper: ObjectMapper = jacksonObjectMapper()

    val fileCompanies = File(filePathCompanies) //validate file
    if (!fileCompanies.exists() || !fileCompanies.canRead()) throw IllegalArgumentException("Error: problem with file or path")
    val companiesLines = fileCompanies.readLines().fold("") { acc, next -> acc + next }
    val companiesJsonTree = mapper.readTree(companiesLines)
    val preparedCompaniesLines = companiesJsonTree.get("listOfCompanies").toString()

    val file = File(filePathResume)
    if (!file.exists() || !file.canRead()) throw IllegalArgumentException("Error: incorrect file or path")
    val resumeLines = file.readLines().fold(""){acc, line -> acc + line}

    val resume: Resume = mapper.readValue(resumeLines)
    val companies: List<Company> = mapper.readValue(preparedCompaniesLines)

    val employeeYearExperience = ResumeUtils.countYearWorkExperience(resume)


    val suitableVacancies = companies.flatMap { company ->
                                company.vacancies.filter {
                                    it.profession == resume.candidateInfo.profession && employeeYearExperience.floorDiv(12) >= it.level.seniority
                                }
                                    .map { vacancy -> Pair(company, vacancy) }
                                    .toList()
                            }
    println(resume.candidateInfo.profession)
    println(employeeYearExperience)
    println(suitableVacancies)
    println(formatPrintResult(resume, suitableVacancies))
}

fun formatPrintResult(resume: Resume, vacancies: List<Pair<Company, Vacancy>>): String {
    return  String.format("""
        The candidate:
        Name: %s
        Profession: %s
        Experience: 1 year 5 months (%s)
        Suitable vacancies:
    """.trimIndent(),
        resume.candidateInfo.fullName,
        resume.candidateInfo.profession,
        ResumeUtils.getCandidateLevel(ResumeUtils.countYearWorkExperience(resume)).displayableName,
    ) + "\n" + (vacancies.fold(""){acc, pair -> acc + formatGetVacancyInfo(pair)})
}

fun formatGetVacancyInfo(vacancy: Pair<Company, Vacancy>): String {

    return  """
                ${vacancy.first.name}
                Field of activity: ${vacancy.first.fieldOfActivity.displayableName}
                Candidate level: ${vacancy.second.level.displayableName}
                Salary: 60000  ${vacancy.second.level.displayableName}
                Contacts: ${vacancy.first.contacts}
                
            """.trimIndent()
}