package exercise2.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Resume(
    @SerialName("candidate_info") val candidateInfo: CandidateInfo,
    @SerialName("education") val educationList: List<Education>,
    @SerialName("job_experience") val jobExperienceList: List<JobExperience>,
    @SerialName("free_form") val freeForm: String
)
