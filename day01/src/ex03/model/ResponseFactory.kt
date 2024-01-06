package ex03.model

class ResponseFactory {
    companion object {
        fun createResponse(code: String): Response {
            return when (code) {
                ResponseCodes.CreateSuccess.code -> CreateSuccess()
                ResponseCodes.UpdateOrRetriveSuccess.code -> UpdateOrRetrieveSuccess()
                ResponseCodes.UserNotIdentifiedError.code -> UserNotIdentifiedError()
                ResponseCodes.SessionExpiredError.code -> SessionExpiredError()
                ResponseCodes.NoConnectionError.code -> NoConnectionError()
                ResponseCodes.FailedVerificationError.code -> FailedVerificationError()
                else -> UnknownError(code)
            }
        }
    }
}