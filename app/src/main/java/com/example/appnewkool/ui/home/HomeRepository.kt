package com.example.appnewkool.ui.home

import com.example.appnewkool.data.base.network.NetworkResult
import com.example.appnewkool.data.database.entities.toListProduct
import com.example.appnewkool.data.database.entities.toListProductEntity
import com.example.appnewkool.data.model.Product
import com.example.appnewkool.data.modeljson.toListProduct
import com.example.appnewkool.data.services.LocalService
import com.example.appnewkool.data.services.ProductRemoteService
import com.example.appnewkool.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val localService: LocalService,
                                         private val productRemoteService: ProductRemoteService,
                                         @IoDispatcher private val dispatcher: CoroutineDispatcher)  {
    suspend fun getListProduct(): List<Product> = withContext(dispatcher) {
        val saveProduct = localService.getAllProduct()
        if(saveProduct.isNotEmpty()){
            saveProduct.toListProduct()
        } else {
            getProductAndSaveFromRemote()
        }
    }

    suspend fun getProductAndSaveFromRemote() : List<Product>{
        var newProductList = listOf<Product>()

        when(val result = productRemoteService.getListProductResponse()){
            is NetworkResult.Success -> newProductList = result.data.toListProduct()
            is NetworkResult.Error -> throw result.exception
        }

        if(newProductList.isNotEmpty()){
            localService.deleteAllProduct()
            localService.saveListProduct(newProductList.toListProductEntity())
        }
        return newProductList
    }

}