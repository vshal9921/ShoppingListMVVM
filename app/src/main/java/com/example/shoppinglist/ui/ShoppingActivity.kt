package com.example.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.ShoppingItem
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


        val adapter = ShoppingAdapter(listOf(), viewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.floatingButton.setOnClickListener {

            ShoppingDialog(this, object : AddDialogInterface{
                override fun onClickItem(item: ShoppingItem) {
                    viewModel.insert(item)
                }
            }).show()
        }

    }
}

