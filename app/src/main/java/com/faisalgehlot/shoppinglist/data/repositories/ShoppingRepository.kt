package com.faisalgehlot.shoppinglist.data.repositories

import com.faisalgehlot.shoppinglist.data.db.ShoppingDataBase
import com.faisalgehlot.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository (
    private val db: ShoppingDataBase
        ) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingData().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingData().delete(item)

    fun getAllShoppingIteme() = db.getShoppingData()
}