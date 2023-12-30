package com.example.shoppinglist.data.repo

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.ShoppingItem

class ShoppingRepo (private val db : ShoppingDatabase){

    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

     fun getAllShoppingItems() = db.getShoppingDao().getAllItems()

}