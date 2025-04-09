package com.example.foodapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme

//import com.vku.doancoso3.R
//import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarEditProfileScreen(  navController: NavHostController){
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(Color(239, 42, 57, 255))
    ) {
        TopAppBar(
            title = {},

            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigate("DashBoard")

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            colors = topAppBarColors(
                containerColor = Color(239, 42, 57, 255),

            ),
        )
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditProfileScreen(
    navController: NavHostController

){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                AppBarEditProfileScreen(navController)
            },
            modifier = Modifier
        ){
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 125.dp)
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(Color(255, 255, 255, 255))
        ) {
//            Spacer(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
//            )
            Column(
                modifier = Modifier
                    .padding(top = 90.dp, start = 15.dp, end = 15.dp)
                    .fillMaxSize()
                    .background(Color(255, 255, 255, 255)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                MyOutlinedTextField("Name", Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlinedTextField("Email", Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlinedTextField("Delivery address", Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlinedTextField("Password", Color.Gray, isPassword = true)

                Spacer(modifier = Modifier.height(30.dp))
                Divider(
                    color = Color(185, 179, 179, 255),
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(start = 35.dp, end = 35.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent,
                        contentColor = Color.Gray
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Payment Details",
                            fontSize = 17.sp,
                            modifier = Modifier
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(27.dp)
                        )
                    }

                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent,
                        contentColor = Color.Gray
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Order history",
                            fontSize = 17.sp,
                            modifier = Modifier
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(27.dp)
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .padding(top = 50.dp, bottom = 10.dp)
                        .height(60.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(red = 77, green = 72, blue = 72, alpha = 255),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5f),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            Text("Edit Profile",
                                fontSize = 18.sp,
                                modifier = Modifier
                            )

                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }

                    Button(
                        onClick = {navController.navigate(route = LoginRoutes.SignIn.name)

                                  },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(red = 255, green = 255, blue = 255, alpha = 255),
                            contentColor = Color(239, 42, 57, 255)
                        ),
                        modifier = Modifier
                            .fillMaxHeight()
                            .border(3.dp, Color(239, 42, 57, 255), RoundedCornerShape(16.dp))
                            .weight(0.5f),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            Text("Log out",
                                fontSize = 18.sp,
                                modifier = Modifier
                            )

                            Icon(
                                imageVector = Icons.Filled.ExitToApp,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }

            }
        }
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .align(Alignment.TopCenter)
        )
        {


            Image(
                painter = painterResource(id = R.drawable.btn_profile) ,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(150.dp)

                    .background(shape = CircleShape, color = Color(255, 245, 246, 255))
                    .border(3.dp, Color(250, 33, 33, 255), CircleShape)
                    .shadow(
                        shape = CircleShape,
                        elevation = 50.dp,
                        ambientColor = Color(252, 21, 0, 255),
                        spotColor = Color(255, 0, 0, 255)
                    )
            )
        }



    }


}

fun Surface(shape: RoundedCornerShape, modifier: Modifier) {

}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField(label: String, borderColor: Color, isPassword: Boolean = false) {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val imeOptions = if (isPassword) ImeAction.Done else ImeAction.Next
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Gray,
        unfocusedBorderColor = Color.Gray,
        cursorColor = Color.Gray,

    )
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = label, color = Color.Gray) },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeOptions),
        keyboardActions = KeyboardActions(
            onDone = {
                if (isPassword) {
                    // Handle password submission
                    keyboardController?.hide()
                } else {
                    // Move focus to the next field
                    keyboardController?.hide()
                }
            }
        ),
        colors = textFieldColors,
        singleLine = true,
        visualTransformation = if (isPassword){
            PasswordVisualTransformation()
        } else{
            VisualTransformation.None
        },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),

    )
}

@Preview
@Composable
fun EditProfileScreenPreview(){
    DoAnCoSo3Theme {
        val navController= rememberNavController()
        EditProfileScreen(navController=navController)
    }
}


