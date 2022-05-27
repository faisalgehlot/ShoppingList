package com.faisalgehlot.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// This class main perpash is to holdData ... means Entity from MVVM

@Entity(tableName = "shopping_items")
data class ShoppingItem(

    @ColumnInfo(name = "items_name")
    var name: String,

    @ColumnInfo(name = "items_amount")
    var amount: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}