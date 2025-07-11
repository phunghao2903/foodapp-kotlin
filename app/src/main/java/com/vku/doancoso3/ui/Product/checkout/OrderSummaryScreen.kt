package com.vku.doancoso3.ui.Product.checkout

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vku.doancoso3.MainViewModel
import com.vku.doancoso3.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarOrderSummary(){
    TopAppBar(
        title = {},

        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },

        actions = {
            IconButton(
                onClick = { /*TODO*/ }
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
fun OrderSummaryScreen(
    viewModel: MainViewModel,
    onSelectionChanged: (String) -> Unit = {},
    navController: NavHostController
){
    val context = LocalContext.current


    var optionMethodsScreen by remember { mutableStateOf(true) }
    var QRcodeScreen by remember { mutableStateOf(false) }

    var selectedValue by rememberSaveable { mutableStateOf("") }
    var options = listOf(
        Option("Cash payment", R.drawable.payment),
        Option("Transfer payment", R.drawable.mobile_payment)
    )

    Scaffold (
        topBar = {
            AppBarOrderSummary()
        },

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 45.dp, start = 10.dp, end = 5.dp, bottom = 5.dp)
                .fillMaxSize()
//                .background(Color.White)
        ) {
            Text(
                "Order Summary",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 20.dp, start = 5.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 5.dp, start = 10.dp, end = 5.dp, bottom = 5.dp)
//                    .background(Color.White),

                ) {
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement
                        .SpaceBetween

                ) {
                    Text(
                        "Order",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "$0",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement
                        .SpaceBetween

                ) {
                    Text(
                        "Taxes",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "$0",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement
                        .SpaceBetween

                ) {
                    Text(
                        "Delivery fees",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "$0",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color(185, 179, 179, 255),
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(start = 35.dp, end = 35.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement
                        .SpaceBetween

                ) {
                    Text(
                        "Total:",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "$0",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement
                        .SpaceBetween

                ) {
                    Text(
                        "Estimated delivery time:",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "15 - 30mins",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
            Text(
                "Payment methods",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 20.dp, start = 5.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            if (optionMethodsScreen) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    options.forEach { item ->
                        Row(
                            modifier = Modifier
                                .height(75.dp)
                                .fillMaxWidth()
                                .background(
                                    color = if (selectedValue == item.label) {
                                        Color(
                                            red = 63,
                                            green = 63,
                                            blue = 63,
                                            alpha = 255
                                        ) // Màu nền khi được chọn
                                    } else {
                                        Color(241, 243, 242, 255)// Màu nền khi không được chọn
                                    },
                                    RoundedCornerShape(16.dp)
                                )

                                .selectable(
                                    selected = selectedValue == item.label,
                                    onClick = {
                                        selectedValue = item.label
                                        onSelectionChanged(item.label)
                                    }
                                ),
                            horizontalArrangement = Arrangement
                                .SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(top = 10.dp, bottom = 5.dp)
                            )
                            Text(
                                item.label,
                                fontSize = 18.sp,
                                color = if (selectedValue == item.label) {
                                    Color.White // Màu chữ khi được chọn
                                } else {
                                    Color.Gray // Màu chữ khi không được chọn
                                },
                                modifier = Modifier
                                    .offset(x = 0.dp, y = 25.dp)
                            )
                            RadioButton(
                                selected = selectedValue == item.label,
                                onClick = {
                                    selectedValue = item.label
                                    onSelectionChanged(item.label)
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White, // Màu khi được chọn
                                    unselectedColor = Color.Gray // Màu khi không được chọn
                                ),
                                modifier = Modifier
                                    .offset(x = 0.dp, y = 15.dp)
                            )

                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
            if(QRcodeScreen){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(top = 5.dp, start = 10.dp, end = 5.dp, bottom = 5.dp)
                            .background(Color.White),

                        ) {
                        IconButton(
                            onClick = {
                                optionMethodsScreen = true
                                QRcodeScreen = false
                            },
                            modifier = Modifier
                                .size(18.dp)
                                .offset(x = 140.dp, y = -20.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement
                                .SpaceBetween

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_vietinbank___ctg_te),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .scale(3.5f)
                                    .offset(x = 7.dp, y = 0.dp)
                            )
                            Text(
                                "VietinBank",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center

                        ) {
                            Text(
                                "102876522344",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center

                        ) {
                            Text(
                                "Le Van Huy",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider(
                            color = Color(185, 179, 179, 255),
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 35.dp, end = 35.dp)
                                .fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement
                                .SpaceBetween

                        ) {
                            Text(
                                "Transfer content:",
                            )

                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 5.dp, bottom = 5.dp, start = 25.dp, end = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center

                        ) {
                            Text(
                                "Payment for someone’s order",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.qr_code),
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                    )


                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 80.dp, top = 150.dp,)
                    .requiredHeightIn(220.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                Box(
                    modifier = Modifier
                        .requiredWidthIn(min = 110.dp, max = 200.dp)
                        .requiredHeightIn(min = 90.dp)
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(top = 0.dp, start = 10.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column {
                        Text(
                            "Total price",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                        Row {
                            Text(
                                "$",
                                color = Color(red = 239, green = 42, blue = 57, alpha = 255),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "0",
                                color = Color(red = 63, green = 63, blue = 63, alpha = 255),

                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
                Button(
                    onClick = {
                        if ( selectedValue == "Cash payment"){
                            viewModel.onBuyClick()
                        } else if ( selectedValue == "Transfer payment" ) {
                            if(optionMethodsScreen == true) {
                                optionMethodsScreen = false
                                QRcodeScreen = true
                            }else {
                                viewModel.onBuyClick()
                            }

                        } else {
                            Toast.makeText(context, "Please choose a payment method", Toast.LENGTH_SHORT).show()

                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .width(210.dp)
                        .requiredHeightIn(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(red = 239, green = 42, blue = 57, alpha = 255),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "BUY NOW",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

        }
    }
    if (viewModel.isDialogShown){
        CustomDialog(
            onDismiss = {
                viewModel.onDismissDialog()
            },
            onConfirm = {
            },
            navController = navController
        )
    }
}


data class Option(val label: String, @DrawableRes val icon: Int)



@SuppressLint("SuspiciousIndentation")
@Preview
@Composable
fun OrderSummaryScreenPreview(){
    DoAnCoSo3Theme {
        val viewModel = MainViewModel()
        val navController = rememberNavController()
            OrderSummaryScreen(viewModel = viewModel, navController = navController)
    }
}

