package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // if data is already present it will be updated, otherwise inserted
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    suspend fun getAllItems() : LiveData<List<ShoppingItem>>
}