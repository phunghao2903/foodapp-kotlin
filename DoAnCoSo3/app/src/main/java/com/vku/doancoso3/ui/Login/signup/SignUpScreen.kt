package com.vku.doancoso3.ui.Login.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vku.doancoso3.R
import com.vku.doancoso3.ui.Login.login.LoginViewModel
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(

    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToLoginPage: () -> Unit,


    ) {

    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        if (isError) {
//            Text(
//                text = loginUiState?.signUpError ?: "unknown error",
//                color = Color.Red
//            )
//
//        }

        Spacer(Modifier.height(70.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .scale(2.2f)
//                    .offset(x = 20.dp)


        )
        Spacer(Modifier.height(80.dp))
        Text(
            text = "Food App",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 44.sp,
            color = Color(android.graphics.Color.parseColor("#EF2A39")),
            modifier = Modifier.padding(bottom = 18.dp)

        )

        var user by remember { mutableStateOf("Username") }
        var pass by remember { mutableStateOf("PassWord") }
        var passwordVisibile by rememberSaveable { mutableStateOf(false) }



        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#EF2A39")),
                    shape = RoundedCornerShape(50.dp)

                ),

            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },


            value = loginUiState?.userNameSignUp ?: "",
            onValueChange = { loginViewModel?.onUserNameChangeSignup(it) },
            shape = RoundedCornerShape(50.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
//                color = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),


            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                focusedBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledTextColor = Color.Black,
                focusedTextColor = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),

//            label = { Text(text = "Email") },
//            isError = isError,
            placeholder = { Text(text = "Email") },
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

        )




//        OutlinedTextField(
//
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(66.dp)
//                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
//                .border(
//                    1.dp,
//                    Color(android.graphics.Color.parseColor("#EF2A39")),
//                    shape = RoundedCornerShape(50.dp)
//
//                ),
//            value = loginUiState?.passwordSignUp ?: "",
//            onValueChange = { loginViewModel?.onPasswordChangeSignup(it) },
////            label = { Text(text = "Password") },
//            shape = RoundedCornerShape(50.dp),
//            textStyle = TextStyle(
//                textAlign = TextAlign.Center,
//                color = Color(android.graphics.Color.parseColor("#EF2A39"))
//            ),
//            leadingIcon = {
//                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
//            },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
//            visualTransformation = if (passwordVisibile) VisualTransformation.None
//            else PasswordVisualTransformation(),
//
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//
//            isError = isError,
//
//
//        )

        OutlinedTextField(

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#EF2A39")),
                    shape = RoundedCornerShape(50.dp)

                ),
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = { loginViewModel?.onPasswordChangeSignup(it) },
//            label = { Text(text = "Password") },
            shape = RoundedCornerShape(50.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
//                color = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                focusedBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledTextColor = Color.Black,
                focusedTextColor = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),
            visualTransformation = if (passwordVisibile) VisualTransformation.None
            else PasswordVisualTransformation(),

            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),

//            isError = isError,
            placeholder = { Text(text = "Password") }


        )



        OutlinedTextField(

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#EF2A39")),
                    shape = RoundedCornerShape(50.dp)

                ),
            value = loginUiState?.confirmPasswordSignUp ?: "",
            onValueChange = { loginViewModel?.onConfirmPasswordChange(it) },
//            label = { Text(text = "Password") },
            shape = RoundedCornerShape(50.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
//                color = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                focusedBorderColor = Color(android.graphics.Color.parseColor("#EF2A39")),
                disabledTextColor = Color.Black,
                focusedTextColor = Color(android.graphics.Color.parseColor("#EF2A39"))
            ),
            visualTransformation = if (passwordVisibile) VisualTransformation.None
            else PasswordVisualTransformation(),

            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),

//            isError = isError,
            placeholder = { Text(text = "Password checked") }


        )






        Button(
            onClick = { loginViewModel?.createUser(context) },
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .padding(start = 64.dp, end = 64.dp, top = 18.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                Color(android.graphics.Color.parseColor("#EF2A39")),
                contentColor = Color.White
            )

        ) {
            Text(
                text = "Sign Up",
                fontSize = 18.sp,


                )

        }
        if (isError) {
            Text(
                textAlign = TextAlign.Center,
                text = loginUiState?.signUpError ?: "unknown error",
                color = Color(253, 89, 90, 255),

                modifier = Modifier
                    .fillMaxWidth()
            )

        }


        Row {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier
                    .padding(38.dp)
                    .scale(1.5f)
            )
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier
                    .padding(38.dp)
                    .scale(1.5f)
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null,
                modifier = Modifier
                    .padding(38.dp)
                    .scale(1.5f)
            )
        }
        Row {
            Text(
                text = "Already have an Account?",
                modifier = Modifier.padding(top = 13.dp)
            )
            TextButton(onClick = { onNavToLoginPage.invoke() }) {
                Text(
                    text = "Log in",
                    color = Color(android.graphics.Color.parseColor("#EF2A39"))
                )
            }

        }


        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.loginUiState?.isSuccessLogin) {
            if(loginViewModel?.loginUiState?.isSuccessLogin== true && loginViewModel?.loginUiState?.isLoading == false ) {
                onNavToHomePage.invoke()
            }
        }


    }
// close column
}


@Preview
@Composable
fun LoginPreview() {
    DoAnCoSo3Theme {
        val loginViewModel: LoginViewModel
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}
