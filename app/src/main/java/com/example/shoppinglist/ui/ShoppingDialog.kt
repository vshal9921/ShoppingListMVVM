package com.example.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.data.db.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddBinding

class ShoppingDialog(context : Context, var addDialogInterface: AddDialogInterface) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DialogAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {

            val name = binding.etItem.text.toString()
            val quantity = binding.etQuantity.text.toString()

            if(name.isEmpty() || quantity.isEmpty()){
                Toast.makeText(context,"Please fill the values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, quantity.toInt())
            addDialogInterface.onClickItem(item)
            dismiss()
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }

}