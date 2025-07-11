package com.vku.doancoso3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.foodapp.ui.Nav
//import com.example.foodapp.ui.CustomizeScreen
//import com.vku.doancoso3.ui.Login.Navigation
import com.vku.doancoso3.ui.Login.login.LoginViewModel
import com.vku.doancoso3.ui.theme.DoAnCoSo3Theme
//import com.vku.doancoso3.ui.EditProfileScreen
//import com.vku.doancoso3.ui.OrderScreen

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel> ()
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel= androidx.lifecycle.viewmodel.compose.viewModel(modelClass =LoginViewModel::class.java )
            DoAnCoSo3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                   Nav(loginViewModel = loginViewModel)


                 }
//
                }
            }
        }
    }


