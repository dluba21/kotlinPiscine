package exercise1.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


@Serializer(forClass = CustomSerializableEnum::class)
object CustomEnumSerializer : KSerializer<CustomSerializableEnum> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CustomSerializableEnum", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: CustomSerializableEnum) {
        encoder.encodeString(value.jsonName)
    }

    override fun deserialize(decoder: Decoder): CustomSerializableEnum {
        val enumString = decoder.decodeString()



            return sequenceOf(CustomSerializableEnum.fromLowerCase<ActivityField>(enumString),
                CustomSerializableEnum.fromLowerCase<Profession>(enumString),
                CustomSerializableEnum.fromLowerCase<CandidateLevel>(enumString)).firstOrNull{it != null}
                ?: throw IllegalArgumentException("Error: custom json serializer can't define enum of value = {$enumString}")
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
        inline fun <reified T> fromLowerCase(value: String): T?
        where T : Enum<T>, T : CustomSerializableEnum {
            return enumValues<T>().firstOrNull {
                it.jsonName.equals(value, ignoreCase = true)
            }
        }
    }
}