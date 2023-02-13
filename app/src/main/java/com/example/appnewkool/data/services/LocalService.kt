package com.example.appnewkool.data.services

import android.util.Log
import com.example.appnewkool.data.database.dao.ProductDao
import com.example.appnewkool.data.database.entities.ProductEntity
import com.example.appnewkool.data.model.Product
import javax.inject.Inject

class LocalService @Inject constructor(private val productDao: ProductDao) {
    suspend fun getAllProduct() = productDao.getAll()


    suspend fun getProduct(id: Int) : ProductEntity {
        Log.e("service", "getProduct: " + productDao.getProduct(id) )
        return productDao.getProduct(id)
    }

    suspend fun saveListProduct(product: List<ProductEntity>) =
        productDao.insertAll(product)

    suspend fun deleteAllProduct() = productDao.deleteAll()

    suspend fun insertProduct(productEntity: ProductEntity) = productDao.insertProduct(productEntity)
}