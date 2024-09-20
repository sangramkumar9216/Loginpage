package com.example.loginpage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNav(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = NavScreen.signup.route){
            composable(route = NavScreen.signup.route){
                LoginScreen(navController = navController)

            }
            composable(route = NavScreen.signin.route){
            SignInScreen(navController = navController)
            }
    }
}