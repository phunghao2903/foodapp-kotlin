package com.example.foodapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vku.doancoso3.MainViewModel
import com.vku.doancoso3.ui.Dashboard
//import com.vku.doancoso3.ui.Login.HomeRoutes
//import com.vku.doancoso3.ui.Login.LoginRoutes
import com.vku.doancoso3.ui.Login.login.LoginScreen
import com.vku.doancoso3.ui.Login.login.LoginViewModel
import com.vku.doancoso3.ui.Login.signup.SignUpScreen
import com.vku.doancoso3.ui.Product.CustomizeScreen
import com.vku.doancoso3.ui.Product.OrderScreen
import com.vku.doancoso3.ui.Product.checkout.CheckoutScreen
import com.vku.doancoso3.ui.Product.checkout.OrderSummaryScreen



enum class LoginRoutes {
    Signup,
    SignIn
}

enum class HomeRoutes {
    Home,

}



@Composable
fun Nav(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel


) {



    NavHost(navController = navController, startDestination = "GetStarted") {

        composable(route = "GetStarted") {
            GetStarted(navController)
        }
        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(
                onNavToHomePage = {

                    navController.navigate(HomeRoutes.Home.name) {
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignIn.name) {

                            inclusive = true
                        }
                    }
                },
                loginViewModel = loginViewModel


            ) {

                navController.navigate(LoginRoutes.Signup.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }


            }
        }
        composable(route = LoginRoutes.Signup.name) {
            SignUpScreen(
                onNavToHomePage = {
                    navController.navigate(LoginRoutes.SignIn.name) {
                        popUpTo(LoginRoutes.Signup.name) {
                            inclusive = true
                        }
                    }
                },
                loginViewModel = loginViewModel

            ) {

                navController.navigate(LoginRoutes.SignIn.name)

            }
        }


        composable(route = HomeRoutes.Home.name) {
            Dashboard(navController)
        }

        composable(route = "ProductGrid") {
            ProductGrid(navController,0)
        }

        composable(route = "EditProfileScreen") {
            EditProfileScreen(navController)
        }

        composable(route = "OrderScreen") {
            OrderScreen(navController)
        }

        composable(
            route = "CustomizeScreen/{number}/{spicy}",
            arguments = listOf(
                navArgument(name = "number") {
                    type = NavType.StringType
                },
                    navArgument(name = "spicy") {
                    type = NavType.IntType
                }

            )


        ) { backstackEntry ->
            CustomizeScreen(
                navController,
                number = backstackEntry.arguments?.getString("number"),
                spicy = backstackEntry.arguments?.getInt("spicy"),

            )


        }
        val viewModel = MainViewModel()
        composable(route = "OrderSummaryScreen"){
           OrderSummaryScreen(viewModel = viewModel , onSelectionChanged = {} ,navController)
        }

        composable(route = "Dashboard"){
            Dashboard(navController = navController)
        }

        composable(route = "CheckoutScreen") {
             CheckoutScreen(navController)
        }




    }


}