package com.example.appnewkool.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appnewkool.data.database.entities.ProductEntity
import com.example.appnewkool.data.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product ORDER BY tenXe ASC")
    suspend fun getAll(): List<ProductEntity>

    @Insert
    suspend fun insertAll(products: List<ProductEntity>)

    @Query("SELECT * FROM product WHERE id = :id")
    suspend fun getProduct(id: Int): ProductEntity

    @Query("DELETE FROM product")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(vararg productEntity: ProductEntity)
}