package com.example.shoppinglist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.db.ShoppingItem
import com.example.shoppinglist.databinding.ItemShoppingBinding

class ShoppingAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    private lateinit var binding : ItemShoppingBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingAdapter.ShoppingViewHolder {

        binding = ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ShoppingViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ShoppingAdapter.ShoppingViewHolder, position: Int) {

        with(holder){

            val currShoppingItem = items[position]

            binding.itemName.text = currShoppingItem.name
            binding.itemQuantity.text = "${currShoppingItem.count}"

            binding.delete.setOnClickListener {
                viewModel.delete(currShoppingItem)
            }

            binding.plus.setOnClickListener {
                currShoppingItem.count++
                viewModel.insert(currShoppingItem)
            }

            binding.minus.setOnClickListener {
                if(currShoppingItem.count > 0){
                    currShoppingItem.count--
                    viewModel.insert(currShoppingItem)
                }
                else{
                    viewModel.delete(currShoppingItem)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(binding: ItemShoppingBinding) : RecyclerView.ViewHolder(binding.root)
}