package com.example.appnewkool.data.services

import com.example.appnewkool.common.AppSharePreference
import com.example.appnewkool.data.api.ProductApi
import com.example.appnewkool.data.base.BaseRemoteService
import com.example.appnewkool.data.base.network.NetworkResult
import com.example.appnewkool.data.modeljson.ProductResponse
import javax.inject.Inject

class ProductRemoteService @Inject constructor(private val productApi: ProductApi) : BaseRemoteService() {
    @Inject lateinit var appSharePreference: AppSharePreference

    suspend fun getListProductResponse(): NetworkResult<List<ProductResponse>>{
        val getToken = appSharePreference.getSharedPreferences()?.getString("token","")
        val header = mapOf(getToken to "token")
        return callApi { productApi.getAllProduct(header) }
    }
}