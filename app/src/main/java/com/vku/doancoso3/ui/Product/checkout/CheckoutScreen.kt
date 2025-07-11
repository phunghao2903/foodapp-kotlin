package com.vku.doancoso3.ui.Product.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodapp.Data.CartItem
import com.example.foodapp.Data.Datasource
import com.example.foodapp.Data.Product
import com.google.android.play.integrity.internal.al
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.Product.AppBarCustomizeScreen

@Composable
fun CheckoutScreen(navController: NavHostController){
    Column {
        AppBarCustomizeScreen(navController=navController)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = Datasource.cartBurgerList){cartItem->
                CheckoutBurgerList(cartItem=cartItem)
            }
        }
        Row(
            modifier = Modifier
        ) {

        }
//        Text(text = "Total")
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutBurgerList(cartItem: CartItem) {
    val burger = cartItem.product
    val quantity = cartItem.quantity
    Card(
        onClick = { },
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .height(155.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(5.dp)
            )

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(16.dp)
                .height(105.dp)
        ) {
            Image(
                painter = painterResource(id = burger.image),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = 5.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(start = 200.dp)
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "",
                        )
                    }
                }

                Text(
                    text = burger.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.offset(y = -20.dp),
                    fontSize = 20.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(30.dp)

                ) {
                    Box(
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "$${burger.star}",
                            modifier = Modifier.offset(y = -5.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
//                        Text(
//                            text = "Qty",
//                            modifier = Modifier.padding(start = 60.dp)
//                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        Color(
                                            red = 239,
                                            green = 42,
                                            blue = 57,
                                            alpha = 255
                                        ), shape = RoundedCornerShape(10.dp)
                                    )
                            )
                        }
                        Text(
                            text = quantity.toString(),
                            fontSize = 19.sp,
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_remove_24) ,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        Color(
                                            red = 239,
                                            green = 42,
                                            blue = 57,
                                            alpha = 255
                                        ), shape = RoundedCornerShape(10.dp)
                                    )
                            )
                        }
                    }


                }
            }
        }
            // đóng column


        }


    }









@Preview
@Composable
fun CheckoutScreenPreview() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

        CheckoutBurgerList(cartItem = CartItem(product =   Product(id = 1,R.drawable.pngwing1,"Burger ","Wendy Burger",4.9),1  ))

    }
//    FloatingButton()
}
