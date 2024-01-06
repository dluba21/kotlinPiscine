package ex03.model;

sealed class Success : Response() {
    init {
        message = """
              Code: $code
              Response: The request processed successfully
        """.trimIndent()
    }
}

data class UpdateOrRetrieveSuccess(override val code: String = ResponseCodes.UpdateOrRetriveSuccess.code): Success()
data class CreateSuccess(override val code: String = ResponseCodes.CreateSuccess.code) : Success()

