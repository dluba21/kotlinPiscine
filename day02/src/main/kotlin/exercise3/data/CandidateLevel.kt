package exercise3.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = CustomEnumSerializer::class)
enum class CandidateLevel(override val displayableName: String, override val jsonName: String, val seniority: Int, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    JUNIOR("Junior", "junior", 0, 1),
    MIDDLE("Middle", "middle", 3,2),
    SENIOR("Senior", "senior", 6, 3);
}