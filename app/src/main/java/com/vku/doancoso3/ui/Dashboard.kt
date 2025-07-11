package com.vku.doancoso3.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier
//            .requiredHeightIn(max = 60.dp)
//            .requiredHeightIn(min = 100.dp, max = 120.dp)
//            .padding(bottom = 18.dp)
//            .background(Color.Transparent)
//            .background(Color(android.graphics.Color.parseColor("#eeeefb")))
                ,
        containerColor = Color(android.graphics.Color.parseColor("#eeeefb")),

        bottomBar = {
            AppBarDashBoard(navController = navController)
        },

        floatingActionButton = {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .offset(x = -0.dp, y = 45.dp)
//                    .background(Color.Blue)
                    .background(
                        Color(android.graphics.Color.parseColor("#eeeefb")),
                        shape = RoundedCornerShape(45.dp)
                    )
                ,
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = {

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
        },
        floatingActionButtonPosition = (
                FabPosition.Center
        ),
    ){
        Column(
            modifier = Modifier
//                .padding(bottom = 20.dp)
                .fillMaxSize()
                .background(color = Color(android.graphics.Color.parseColor("#eeeefb")))
//            .verticalScroll(rememberScrollState())

            ,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            ConstraintLayout {
                // topImg và profile là hai tham chiếu được
                // tạo ra từ createRefs()
                val (topImg, profile) = createRefs()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        // ràng buộc vị trí
                        .constrainAs(topImg) {
                            // đặt phần tử trên cùng của constrainLayout
                            // parent ở đây là constraint Layout
                            top.linkTo(parent.top)
                            // nằm bên trái
                            start.linkTo(parent.start)

                        }
                        .background(
                            color = Color(
                                android.graphics.Color.parseColor("#EF2A39")
                            ),
                            shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                        )
                )
                //hàng 1
                Row(
                    modifier = Modifier
                        .padding(
                            top = 28.dp,
                            start = 24.dp, end = 24.dp
                        )
                        .fillMaxWidth(),

                    ) {
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .padding(start = 14.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "FoodApp",
                            color = Color.White,
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.location),
                                contentDescription = null,
                                Modifier.height(25.dp)
//
                            )
                            Text(
                                text = "  Da Nang,Viet Nam",
                                color = Color.White
                            )
                        }
                    }
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        Modifier
                            .scale(0.6f)
                            .offset(y = -50.dp, x = 30.dp)
                            .clickable { },
                    )


                }

                // hàng 2
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(start = 24.dp, end = 24.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )

                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                        }


                ) {
                    // cot 1 hang 2
                    Column(
                        modifier = Modifier
                            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 12.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#F07070")),
                                shape = RoundedCornerShape(20.dp),
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {


                        Text(
                            text = "Fries",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
//                            modifier = Modifier.padding(top = 24.dp)

                        )


                        Image(
                            painter = painterResource(R.drawable.fries),
                            contentDescription = null,
                            modifier = Modifier
                                .scale(1f)
                                .padding(bottom = 5.dp),

                            )


                    }

                    // het cot 1 hang 2
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#F07070")),
                                shape = RoundedCornerShape(20.dp),
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {


                        Text(
                            text = "Salad",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
//                            modifier = Modifier.padding(top = 24.dp)

                        )
                        Image(
                            painter = painterResource(R.drawable.salad),
                            contentDescription = null,
                            modifier = Modifier
                                .scale(1.2f)
                                .padding(bottom = 5.dp),

                            )


                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                            .height(90.dp)
                            .width(90.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#F07070")),
                                shape = RoundedCornerShape(20.dp),
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        verticalArrangement = Arrangement.Center

                    ) {


                        Text(
                            text = "Taco",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
//                            modifier = Modifier.padding(top = 24.dp)

                        )
                        Image(
                            painter = painterResource(R.drawable.taco),
                            contentDescription = null,
                            modifier = Modifier
                                .scale(1f)
                                .padding(bottom = 5.dp),

                            )


                    }


                }

                // hết hàng 2

            }
            // het constrain layout


            // dong seach
            var text by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { it },
                label = { Text(text = "Search for...") },
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.search), contentDescription = null,
                        Modifier.scale(1f)
//                        .offset(x=40.dp,y=-60.dp)
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                ),


                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp),
            )
//        TextField(value = text,
//            onValueChange = {it},
//            colors = TextFieldDefaults.colors(
//                forcused
//            )
//        )

//        hết dòng seach
//         hàng 4

            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, end = 24.dp, start = 24.dp, bottom = 20.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                    .height(145.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#FF3D3D")),
                                Color(android.graphics.Color.parseColor("#F07070"))
                            )
                        ),
                        shape = RoundedCornerShape(25.dp)

                    )
            ) {
                val (img, text1, text2, button) = createRefs()

                Image(
                    modifier = Modifier
                        .scale(2.5f)

                        .offset(x = -20.dp)

                        .constrainAs(img) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)

                        },
                    painter = painterResource(R.drawable.egg),
                    contentDescription = null
                )
                Text(
                    text = "The Fastest",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 22.dp, start = 32.dp)
                        .constrainAs(text1) {
                            top.linkTo(parent.top)


                            start.linkTo(parent.start)
                        }

                )
                Text(
                    text = "Food Delivery",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 22.dp, start = 32.dp, bottom = 90.dp)
                        .constrainAs(text2) {
                            top.linkTo(text1.bottom)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)

                        }

                )
                Button(
                    onClick = {

                        navController.navigate("ProductGrid")

                    },
                    modifier = Modifier
                        .offset(x = 30.dp, y = 80.dp)


                        .constrainAs(button) {


                        },
                    shape = RoundedCornerShape(10.dp),

                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = Color.Red
                    )

                ) {
                    Text(
                        text = "ORDER NOW",
                        fontWeight = FontWeight.Bold

                    )


                }


            }
            // hàng 5
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp,)
                    .scale(0.85f)
            )
            {
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher2),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(bottom = 12.dp)
                            .offset(y = -2.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Hỗ trợ ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher3),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher2),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }


            }



            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
                    .scale(0.85f)
            )
            {
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher2),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(bottom = 12.dp)
                            .offset(y = -2.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Hỗ trợ ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher3),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.voucher2),

                        contentDescription = null,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(top = 8.dp, bottom = 12.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)

                    )
                    Text(
                        text = "Khung giờ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Săn sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )


                }


            }

