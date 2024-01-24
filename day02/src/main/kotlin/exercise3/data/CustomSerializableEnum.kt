package exercise3.data

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode


object CustomEnumSerializer : JsonDeserializer<CustomSerializableEnum>() {
    private val error = "Error: custom json serializer can't define enum by value"

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): CustomSerializableEnum {
        if (p != null && ctxt != null) {
            val node = p.codec.readTree<JsonNode>(p)
            val profession = CustomSerializableEnum.fromLowerCase<Profession>(node.asText())
            val level = CustomSerializableEnum.fromLowerCase<CandidateLevel>(node.asText())
            val field = CustomSerializableEnum.fromLowerCase<ActivityField>(node.asText())
            return profession ?: field ?: level ?: throw JsonParseException(error)
        }
        throw JsonParseException(error)
    }
}

interface CustomSerializableEnum {
    val jsonName: String

    /**
     * было вот так, но тогда я не мог достучаться до jsonName
     *  inline fun <reified T : Enum<T>> fromLowerCase(value: String): T?
     * выглядело лучше, но не работало почему-то
     *  inline fun <reified T : Enum<T> & CustomSerializableEnum> fromLowerCase(value: String): T?
     * вот так сработало, но это очень страшно выглядит
     * inline fun <reified T> fromLowerCase(value: String): T? where T : Enum<T>, T : CustomSerializableEnum
     */

    companion object {
        inline fun <reified T> fromLowerCase(value: String?): T? where T : Enum<T>, T : CustomSerializableEnum {
            return enumValues<T>().firstOrNull {
                it.jsonName.equals(value, ignoreCase = true)
            }
        }
    }
}