package com.example.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.repo.ShoppingRepo
import com.example.shoppinglist.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = ShoppingDatabase(this)
        val shoppingRepo = ShoppingRepo(db)
        val factory = ShoppingViewModelFactory(shoppingRepo)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

    }
}

