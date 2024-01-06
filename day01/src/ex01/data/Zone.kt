package ex01.data

import ex01.data.Point
import ex01.helpers.RandomLinesHelper

abstract class Zone {
    private val COMMON_PHONE_NUMBER = "88008473824"
    val phoneNumber = RandomLinesHelper.getPhone()
    abstract val REGEX_PATTERN: String

    fun getCommonPhoneNumber(): String = COMMON_PHONE_NUMBER
    abstract fun isZoneApplicable(input: String): Boolean
    abstract fun fill(input: String);
    abstract fun isInsideZone(point: Point): Boolean
    abstract fun getName(): String
}

