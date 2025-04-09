package com.example.foodapp.Data

import com.vku.doancoso3.Data.Combo
import com.vku.doancoso3.Data.Danhmuc
import com.vku.doancoso3.Data.Drink
import com.vku.doancoso3.Data.Side
import com.vku.doancoso3.R

//import com.example.foodapp.R

object Datasource {

    val danhmuc = listOf(
        Danhmuc("Burger"),
        Danhmuc("Combo"),
        Danhmuc("Side dishes"),
        Danhmuc("Drinks"),
    )

    val combo = listOf(
        Combo(R.drawable.combo1,"Combo ","Combo 1",4.7),
        Combo(R.drawable.combo2,"Combo ","Combo 2",4.8),
        Combo(R.drawable.combo3,"Combo ","Combo 3",4.8),
        Combo(R.drawable.combo4,"Combo ","Combo 4",4.8),
        Combo(R.drawable.combo5,"Combo ","Combo 5",4.8),
    )

    val side = listOf(
        Side(R.drawable.fries,"Side dishes ","Fries",4.7),
        Side(R.drawable.chicken,"Side dishes ","Chicken nuggets",4.8),
        Side(R.drawable.combo3,"Side dishes ","Combo 3",4.8),
        Side(R.drawable.combo4,"Side dishes ","Combo 4",4.8),
        Side(R.drawable.combo5,"Side dishes ","Combo 5",4.8),
    )

    val drink = listOf(
        Drink(R.drawable.coca,"Drinks ","Coca",4.7),
        Drink(R.drawable.soda,"Drinks ","Soda",4.8),
        Drink(R.drawable.combo3,"Drinks ","Combo 3",4.8),
        Drink(R.drawable.combo4,"Drinks ","Combo 4",4.8),
        Drink(R.drawable.combo5,"Drinks ","Combo 5",4.8),
    )

    val product = listOf(
        Product(id = 1,R.drawable.pngwing1,"Burger ","Wendy Burger",4.9),
        Product(id = 2,R.drawable.pngwing3,"Burger ","Bacon burger",4.8),
        Product(id = 3,R.drawable.pngwing3,"Burger ","Chicken cheese",4.7),
        Product(id = 4,R.drawable.pngwing1,"Burger ","Chicken cheese",4.9),
        Product(id = 5,R.drawable.pngwing7,"Burger ","Veggie Burger",4.7),
        Product(id = 6,R.drawable.pngwing7,"Burger ","Bacon burger",4.7),
        Product(id = 7,R.drawable.pngwing1,"Burger","Chicken cheese",4.9),
        Product(id = 8,R.drawable.pngwing3,"Burger","Wendy Burger",4.8),
        Product(id = 9,R.drawable.pngwing3,"Burger","Fried Chicken",4.7),
    )


    var cartBurgerList= ArrayList<CartItem>()



}


data class CartItem(
    val product: Product,
    var quantity: Int
)