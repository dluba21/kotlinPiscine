package exercise3.utils

import exercise3.data.CandidateLevel
import exercise3.data.Resume
import java.time.LocalDate

object ResumeUtils {
    fun countYearWorkExperience(resume: Resume): Int {
        if (resume.jobExperienceList.isNullOrEmpty()) throw IllegalArgumentException("Error: no vacancies found")
        return resume.jobExperienceList.fold(0) { acc, jobExperience ->
            acc + (getMonthDiff(
                CustomDateUtils.parseFormat(jobExperience.dateStart, CustomDateFormat.MONTH_YEAR),
                CustomDateUtils.parseFormat(jobExperience.dateEnd, CustomDateFormat.MONTH_YEAR)
            ))
        }
    }

    fun getMonthDiff(start: LocalDate, end: LocalDate): Int {
        return (end.year - start.year) * 12 + (end.month.value - start.month.value)
    }

    fun getCandidateLevel(month: Int): CandidateLevel {
        return when {
            month >= CandidateLevel.SENIOR.seniority -> CandidateLevel.SENIOR
            month >= CandidateLevel.MIDDLE.seniority -> CandidateLevel.MIDDLE
            else -> CandidateLevel.JUNIOR
        }
    }
}