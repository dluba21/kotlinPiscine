package exercise2.data

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializer(forClass = JobExperience::class)
class JobExperienceSerializer : KSerializer<JobExperience> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("JobExperience") {
        element<String>("date_start")
        element<String>("date_end")
        element<String>("company_name")
        element<String>("description")
    }

    override fun deserialize(decoder: Decoder): JobExperience {
        return decoder.decodeStructure(descriptor) {
            var dateStart = "1970-01-01".toLocalDate()
            var dateEnd = "1970-01-01".toLocalDate()
            var companyName = ""
            var description = ""

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    CompositeDecoder.DECODE_DONE -> break
                    0 -> dateStart = LocalDate.parseCustomFormat(decodeStringElement(descriptor, index), CustomDateFormat.MONTH_YEAR)
                    1 -> dateEnd = LocalDate.parseCustomFormat(decodeStringElement(descriptor, index), CustomDateFormat.MONTH_YEAR)
                    2 -> companyName = decodeStringElement(descriptor, index)
                    3 -> description = decodeStringElement(descriptor, index)
                    else -> error("Error: Unexpected index with deserialize: $index")
                }
            }
            JobExperience(dateStart, dateEnd, companyName, description)
        }
    }


    override fun serialize(encoder: Encoder, jobExperience: JobExperience) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, jobExperience.dateStart.toCustomFormat(CustomDateFormat.MONTH_YEAR))
            encodeStringElement(descriptor, 1, jobExperience.dateEnd.toCustomFormat(CustomDateFormat.MONTH_YEAR))
            encodeStringElement(descriptor, 2, jobExperience.companyName)
            encodeStringElement(descriptor, 3, jobExperience.description)
        }
    }
}

@Serializer(forClass = LocalDate::class)
class CustomLocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("date", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDate {
        val dateString = decoder.decodeString()

        if (dateString.matches(CustomDateFormat.YEAR.regex)) return LocalDate.parseCustomFormat(
            dateString,
            CustomDateFormat.YEAR
        )
        else if (dateString.matches(CustomDateFormat.YEAR.regex)) return LocalDate.parseCustomFormat(
            dateString,
            CustomDateFormat.YEAR
        )
        else if (dateString.matches(CustomDateFormat.YEAR.regex)) return LocalDate.parseCustomFormat(
            dateString,
            CustomDateFormat.YEAR
        )
        else throw IllegalArgumentException(DATE_FORMAT_ERROR)
    }


    override fun serialize(encoder: Encoder, localDate: LocalDate) {
        encoder.encodeString("1970-01-01")
    }
}