package com.example.educonnect.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.educonnect.presentation.view.auth.ForgotPass
import com.example.educonnect.presentation.view.auth.Login
import com.example.educonnect.presentation.view.auth.SignIn

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController){
    navigation(
        route = NavigationScreenNames.AuthenticationRoute.route,
        startDestination = NavigationScreenNames.Login.route
    ){
        composable(route = NavigationScreenNames.Login.route){
            Login(navHostController)
        }
        composable(route = NavigationScreenNames.SignIn.route){
            SignIn(navHostController)
        }
        composable(route = NavigationScreenNames.ForgotPassword.route){
            ForgotPass(navHostController)
        }

    }
}