package com.example.foodapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.Data.Datasource
import com.example.foodapp.Data.Datasource.combo
import com.example.foodapp.Data.Datasource.product
import com.example.foodapp.Data.Datasource.side
import com.example.foodapp.Data.Product
import com.vku.doancoso3.Data.Combo
import com.vku.doancoso3.Data.Danhmuc
import com.vku.doancoso3.Data.Drink
import com.vku.doancoso3.Data.Side
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.Product.viewmodel.ProductViewModel
import java.util.Locale.filter


@Composable
fun FloatingButton(count: Int= 0,navController: NavHostController) {
    val viewModel = viewModel<ProductViewModel>()

    Box(
        modifier = Modifier
            .size(80.dp)
            .offset(x = -0.dp, y = 45.dp)
//                    .background(Color.Blue)
            .background(
                Color.Transparent,
                shape = RoundedCornerShape(45.dp)
            ),
//                contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeightIn(40.dp)
                .background(
                    Color.Transparent,

                    ),
        ) {

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
                .offset(x = 0.dp, y = 51.dp)
                .background(
                    Color(252, 205, 205, 255),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                ),
        ) {

        }
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 10.dp)
                .align(Alignment.Center)
        ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate("CheckoutScreen")

                },
                contentColor = Color.White,
                containerColor = Color(android.graphics.Color.parseColor("#FF3D3D")),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .shadow(
                        elevation = 15.dp,
                        shape = CircleShape,
                        ambientColor = Color(19, 15, 15, 255),
                        spotColor = Color(0, 0, 0, 255)
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.btn_cart),
                    contentDescription = null,
                    modifier = Modifier.scale(1.5f)
                )
            }
        }

        Box(
            modifier = Modifier
                .offset(x = -5.dp, y = 10.dp)
                .size(30.dp)
                .background(Color(252, 112, 122, 255), CircleShape)
                .align(Alignment.TopEnd)

        ) {
            Text(
                text = count.toString(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center),
                color = Color.White
            )
        }

    }

}


@Composable
fun BottomAppbarProductGrid(navController: NavHostController) {
    BottomAppBar(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        containerColor = Color(android.graphics.Color.parseColor("#EF2A39"))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
//                .offset(x = -80.dp)

            ) {
                Image(
                    painter = painterResource(R.drawable.btn_home),
                    contentDescription = "Home",
                    modifier = Modifier.scale(2f),

                    )
            }
            IconButton(
                onClick = {
                    navController.navigate("EditProfileScreen")
                },
                modifier = Modifier
//                .offset(x = -50.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.btn_profile),

                    contentDescription = "Home",
                    modifier = Modifier
                        .scale(2f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
//                    .offset(x = 50.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.btn_chat),
                    contentDescription = "Home",
                    modifier = Modifier.scale(2f)
                )
            }
            IconButton(
                onClick = { navController.navigate("CheckoutScreen") },

                modifier = Modifier
//                    .offset(x = 80.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.btn_setting),
                    contentDescription = "Home",
                    modifier = Modifier.scale(2f)
                )
            }
        }

    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductGrid(
    navController: NavHostController,
    number: Int,
    count: Int = 0
) {
    val viewModel = viewModel<ProductViewModel>()
    val state = viewModel.viewState.collectAsState().value
    var CartCout = Datasource.cartBurgerList.size

    Scaffold(
        bottomBar = {
            BottomAppbarProductGrid(navController = navController)
        },

        floatingActionButton = {
            FloatingButton(state.cartBurgerList.size +
                    state.cartComboList.size +
                    state.cartSideList.size +
                    state.cartDrinkList.size,navController=navController)
//            FloatingButton(
//                state.cartBurgerList.size +
//                        state.cartComboList.size +
//                        state.cartSideList.size +
//                        state.cartDrinkList.size
//            )


        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = Modifier.background(Color.Transparent)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            ConstraintLayout {
                val (topImg, profile) = createRefs()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .background(
                            color = Color(239, 42, 57, 255),
                            shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                        )
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.height(100.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "FoodApp",
                            color = Color(red = 63, green = 63, blue = 63, alpha = 255),
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row {
                            Text(
                                text = "Order your favourite food!",
                                color = Color(red = 63, green = 63, blue = 63, alpha = 255),
                                fontSize = 17.sp
                            )
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier
                            .scale(3.5f)
                            .offset(y = 12.dp, x = 35.dp)
                    )
                }
            }

            val textState = remember { mutableStateOf(TextFieldValue("")) }
            SearchView(state = textState, placeHolder = "Search here . . .", modifier = Modifier)
            val searchedText = textState.value.text

            var selectedCategory by remember { mutableStateOf(Datasource.danhmuc.first()) }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 5.dp, bottom = 5.dp),
            ) {
                itemsIndexed(Datasource.danhmuc) { index, danhmuc ->
                    val isSelected = danhmuc == selectedCategory
                    val backgroundColor = if (isSelected) Color(red = 239, green = 42, blue = 57, alpha = 255) else Color(red = 240, green = 237, blue = 237, alpha = 255)
                    val contentColor = if (isSelected) Color.White else Color.Gray
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .selectable(
                                selected = isSelected,
                                onClick = { selectedCategory = danhmuc })
                            .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
                            .padding(15.dp)
                            .shadow(elevation = 0.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = danhmuc.categoryName,
                            style = MaterialTheme.typography.bodyLarge,
                            color = contentColor,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1
                        )
                    }
                }
            }

            when (selectedCategory) {
                Danhmuc("Burger") -> BurgerScreen(search = searchedText, navController = navController)
                Danhmuc("Combo") -> ComboScreen(search = searchedText, navController = navController)
                Danhmuc("Side dishes") -> SideScreen(search = searchedText, navController = navController)
                Danhmuc("Drinks") -> DrinkScreen(search = searchedText, navController = navController)
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    modifier: Modifier,
    placeHolder: String
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .padding(top = 10.dp, bottom = 10.dp)
            .requiredHeightIn(max = 50.dp),
        placeholder = {
            Text(
                text = placeHolder,
                textAlign = TextAlign.Center,

                )
        },
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.search), contentDescription = null,
                modifier = Modifier
                    .scale(0.9f)

            )
        },
        shape = RoundedCornerShape(40.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            disabledContainerColor = Color.White
        ),
        maxLines = 1,
        singleLine = true,
