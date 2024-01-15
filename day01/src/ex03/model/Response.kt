package ex03.model;

sealed class Response {
    protected abstract val code: String

    protected abstract fun getMessage(): String

    fun success() {
        println("""
            |${getMessage()}
            |*doing smth else than error*
        """.trimMargin())
    }

    fun error() {
        println(getMessage())
    }
}
