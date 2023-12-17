package com.example.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.repo.ShoppingRepo

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val db = ShoppingDatabase(this)
        val shoppingRepo = ShoppingRepo(db)
        val factory = ShoppingViewModelFactory(shoppingRepo)
        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

    }
}