//        textStyle = TextStyle(
//            fontSize = 20.sp
//        )
    )
}

@Composable
fun BurgerScreen(search: String, navController: NavHostController, ) {
    val viewModel= viewModel<ProductViewModel>()
    val state = viewModel.viewState.collectAsState().value
    var searchedText = search

//    state.cartBurgerList.let { Datasource.cartBurgerList =it as ArrayList<Product> }



    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 5.dp),
        modifier = Modifier
//            .padding(top = 10.dp)
//            .background(Color.Transparent, RoundedCornerShape(10.dp))
            .fillMaxHeight(0.9f),
    ) {
        items(
            items = Datasource.product.filter {
                it.name.contains(searchedText, ignoreCase = true)
            },
        ) {
            ProductCard(
                product = it,
                navController = navController,
            ){
                    product->
                viewModel.addtoCartBurger(product)

            }
        }

    }
}

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemAddToCart:(item:Product)->Unit,
) {
    Card(
        modifier = modifier
            .clickable {
                navController.navigate("OrderScreen")
            }
            .background(Color.Blue, shape = RoundedCornerShape(30.dp))
            .shadow(
                elevation = 9.dp,
                shape = RoundedCornerShape(30.dp),
            ),
//            .size(
//                width = 150.dp,
//                height = 220.dp
//            )
//            .padding( 5.dp)
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                //                .fillMaxSize()
                //                .requiredWidth(170.dp)
                //                .requiredWidthIn(170.dp)
                .background(Color.White)
            //                .height(250.dp)


        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    // cắt ảnh cho phù hợp
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)

                )
            }


            Column(

                modifier = Modifier
                    .padding(start = 10.dp)



            ) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,

                    )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            Text(
                                text = "$${product.star}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255)
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            onItemAddToCart(product)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    CircleShape
                                )
                                .fillMaxSize(0.8f)
                            ,
                            tint = Color.White

                        )

                    }


                }


            }
        }
        //đóng colum tổng
    }
}

@Composable
fun ComboScreen(
    search: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,


    ) {
    val viewModel= viewModel<ProductViewModel>()
    val state = viewModel.viewState.collectAsState().value
    var searchedText = search
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 5.dp),
        modifier = Modifier
//            .padding(top = 10.dp)
//            .background(Color.Transparent, RoundedCornerShape(10.dp))
            .fillMaxHeight(0.9f),
    ) {
        items(
            items = Datasource.combo.filter {
                it.name.contains(searchedText, ignoreCase = true)
            },
        ) {
            ComboCard(
                combos = it,
                navController = navController
            ){
                    combos->
                viewModel.addtoCartCombo(combos)
            }
        }

    }
}

@Composable
fun ComboCard(
    combos: Combo,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemAddToCart: (item: Combo) -> Unit
) {
    Card(
        modifier = modifier
            .clickable {
                navController.navigate("OrderScreen")
            }
            .background(Color.Blue, shape = RoundedCornerShape(30.dp))
            .shadow(
                elevation = 9.dp,
                shape = RoundedCornerShape(30.dp),
            ),
//            .size(
//                width = 150.dp,
//                height = 220.dp
//            )
//            .padding( 5.dp)
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                //                .fillMaxSize()
                //                .requiredWidth(170.dp)
                //                .requiredWidthIn(170.dp)
                .background(Color.White)
            //                .height(250.dp)


        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = combos.image),
                    contentDescription = null,
                    // cắt ảnh cho phù hợp
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .size(120.dp)

                )
            }
            //close box

            Column(

                modifier = Modifier
                    .padding(start = 10.dp)
                //                    .scale(0.9f),


            ) {
                Text(
                    text = combos.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,

                    )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.star),
