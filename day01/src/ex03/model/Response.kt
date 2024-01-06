package ex03.model;

sealed class Response() {
    protected abstract val code: String
    protected var message: String = ""

    fun success() {
        println("""
            $message
            *doing smth else than error*
        """.trimIndent())
    }

    fun error() {
        println(message)
    }
}
