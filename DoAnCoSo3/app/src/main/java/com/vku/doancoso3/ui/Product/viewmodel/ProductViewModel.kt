package com.vku.doancoso3.ui.Product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.Data.CartItem
import com.example.foodapp.Data.Datasource
import com.example.foodapp.Data.Product
import com.google.android.play.integrity.internal.s
import com.vku.doancoso3.Data.Combo
import com.vku.doancoso3.Data.Drink
import com.vku.doancoso3.Data.Side
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {

    private val _viewState = MutableStateFlow(ProductViewState())
    val viewState = _viewState.asStateFlow()





    init {
        viewModelScope.launch {
            // thu thập giá trị từ ViewState
            viewState.collect { state ->
                Datasource.cartBurgerList = ArrayList(state.cartBurgerList)
            }
        }
    }
    fun addtoCartBurger(product: Product) {
        viewModelScope.launch {
            val listBurger = ArrayList(_viewState.value.cartBurgerList)
            // tìm sản phẩm cùng id trong danh sách hiện tạ
            val existingCartItem = listBurger.find { it.product.id == product.id }
 // nếu tồn tại sản phẩm trong giỏ hàng thì  tăng lên
            if (existingCartItem != null) {
                existingCartItem.quantity += 1
            } else {
                listBurger.add(CartItem(product, 1))
            }
        // cập nhật trạng thái mới cho ViewState
            _viewState.update {
                it.copy(cartBurgerList = listBurger)
            }
        }
    }



//    fun addtoCartBurger(product:Product){
//
//
//
//        //đảm bảo rằng các tác vụ  không đồng bộ được quản lí đúng cách
//        viewModelScope.launch {
//
//            val listBurger = ArrayList(_viewState.value.cartBurgerList)
//            val existingProduct = listBurger.find { it.id == product.id }
//
//
//
//            if (existingProduct != null) {
//                // Nếu sản phẩm đã có trong giỏ hàng, tăng số lượng lên 1
//                val index = listBurger.indexOf(existingProduct)
//                listBurger[index] = existingProduct.copy(quantity = existingProduct.quantity + 1)
//            } else {
//                // Nếu sản phẩm chưa có trong giỏ hàng, thêm mới vào danh sách
//                listBurger.add(product.copy(quantity = 1))
//            }
////            listBurger.add(product)
////            _viewState.update {
////                it.copy(
////                    cartBurgerList =  listBurger
////
////                )
////            }
//        }
//    }

//    init {
//        viewModelScope.launch {
//            viewState.collect { state ->
//                Datasource.cartBurgerList = ArrayList(state.cartBurgerList.map { it.product })
//            }
//        }
//    }
//
//    fun addtoCartBurger(product: Product) {
//        viewModelScope.launch {
//            val listBurger = ArrayList(_viewState.value.cartBurgerList)
//            val existingCartItem = listBurger.find { it.product.id == product.id }
//
//            if (existingCartItem != null) {
//                existingCartItem.quantity += 1
//            } else {
//                listBurger.add(CartItem(product, 1))
//            }
//
//            _viewState.update {
//                it.copy(cartBurgerList = listBurger)
//            }
//        }
//    }
//








    fun addtoCartCombo(combo:Combo){
        viewModelScope.launch {
            val listCombo = ArrayList(_viewState.value.cartComboList)
            listCombo.add(combo)

            _viewState.update {
                it.copy(
                    cartComboList = listCombo
                )
            }
        }

    }
    fun addtoCartSide(side:Side){
        viewModelScope.launch {
            // lưu giá trị hiện tại của cartSide
            val listSide= ArrayList(_viewState.value.cartSideList)
            listSide.add(side)

            _viewState.update {
                it.copy(
                    cartSideList = listSide
                )
            }
        }
    }
    fun addtoCartDrink(drink :Drink){
       viewModelScope.launch {
           val listDrink = ArrayList(_viewState.value.cartDrinkList)
           listDrink.add(drink)

           _viewState.update {
               it.copy(
                   cartDrinkList = listDrink
               )
           }


       }
    }



}


data class  ProductViewState(
//    val productList: List<Product> = emptyList(),
    val cartBurgerList: List<CartItem> = emptyList(),
    val cartComboList:List<Combo> = emptyList(),
    val cartSideList:List<Side> = emptyList(),
    val cartDrinkList: List<Drink> = emptyList(),
){

}