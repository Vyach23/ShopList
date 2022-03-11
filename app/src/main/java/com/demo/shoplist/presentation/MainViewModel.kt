package com.demo.shoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.shoplist.data.ShopListRepositoryImpl
import com.demo.shoplist.domain.DeleteShopItemUseCase
import com.demo.shoplist.domain.EditShopItemUseCase
import com.demo.shoplist.domain.GetShopListUseCase
import com.demo.shoplist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList () {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem (shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }

}