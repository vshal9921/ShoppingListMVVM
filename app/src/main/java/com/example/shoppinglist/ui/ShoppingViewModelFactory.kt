package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.data.repo.ShoppingRepo

class ShoppingViewModelFactory(private val shoppingRepo: ShoppingRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepo) as T
    }
}