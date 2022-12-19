package com.example.appnewkool.data.api

import com.example.appnewkool.data.modeljson.ProductResponse
import com.example.appnewkool.data.modeljson.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap

interface ProductApi {
    @GET("/api/product")
    suspend fun getAllProduct(@HeaderMap headers: Map<String?, String>) : Response<List<ProductResponse>>
}