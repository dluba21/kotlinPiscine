package ex03.model;

sealed class Success : Response() {
    override fun getMessage(): String {
            return  """
                |Code: $code
                |Response: The request processed successfully
            """.trimMargin()
    }
}

data class UpdateOrRetrieveSuccess(override val code: String = ResponseCodes.UpdateOrRetriveSuccess.code): Success()
data class CreateSuccess(override val code: String = ResponseCodes.CreateSuccess.code) : Success()


