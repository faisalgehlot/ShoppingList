package com.faisalgehlot.shoppinglist.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faisalgehlot.shoppinglist.data.db.entities.ShoppingItem
import com.faisalgehlot.shoppinglist.databinding.ShoppingItemsBinding
import com.faisalgehlot.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter (
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    // viewHolder
    inner class ShoppingViewHolder(val binding: ShoppingItemsBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(
            ShoppingItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItems = items[position]

        holder.binding.tvName.text = curShoppingItems.name
        holder.binding.tvAmount.text = curShoppingItems.amount.toString()

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItems)
        }
        holder.binding.ivPlus.setOnClickListener {
            curShoppingItems.amount++
            viewModel.upsert(curShoppingItems)
        }
        holder.binding.ivMinus.setOnClickListener {
            if (curShoppingItems.amount > 0)
            curShoppingItems.amount--
            viewModel.upsert(curShoppingItems)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}