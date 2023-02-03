package com.example.appnewkool.ui.login.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class TextFieldState(
    private val validator: (String)-> Boolean = {true},
    private val errorMessage: (String)-> String
) {
    var text by mutableStateOf("")
}