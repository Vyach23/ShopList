package com.demo.shoplist.data

import com.demo.shoplist.domain.ShopItem
import com.demo.shoplist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private var autoIncrementId = 0

    private val shopList = mutableListOf<ShopItem>()

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID ) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException ("Element with id$shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toMutableList()
    }
}