package com.example.appnewkool.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.appnewkool.data.database.entities.ProductEntity

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<ProductEntity>

    @Insert
    fun insertAll(products: List<ProductEntity>)

    @Query("DELETE FROM product")
    fun deleteAll()
}