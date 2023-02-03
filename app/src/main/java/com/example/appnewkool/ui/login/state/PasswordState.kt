package com.example.appnewkool.ui.login.state

import java.util.regex.Pattern

class PasswordState : TextFieldState(
    validator = ::isEmailValid,
    errorMessage = ::emailErrorMessage) {
}

private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"
private fun isEmailValid(email: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}
private fun emailErrorMessage(email: String) = "Email $email invalid"