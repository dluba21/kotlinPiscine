package exercise2.data

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * todo crutches
 * 1) CustomLocalDateSerializer overrides undefined native of LocalDate (LocalDateIso8601Serializer)
 * 2) serialize doesn't work because it depends on class where it is serialized
 * 3) Override of toString() method is bad practice
 * 4) All problems because of LocalDate in data classes: kotlinx isn't flexible on format patterns, so i wrote myself
 *    so I have to change LocalDate to String and convert it in business logic layer
 * BUT! Excercise is done!
 */
@Serializer(forClass = LocalDate::class)
class CustomLocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("date", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDate {
        val dateString = decoder.decodeString()
        return when {
            dateString.matches(CustomDateFormat.YEAR.regex) ->  LocalDate.parseCustomFormat(dateString, CustomDateFormat.YEAR)
            dateString.matches(CustomDateFormat.MONTH_YEAR.regex) ->  LocalDate.parseCustomFormat(dateString, CustomDateFormat.MONTH_YEAR)
            dateString.matches(CustomDateFormat.BIRTHDAY.regex) ->  LocalDate.parseCustomFormat(dateString, CustomDateFormat.BIRTHDAY)
            else -> throw SerializationException(DATE_FORMAT_ERROR)
        }
    }

    override fun serialize(encoder: Encoder, localDate: LocalDate) {
        encoder.encodeString(localDate.toString())
    }
}