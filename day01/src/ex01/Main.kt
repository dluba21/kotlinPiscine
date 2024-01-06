import ex01.data.IncidentFactory
import ex01.helpers.ZoneHelper

fun main(args: Array<String>) {

    println("Enter zone parameters:")
    val zone = ZoneHelper.chooseZone(readln())
    println("""
        The zone info:
         The shape of zone: ${zone.getName()} 
         Phone number: ${zone.phoneNumber}
    """.trimIndent())

    println("Enter an incident coordinates:")
    val incident = IncidentFactory.getIncident(readln())
    println("""
        The incident info:
          Description: ${incident.description}
          Phone number: ${incident.applicantPhone}
          Type: ${incident.type.displayableName}
    """.trimIndent())

    val isInZone = zone.isInsideZone(incident.point)
    println("An incident is " +
            "${if (!isInZone) "not " else ""}" +
            "in the zone" +
            "\n${if (!isInZone) "Switch the applicant to the common number: ${zone.getCommonPhoneNumber()}" else ""}")
}

