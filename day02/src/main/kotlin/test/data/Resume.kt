package test.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Resume(
    @JsonProperty("candidate_info") val candidateInfo: CandidateInfo,
    @JsonProperty("education") val educationList: List<Education>,
    @JsonProperty("job_experience") val jobExperienceList: List<JobExperience>,
    @JsonProperty("free_form") val freeForm: String

)
