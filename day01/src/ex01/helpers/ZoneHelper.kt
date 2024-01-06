package ex01.helpers;

import ex01.data.CircleZone
import ex01.data.TetragonZone
import ex01.data.TriangleZone
import ex01.data.Zone

public class ZoneHelper {
    companion object {
        fun chooseZone(input: String): Zone {
            val zones = arrayListOf(CircleZone(), TriangleZone(), TetragonZone()) //todo инкапсулировать - сделать di чтобы было непонятно что внутри

            return zones.firstOrNull { it.isZoneApplicable(input) }?.apply { fill(input) } ?: throw IllegalArgumentException("Error: incorrect zone input")
        }
    }
}
