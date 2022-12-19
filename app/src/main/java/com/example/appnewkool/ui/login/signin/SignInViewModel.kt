package com.example.appnewkool.ui.login.signin

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appnewkool.common.AppSharePreference
import com.example.appnewkool.common.Utils
import com.example.appnewkool.data.base.BaseViewModel
import com.example.appnewkool.data.model.Account
import com.example.appnewkool.data.modeljson.SignInResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInRepository: SignInRepository) : BaseViewModel() {


    private var _signIn = MutableLiveData<SignInResponse>()
    val signIn: LiveData<SignInResponse>
    get() = _signIn

    override fun fetchData() {
//        showLoading(true)
        parentJob = viewModelScope.launch(handler) {

        }
        registerJobFinish()
    }

    fun signIn(userName: Account){
        parentJob = viewModelScope.launch(handler) {
            val resultSignIn = signInRepository.signIn(userName)



            _signIn.postValue(resultSignIn)
        }
    }


}