//                                contentDescription = null,
//                                modifier = Modifier.scale(1f)
//                            )
                            Text(
                                text = "$${combos.star}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255)
                            )
                        }
                    }
                    IconButton(
                        onClick = {onItemAddToCart(combos)},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    CircleShape
                                )
                                .fillMaxSize(0.8f)
                            ,
                            tint = Color.White

                        )
                    }


                }


            }
        }
        //đóng colum tổng
    }
}

@Composable
fun SideScreen(
    search: String,
    navController: NavHostController

) {

    val viewModel = viewModel<ProductViewModel>()
    val state =viewModel.viewState.collectAsState().value
    var searchedText = search
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 5.dp),
        modifier = Modifier
//            .padding(top = 10.dp)
//            .background(Color.Transparent, RoundedCornerShape(10.dp))
            .fillMaxHeight(0.9f),
    ) {
        items(
            items = Datasource.side.filter {
                it.name.contains(searchedText, ignoreCase = true)
            },
        ) {
            SideCard(
                side = it,
                navController = navController
            ){side ->
                viewModel.addtoCartSide(side)

            }
        }

    }
}

@Composable
fun SideCard(
    side: Side,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemAddtoCart:(item:Side)->Unit
) {
    Card(
        modifier = modifier
            .clickable {
                navController.navigate("OrderScreen")
            }
            .background(Color.Blue, shape = RoundedCornerShape(30.dp))
            .shadow(
                elevation = 9.dp,
                shape = RoundedCornerShape(30.dp),
            ),
//            .size(
//                width = 150.dp,
//                height = 220.dp
//            )
//            .padding( 5.dp)
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                //                .fillMaxSize()
                //                .requiredWidth(170.dp)
                //                .requiredWidthIn(170.dp)
                .background(Color.White)
            //                .height(250.dp)


        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = side.image),
                    contentDescription = null,
                    // cắt ảnh cho phù hợp
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(120.dp)

                )
            }
            //close box

            Column(

                modifier = Modifier
                    .padding(start = 10.dp)
                //                    .scale(0.9f),


            ) {
                Text(
                    text = side.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,

                    )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.star),
//                                contentDescription = null,
//                                modifier = Modifier.scale(1f)
//                            )
                            Text(
                                text = "$${side.star}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255)
                            )
                        }
                    }
                    IconButton(
                        onClick = {onItemAddtoCart(side)},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    CircleShape
                                )
                                .fillMaxSize(0.8f)
                            ,
                            tint = Color.White

                        )
                    }


                }


            }
        }
        //đóng colum tổng
    }
}

@Composable
fun DrinkScreen(search: String, navController: NavHostController) {
    var searchedText = search
    var viewModel = viewModel<ProductViewModel>()
    val state = viewModel.viewState.collectAsState().value
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 5.dp),
        modifier = Modifier
//            .padding(top = 10.dp)
//            .background(Color.Transparent, RoundedCornerShape(10.dp))
            .fillMaxHeight(0.9f),
    ) {
        items(
            items = Datasource.drink.filter {
                it.name.contains(searchedText, ignoreCase = true)
            },
        ) { drink ->
            DrinkCard(
                drink = drink,
                navController = navController
            ){
                    drink->
                viewModel.addtoCartDrink(drink)
            }
        }

    }
}

@Composable
fun DrinkCard(
    drink: Drink, modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemAddtoCart: (item: Drink) -> Unit
) {
    Card(
        modifier = modifier
            .clickable {
                navController.navigate("OrderScreen")
            }
            .background(Color.Blue, shape = RoundedCornerShape(30.dp))
            .shadow(
                elevation = 9.dp,
                shape = RoundedCornerShape(30.dp),
            ),
//            .size(
//                width = 150.dp,
//                height = 220.dp
//            )
//            .padding( 5.dp)
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                //                .fillMaxSize()
                //                .requiredWidth(170.dp)
                //                .requiredWidthIn(170.dp)
                .background(Color.White)
            //                .height(250.dp)


        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = drink.image),
                    contentDescription = null,
                    // cắt ảnh cho phù hợp
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(top = 3.dp)
                        .size(120.dp)

                )
            }
            //close box

            Column(

                modifier = Modifier
                    .padding(start = 10.dp)
                //                    .scale(0.9f),


            ) {
                Text(
                    text = drink.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,

                    )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.star),
//                                contentDescription = null,
//                                modifier = Modifier.scale(1f)
//                            )
                            Text(
                                text = "$${drink.star}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255)
                            )
                        }
                    }
                    IconButton(
                        onClick = {onItemAddtoCart(drink)},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    CircleShape
                                )
                                .fillMaxSize(0.8f)
                            ,
                            tint = Color.White

                        )
                    }


                }


            }
        }
        //đóng colum tổng
    }
}



@Preview
@Composable
fun ProductPreview() {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        val navController = rememberNavController()
        ProductGrid(navController = navController, number = 0)
    }
//    FloatingButton()
}