//        productGrid()
//        MyUi(navController = navController)


        }

    }




}

// bottom
//data class BottomMenuItem(val label: String, val icon: Painter)
//
//@Composable
//private fun prepareBottomMenu(): List<BottomMenuItem> {
//    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
//
//    bottomMenuItemList.add(
//        BottomMenuItem(
//            label = "Home",
//            icon = painterResource(id = R.drawable.btn_home)
//        )
//    )
//    bottomMenuItemList.add(
//        BottomMenuItem(
//            label = "Profile",
//            icon = painterResource(id = R.drawable.btn_profile)
//        )
//    )
//    bottomMenuItemList.add(
//        BottomMenuItem(
//            label = "Support",
//            icon = painterResource(id = R.drawable.btn_chat)
//        )
//    )
//    bottomMenuItemList.add(
//        BottomMenuItem(
//            label = "Setting",
//            icon = painterResource(id = R.drawable.btn_setting)
//        )
//    )
//
//
//    return bottomMenuItemList
//}


//@Composable
//fun MyBottomBar(){
//    val bottomMenuItemList =  prepareBottomMenu()
//    val contextForToast = LocalContext.current.applicationContext
//    val  selectedItem by remember {
//        mutableStateOf("Profile")
//    }
//
//   BottomAppBar(modifier = Modifier.clip(RoundedCornerShape(topEnd = 20.dp, topStart = 30.dp)), containerColor = Color.DarkGray){
//             bottomMenuItemList.forEachIndexed{index,bottomMenuItem->
//                 if (index==2){
//
//                 }
//             }
//
//
//
//   }
//
//
//
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarDashBoard(navController: NavHostController){

    BottomAppBar (
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        containerColor = Color(android.graphics.Color.parseColor("#EF2A39"))
    ){
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
                onClick = { /*TODO*/ },

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
fun MyUi(
    navController: NavHostController

) {
//    val scaffoldState = rememberScrollState()

    Scaffold(
        modifier = Modifier
//            .requiredHeightIn(max = 60.dp)
//            .requiredHeightIn(min = 100.dp, max = 120.dp)
            .padding(bottom = 18.dp),
//            .background(Color.Transparent)
//            .background(Color(android.graphics.Color.parseColor("#eeeefb")))
        containerColor = Color(android.graphics.Color.parseColor("#eeeefb")),

        bottomBar = {
                    AppBarDashBoard(navController = navController)
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color(android.graphics.Color.parseColor("#EF2A39")))
//                    .requiredHeightIn(min = 60.dp)                , verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//
//
//                IconButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier.offset(x = -80.dp)
//
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.btn_home),
//                        contentDescription = "Home",
//                        modifier = Modifier.scale(2f),
//
//                        )
//                }
//                IconButton(
//                    onClick = {
//                        navController.navigate("EditProfileScreen")
//                    },
//                    modifier = Modifier.offset(x = -50.dp)
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.btn_profile),
//
//                        contentDescription = "Home",
//                        modifier = Modifier
//                            .scale(2f)
//                    )
//                }
//
//
//                IconButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier.offset(x = 50.dp)
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.btn_chat),
//                        contentDescription = "Home",
//                        modifier = Modifier.scale(2f)
//                    )
//                }
//                IconButton(
//                    onClick = { /*TODO*/ },
//
//                    modifier = Modifier.offset(x = 80.dp)
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.btn_setting),
//                        contentDescription = "Home",
//                        modifier = Modifier.scale(2f)
//                    )
//                }
//
//
//            }


        },

        floatingActionButton = {
            Box(
                modifier = Modifier
                    .size(90.dp)
//                    .offset(x = -138.dp, y = 50.dp)
//                    .background(Color.Blue)
                    .background(
                        Color(android.graphics.Color.parseColor("#eeeefb")),
                        shape = RoundedCornerShape(45.dp)
                    )
                ,
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = {

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
//                    modifier = Modifier.offset(x = -150.dp, y = 40.dp)

                ) {
                    Icon(
                        painter = painterResource(R.drawable.btn_cart),
                        contentDescription = null,
                        modifier = Modifier.scale(1.5f)
                    )


                }
            }


        },
        floatingActionButtonPosition = (
            FabPosition.Center
        ),

    ){


    }

}


@Preview
@Composable
fun dashboardPreview() {
    DoAnCoSo3Theme {
        val navController = rememberNavController()

        Dashboard(navController = navController)
//        AppBarDashBoard(navController = navController)
    }
}