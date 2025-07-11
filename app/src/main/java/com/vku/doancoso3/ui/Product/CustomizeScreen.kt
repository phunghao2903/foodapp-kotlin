package com.vku.doancoso3.ui.Product

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.Data.Datasource
//import com.example.foodapp.R
import com.vku.doancoso3.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarCustomizeScreen(
    navController: NavHostController
){
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = {

                          navController.navigate("ProductGrid")

                },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CustomizeScreen(navController: NavHostController,number:String?,spicy:Int?){

    var spiceLevel by remember { mutableStateOf(spicy) }
    var portionCount by remember { mutableStateOf("$number") }
    var portion by remember { mutableStateOf(0) }
    var total: Double
    if (  portionCount == "0") {
        total = 0.0
    } else {
        if (number != null) {
            portion = portionCount.toInt()
        }
        total = (4.12 * portion)
    }



    Scaffold(
        topBar = {
            AppBarCustomizeScreen(navController=navController)
        },

    ){
        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 15.dp, start = 15.dp, end = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .scale(0.8f)
            ) {
                Row (
//                    horizontalArrangement = Arrangement.spacedBy(50.dp),
                    modifier = Modifier

//                    .aspectRatio(1f)

                ){
                    Image(
                        painter = painterResource(R.drawable.pngwing4),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.75f)
                            .offset(-30.dp, 120.dp)
                            .scale(3.2f),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(100.dp))
                    Column(

                        modifier = Modifier
                            .weight(1.25f)
                            .padding(top = 10.dp)
                    ) {
                        FirstWordBold(
                            text = "Customize Your Burger to Your Tastes. Ultimate Experience"
                            )
                        Spacer(modifier = Modifier.height(40.dp))
                        Text(
                            text = "Spicy",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,

                            )
                        spiceLevel?.let { it1 ->
                            Slider(
                                value = it1.toFloat(),
                                onValueChange = { spiceLevel = it.toInt() },
                                valueRange = 0f..100f,
                                colors = SliderDefaults.colors(
                                    thumbColor = Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    activeTrackColor = Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Mild",
                                color = Color(red = 67, green = 235, blue = 84, alpha = 255),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Hot",
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                        Text(
                            text = "Portion",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 5.dp)

                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                                .padding(start = 5.dp, end = 5.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Button(
                                onClick = {
                                    if (!portionCount.isBlank() && portionCount.toInt() > 0) {
                                        portionCount = (portionCount.toInt() - 1).toString()
                                    }

                                },
                                modifier = Modifier
                                    .padding(0.dp)
                                    .width(55.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    contentColor = Color.White
                                )
                            ) {

                                Text(
                                    "-",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }

                            BasicTextField(
                                value = portionCount,
                                onValueChange = { newValue ->
                                    portionCount = (newValue.toIntOrNull() ?: "").toString()
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Done

                                ),

                                singleLine = true,
                                textStyle = TextStyle(
                                    fontSize = 25.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(40.dp)
                                    .padding(top = 10.dp)

                            )

                            Button(
                                onClick = {
                                    if (portionCount.isBlank()) {
                                        portionCount = number.toString()
                                    }
                                    portionCount = (portionCount.toInt() + 1).toString()
                                },
                                modifier = Modifier
                                    .padding(0.dp)
                                    .width(55.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color(red = 239, green = 42, blue = 57, alpha = 255),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    "+",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Toppings",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),

//                contentPadding = PaddingValues(top = 5.dp),
                modifier = Modifier
                    .requiredHeightIn(min = 250.dp)
//            .padding(top = 10.dp)
//            .background(Color.Transparent, RoundedCornerShape(10.dp))

            ){
                items(6) { index ->
                    Box(
                        modifier = Modifier

                            .height(105.dp)
                            .width(90.dp)
                            .padding(5.dp)
                            .shadow(8.dp, RoundedCornerShape(16.dp))
                            .background(
                                Color(red = 77, green = 72, blue = 72, alpha = 255),
                                RoundedCornerShape(16.dp)
                            )
//

                    ) {
                        when (index) {
                            0 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pngwing15),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp, )
                                    ) {
                                        Text(
                                            "Tomato",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier

                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )


                                            )
                                        }
                                    }
                                }
                            }
                            1 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pngwing16),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Fit
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp)
                                    ) {
                                        Text(
                                            "Onions",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )

                                            )
                                        }
                                    }
                                }
                            }
                            2 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pngwing17),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp)
                                    ) {
                                        Text(
                                            "Pickles",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )

                                            )
                                        }
                                    }
                                }
                            }
                            3 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pngwing18),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp)
                                    ) {
                                        Text(
                                            "Bacons",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )

                                            )
                                        }
                                    }
                                }
                            }
                            4 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pngwing12),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp)
                                    ) {
                                        Text(
                                            "Salad",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )

                                            )
                                        }
                                    }
                                }
                            }
                            5 -> {
                                Column {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(70.dp)
                                            .background(Color.White, RoundedCornerShape(16.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.cheese),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(70.dp)
                                                .height(65.dp)

                                                .padding(top = 10.dp)
                                                .background(Color.White, RoundedCornerShape(8.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row(
                                        modifier = Modifier
                                            .padding( start = 10.dp)
                                    ) {
                                        Text(
                                            "Cheese",
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier
                                                .scale(0.8f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .background(
                                                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                                                        CircleShape
                                                    )

                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(5.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//
//            ) {
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))

//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pngwing15),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Tomato",
//                                fontSize = 13.sp,
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pngwing16),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Fit
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Onions",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pngwing17),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Pickles",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pngwing18),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Bacons",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                "Side options",
//                fontSize = 17.sp,
//                fontWeight = FontWeight.Bold
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(5.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//
//            ) {
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.image14),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Fries",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.image15),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Fit
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Coleslaw",
//                                fontSize = 13.sp,
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.pngwing12),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Salad",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .background(
//                            Color(red = 77, green = 72, blue = 72, alpha = 255),
//                            RoundedCornerShape(16.dp)
//                        )
//                        .height(105.dp)
//                        .width(90.dp)
//                        .shadow(35.dp, RoundedCornerShape(10.dp))
//                ) {
//                    Column {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(70.dp)
//                                .background(Color.White, RoundedCornerShape(16.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pngwing14),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(65.dp)
//
//                                    .padding(top = 10.dp)
//                                    .background(Color.White, RoundedCornerShape(8.dp)),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier
//                                .padding(top = 0.dp, start = 5.dp, bottom = 5.dp)
//                        ) {
//                            Text(
//                                "Onion",
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                            IconButton(
//                                onClick = { /*TODO*/ },
//                                modifier = Modifier
//                                    .scale(0.8f)
//                            ) {
//                                Icon(
//                                    imageVector = Icons.Default.Add,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier
//                                        .background(
//                                            Color(red = 239, green = 42, blue = 57, alpha = 255),
//                                            CircleShape
//                                        )
//
//                                )
//                            }
//                        }
//                    }
//                }
//            }
            Row(
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidthIn(min = 110.dp, max = 200.dp)
                        .requiredHeightIn(min = 90.dp)
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(10.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column {
                        Text(
                            "Total",
                            fontWeight = FontWeight.Bold,
                        )
                        Row {
                            Text(
                                "$",
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "${formatDecimal(total)}",
                                color = Color(red = 63, green = 63, blue = 63, alpha = 255),

                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center

                            )
                        }
                    }

                }
                Button(
                    onClick = {
                              navController.navigate("OrderSummaryScreen")
                    },
                    modifier = Modifier
                        .width(210.dp)
                        .requiredHeightIn(min = 60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "ADD TO CART",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Composable
fun FirstWordBold(text: String) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 19.sp)) {
            append(text.substringBefore(" "))
        }
        append(" ")
        append(text.substringAfter(" "))
    }

    Text(
        text = annotatedString,
        textAlign = TextAlign.Start, // Thêm căn đều cả hai bên
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.bodyLarge,

        fontSize = 19.sp,

    )
}


@Preview
@Composable
fun CustomizeScreenPreview(){
    val navController = rememberNavController()
    CustomizeScreen(navController=navController,"0",0)
}

class CustomizeScreen {

}
