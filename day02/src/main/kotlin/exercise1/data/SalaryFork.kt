package exercise1.data

enum class SalaryFork(
    override val displayableName: String,
    val lowerBound: Int,
    val higherBound: Int,
    override val order: Int
) :
    CustomFilterEnum {
    LOW("< 100000", 0, 99999, 1),
    MID("100000 - 150000", 10000, 149999, 2),
    HIGH("> 150000", 150000, Int.MAX_VALUE, 3);

    fun isSuitable(salary: Int): Boolean {
        return salary in this.lowerBound..this.higherBound
    }

    companion object {
        val optionToDisplay: String = """
            Select a salary level:
            1. < 100000
            2. 100000 - 150000
            3. > 150000
            4. All
        """.trimIndent()
    }
}