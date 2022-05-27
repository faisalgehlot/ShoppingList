package com.faisalgehlot.shoppinglist.ui.shoppinglist

import com.faisalgehlot.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)

}