package com.example.appnewkool.ui.login.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.appnewkool.data.base.BaseViewModel
import com.example.appnewkool.data.model.Account
import com.example.appnewkool.data.modeljson.SignInResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInRepository: SignInRepository) :
    BaseViewModel() {
    var inputUserState by mutableStateOf(InputUserState())
        private set

    var signInResult by mutableStateOf<SignInResponse?>(null)
        private set

    fun signIn(userName: Account) {
        isLoading = true
        parentJob = viewModelScope.launch(handler) {
            signInResult = signInRepository.signIn(userName)
        }
        onJobFinish()
    }

    fun onEmailInputChange(email: String) {
        if (!isEmailValid(email)) {
            inputUserState =
                inputUserState.copy(email = email, emailErrorMessage = "Email $email không hợp lệ")
        } else inputUserState = inputUserState.copy(email = email, emailErrorMessage = null)
    }

    fun onPasswordInputChange(password: String) {
        if (!isPasswordValid(password)) {
            inputUserState = inputUserState.copy(
                passWord = password,
                passwWordErrorMessage = "Password không hợp lệ"
            )
        } else inputUserState =
            inputUserState.copy(passWord = password, passwWordErrorMessage = null)
    }


    private fun isEmailValid(email: String): Boolean {
        val emailRegex = "^(.+)@(.+)\$"
        return Pattern.matches(emailRegex, email)
    }

    private fun isPasswordValid(password: String) = password.length >= 6
}

data class InputUserState(
    val email: String = "",
    val passWord: String = "",
    val emailErrorMessage: String? = null,
    val passwWordErrorMessage: String? = null,
    )
