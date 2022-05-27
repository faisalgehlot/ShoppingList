package com.faisalgehlot.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.faisalgehlot.shoppinglist.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDataBase: RoomDatabase() {

    abstract fun getShoppingData(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createData(context).also { instance = it }
        }

        private fun createData(context: Context) =
        Room.databaseBuilder(context.applicationContext,
        ShoppingDataBase::class.java, "ShoppingDB.db").build()
    }
}