package ex03.model

class ResponseHandler {
    companion object {
        fun handleResponse(code: String) {
            when (val response = ResponseFactory.createResponse(code)) {
                is CreateSuccess, is UpdateOrRetrieveSuccess -> response.success()
                is NoConnectionError, is FailedVerificationError, is SessionExpiredError, is UserNotIdentifiedError, is UnknownError -> response.error()
            }
        }
    }
}