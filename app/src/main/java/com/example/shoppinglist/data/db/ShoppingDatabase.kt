package com.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.db.entity.ShoppingDao

@Database(
    entities = [ShoppingItem::class],
    version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance : ShoppingDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(Any()) {   // Any() works as lock
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB.db").build()


    }
}