package com.vku.doancoso3.ui.Product


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme
import java.text.DecimalFormat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarOrderScreen(


    navController: NavHostController

) {
    TopAppBar(
        title = { /*TODO*/ },
        navigationIcon = {
            // Biểu tượng mũi tên nằm bên trái
            IconButton(onClick = {
                navController.navigate("ProductGrid")



            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.width(48.dp)
                )
            }



        },
        actions = {
            // Biểu tượng kính lúp nằm bên phải
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.width(48.dp)
            )
        }
    )
}

fun formatDecimal(total: Double): String {
    val decimalFormat = DecimalFormat("#.##")
    return decimalFormat.format(total)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OrderScreen(
    navController: NavHostController
) {
//    var spiceLevel by remember { mutableFloatStateOf(0f) }
    var spiceLevel by remember { mutableStateOf(0) }
    var portionCount by remember { mutableStateOf("0") }
    var portion by remember { mutableStateOf(0) }
    var total: Double
    if (portionCount.isBlank() || portionCount == "0") {
        total = 0.0
    } else {
        portion = portionCount.toInt()
        total = (4.12 * portion).toDouble()
    }

    var number = "2"

    Scaffold(
        topBar = {
            AppBarOrderScreen(navController=navController)
        }
    ) {
        // Nội dung của màn hình OrderScreen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 11.dp)
                .padding(end = 10.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.pngwing1),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 45.dp)
                    .width(450.dp) // Đặt chiều rộng
                    .height(250.dp) // Đặt chiều cao
            )
            Spacer(modifier = Modifier.height(5.dp))



            Text(
                "Cheeseburger Wendy's Burger",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    tint = Color(red = 250, green = 200, blue = 125, alpha = 255),
                    contentDescription = "Star Icon",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "4.9 - 26 mins",
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "The Cheeseburger Wendy's Burger is a classic fast food " +
                        "burger that packs a punch of flavor in every bite." +
                        "Made with a juicy beef patty cooked to perfection, it's" +
                        "topped with melted American cheese, crispy lettuce," +
                        "ripe tomato, and crunchy pickles.",
                color = Color.Gray,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(end = 5.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.width(180.dp),
                ) {
                    Text(
                        text = "Spicy",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Slider(
                        value = spiceLevel.toFloat(),
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
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {

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
                            textStyle = LocalTextStyle.current.copy(
                                color = Color.Black,
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
                                    portionCount = "0"
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
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidthIn(min = 110.dp, max = 200.dp)
                        .height(60.dp)
                        .background(
                            color = Color(239, 42, 57, 255),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(

                        text = "$${formatDecimal(total)}",
//                        text = "${spiceLevel}",
                        color = Color.White,
                        style = TextStyle(
                            background = Color(red = 239, green = 42, blue = 57, alpha = 255),

                            ),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                val context = LocalContext.current
                Button(
                    onClick = {

                        if(portion > 0 ){
                            navController.navigate("CustomizeScreen/$portion/$spiceLevel")
                        }
                        else {
                            Toast.makeText(context, "Portion must be greater than 0", Toast.LENGTH_SHORT).show()
                        }



                    },
                    modifier = Modifier
                        .width(210.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(red = 63, green = 63, blue = 63, alpha = 255),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Customize Food",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun OderScreenPreview() {
   DoAnCoSo3Theme {
       val navController= rememberNavController()
        OrderScreen(navController=navController)
    }
}