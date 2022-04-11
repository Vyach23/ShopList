package com.demo.shoplist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.demo.shoplist.domain.ShopItem

class ShopListDiffUtilCallback(
    private val oldlist: List<ShopItem>,
    private val newlist: List<ShopItem>,
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldlist.size
    }

    override fun getNewListSize(): Int {
        return newlist.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldlist[oldItemPosition]
        val newItem = newlist[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldlist[oldItemPosition]
        val newItem = newlist[newItemPosition]
        return oldItem == newItem
    }
}