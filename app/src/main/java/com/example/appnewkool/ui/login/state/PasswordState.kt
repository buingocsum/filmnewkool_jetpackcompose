package com.example.appnewkool.ui.login.state


class PasswordState : TextFieldState(
    validator = ::isPasswordValid,
    errorMessage = ::passwordErrorMessage) {
}

private fun isPasswordValid(password: String) = password.length >= 4
private fun passwordErrorMessage(password: String) = "Password is invalid"