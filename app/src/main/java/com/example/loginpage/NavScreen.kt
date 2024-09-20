package com.example.loginpage

sealed class NavScreen(val route: String) {
    object signup: NavScreen(route = "create_account")
    object signin: NavScreen(route = "existing_account")
}