package com.example.appnewkool.data.services

import android.util.Log
import com.example.appnewkool.data.database.dao.ProductDao
import com.example.appnewkool.data.database.entities.ProductEntity
import com.example.appnewkool.data.model.Product
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalService @Inject constructor(private val productDao: ProductDao) {
    fun getAllProduct() = flow { emit(productDao.getAll()) }


    suspend fun getProduct(id: Int) = productDao.getProduct(id)


    suspend fun saveListProduct(product: List<ProductEntity>) =
        productDao.insertAll(product)

    suspend fun deleteAllProduct() = productDao.deleteAll()

    suspend fun insertProduct(productEntity: ProductEntity) =
        productDao.insertProduct(productEntity)

//    suspend fun sortProducts(hangXe:String)= productDao.sortHangXe(hangXe)
}