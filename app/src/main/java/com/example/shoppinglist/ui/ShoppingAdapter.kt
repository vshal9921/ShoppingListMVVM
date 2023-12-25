package com.example.shoppinglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingItem
import kotlinx.android.synthetic.main.item_shopping.view.delete
import kotlinx.android.synthetic.main.item_shopping.view.itemName
import kotlinx.android.synthetic.main.item_shopping.view.itemQuantity
import kotlinx.android.synthetic.main.item_shopping.view.minus
import kotlinx.android.synthetic.main.item_shopping.view.plus

class ShoppingAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingAdapter.ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }
    override fun onBindViewHolder(holder: ShoppingAdapter.ShoppingViewHolder, position: Int) {

        val currShoppingItem = items.get(position)

        holder.itemView.itemName.text = currShoppingItem.name
        holder.itemView.itemQuantity.text = "${currShoppingItem.count}"

        holder.itemView.delete.setOnClickListener {
            viewModel.delete(currShoppingItem)
        }

        holder.itemView.plus.setOnClickListener {
            currShoppingItem.count++
            viewModel.insert(currShoppingItem)
        }

        holder.itemView.minus.setOnClickListener {
            if(currShoppingItem.count > 0){
                currShoppingItem.count--
                viewModel.delete(currShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}