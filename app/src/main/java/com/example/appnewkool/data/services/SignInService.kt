package com.example.appnewkool.data.services

import com.example.appnewkool.data.api.LoginApi
import com.example.appnewkool.data.base.BaseRemoteService
import com.example.appnewkool.data.base.network.NetworkResult
import com.example.appnewkool.data.model.Account
import com.example.appnewkool.data.modeljson.SignInResponse
import javax.inject.Inject

class SignInService @Inject constructor(private val loginApi: LoginApi) : BaseRemoteService() {
    suspend fun signInAccount(userName: Account): NetworkResult<SignInResponse> {
        return callApi { loginApi.signIn(userName) }
    }
}