package com.example.foodapp.ui

//import androidx.compose.ui.node.CanFocusChecker.start
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme

@Composable
fun GetStarted(
  navController:NavHostController

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#EF2A39"))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(

        ) {
            Text(
                text = "FoodApp",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 70.sp,
                modifier = Modifier.padding(top = 200.dp),
                color = Color.White

            )
            Image(
                painter = painterResource(R.drawable.anh1),
                contentDescription = null,
                modifier = Modifier
                    .width(180.dp)
                    .padding(start = 30.dp),

                )
            Button(
                onClick = {
                          navController.navigate(LoginRoutes.SignIn.name)

                },
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 70.dp)
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(
                    Color.White   ,
                    contentColor = Color.Black)  ,






            ) {
                Image(
                    painter = painterResource(R.drawable.arrow)
                    ,
                    contentDescription = null,
                    modifier= Modifier
                        .offset(x = -40.dp)
                        .scale(1.2f)
                )

                Text(
                    text = "Get Started",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier=Modifier.offset(x=-10.dp)


                )
                
            }


        }



        Box(
            modifier = Modifier.padding(bottom = 0.dp),


            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp)


            ) {
                Image(
                    painter = painterResource(R.drawable.pngwing7),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(y = -20.dp, x = 15.dp)
                        .scale(1.7f)
                )
                Image(
                    painter = painterResource(R.drawable.pngwing1),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = 10.dp, y = 5.dp)
                        .scale(1.2f)

                )


            }


        }


    }
}


@Preview
@Composable
fun getStartedPreview() {
    DoAnCoSo3Theme {

//        GetStarted()
    }
}