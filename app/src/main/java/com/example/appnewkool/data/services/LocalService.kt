package com.example.appnewkool.data.services

import com.example.appnewkool.data.database.dao.ProductDao
import com.example.appnewkool.data.database.entities.ProductEntity
import javax.inject.Inject

class LocalService @Inject constructor(private val productDao: ProductDao) {
    suspend fun getAllProduct() = productDao.getAll()

    suspend fun saveListProduct(product: List<ProductEntity>) =
        productDao.insertAll(product)

    suspend fun deleteAllProduct() = productDao.deleteAll()
}