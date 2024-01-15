package ex03.model

sealed class Error(header: String, title: String, description: String) : Response()  {
    abstract val header: String
    abstract val title: String
    abstract val description: String

    override fun getMessage(): String {
        return  """
            $header: 
              Code: $code
              
              Title: $title
              Description: $description
        """.trimIndent()
    }
}

data class UserNotIdentifiedError(
    override val code: String = ResponseCodes.UserNotIdentifiedError.code,
    override val header: String = "The user is not identified",
    override val title: String = "FailVerificationError",
    override val description: String = "*descr*")
    : Error(header, title, description)

data class SessionExpiredError(
    override val code: String = ResponseCodes.SessionExpiredError.code,
    override val header: String = "SessionExpiredError",
    override val title: String = "The session is expired",
    override val description: String = "*descr*"
) : Error(header, title, description)

data class NoConnectionError(
    override val code: String = ResponseCodes.NoConnectionError.code,
    override val header: String = "NoConnectionError",
    override val title: String = "No connection",
    override val description: String = "*descr*")
    : Error(header, title, description)

data class FailedVerificationError(
    override val code: String = ResponseCodes.FailedVerificationError.code,
    override val header: String = "FailedVerificationError",
    override val title: String = "FailedVerificationError",
    override val description: String = "The device has failed the verification")
    : Error(header, title, description)

data class UnknownError(
    override val code: String,
    override val header: String = "UnknownError",
    override val title: String = "Error code: $code",
    override val description: String = "Unknown error. Please, try again later")
    : Error(header, title, description)