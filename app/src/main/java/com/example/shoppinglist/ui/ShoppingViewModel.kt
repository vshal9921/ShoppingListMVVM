package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.ShoppingItem
import com.example.shoppinglist.data.repo.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val shoppingRepo: ShoppingRepo) : ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {

        shoppingRepo.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepo.delete(item)
    }

     fun getAllShoppingItems() = shoppingRepo.getAllShoppingItems()

}