package ex03.model

enum class ResponseCodes(val code: String) {
    UserNotIdentifiedError("1000"),
    SessionExpiredError("1001"),
    NoConnectionError("1002"),
    FailedVerificationError("1003"),
    UpdateOrRetriveSuccess("200"),
    CreateSuccess("201"),
}
