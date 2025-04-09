package com.vku.doancoso3.ui.Product.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vku.doancoso3.R

@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    navController: NavHostController

){
    Dialog(
        onDismissRequest = {
//            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.45f)
                .border(
                    1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.tick_circle_svgrepo_com),
                    contentDescription = null
                )
                Text(
                    "Success !",
                    color = Color(red = 239, green = 42, blue = 57, alpha = 255),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Order Success. Your order is awaiting confirmation",
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = {
                        onDismiss()
                        navController.navigate("Dashboard")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .requiredHeightIn(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color(red = 239, green = 42, blue = 57, alpha = 255)
                    )

                ) {
                    Text(
                        "Go back",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomDialogPreView(){
    val navController = rememberNavController()
        CustomDialog(
            onDismiss = { /*TODO*/ },
            onConfirm = { /*TODO*/ },
            navController = navController)
}
