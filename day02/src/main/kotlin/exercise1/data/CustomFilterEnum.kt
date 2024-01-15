package exercise1.data

//todo по-хорошему вынести сюда метод customFilter() для конкретного енама, чтобы добиться большей инкапсуляции
interface CustomFilterEnum {
    val order: Int
    val displayableName: String

    companion object {
        /**
         * 1) тут либо возвращать список - то есть если есть соотвествие,
         *  то фильтр ставить по введенным значениям (если более одного фильтра, но в задании один)
         *  и при фильтре Any возвращать весь список enumValues, но тогда это непроизводительно,
         *  тк фильтровать так то и не надо ничего (зато легче пишется код) - мой вариант
         * 2) или возвращать один элемент и если null, то фильтр вообще не навешивать
         */
        inline fun <reified T> fromOrder(order: Int?): List<T> where T : Enum<T>, T : CustomFilterEnum {
            return if (order == null || order <= 0 || order > enumValues<T>().size + 1) emptyList()
            else if (order == enumValues<T>().size + 1) {enumValues<T>().toList()}
            else listOf(enumValues<T>().first{ it.order == order })
        }

        //todo попроьовать вынести потом метод чтобы понять как параметризовывать вне компаньона (применять к объекту а не статически)
        inline fun <reified T> printFilter(filterList: List<T>): String where T : Enum<T>, T : CustomFilterEnum {
           return if (filterList.size == enumValues<T>().size) "All"
            else filterList.first().displayableName
        }
    }
}