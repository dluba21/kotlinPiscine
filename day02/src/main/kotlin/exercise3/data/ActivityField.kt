package exercise3.data

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = CustomEnumSerializer::class)
 enum class ActivityField(override val displayableName: String, override val jsonName: String, override val order: Int) :
    CustomSerializableEnum, CustomFilterEnum {
    IT("IT", "IT", 1),
    BANKING("Banking", "banking", 2),
    PUBLIC_SERVICES("Public services", "public services", 3);
}